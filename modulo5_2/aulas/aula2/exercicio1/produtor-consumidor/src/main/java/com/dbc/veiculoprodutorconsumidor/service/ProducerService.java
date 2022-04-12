package com.dbc.veiculoprodutorconsumidor.service;


import com.dbc.veiculoprodutorconsumidor.DTO.VehicleCreateDTO;
import com.dbc.veiculoprodutorconsumidor.DTO.VehicleDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic}")
    private String topic;//nome do topico puxado do app.properties

    public void sendMessage(String message){
        String topic = "meu-primeiro-topico";
        this.send(message, topic);
    }

    public void sendObject(Object object, String topic) throws JsonProcessingException {
        String convertedObject = objectMapper.writeValueAsString(object);
        this.send(convertedObject, topic);
    }

    public void sendVehicleData(VehicleCreateDTO vehicleDTO) throws JsonProcessingException {
        VehicleDTO vehicle = objectMapper.convertValue(vehicleDTO, VehicleDTO.class);
        vehicle.setDataLeitura(LocalDateTime.now());
        String message = objectMapper.writeValueAsString(vehicle);
        this.send(message, this.topic);
    }

    public void send(String message, String topic) {
        Message<String> message1 = MessageBuilder.withPayload(message)//construtor de mensagem setando a mensagem
                .setHeader(KafkaHeaders.TOPIC, topic)//seta o topico da mensagem
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())//seta a chave da mensagem
                .build();

        ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send(message1);//??

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Erro ao publicar dúvida no kafka com a mensaggem: {}", message, ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Log enviado para o kafka com o texto: {}", message);
            }
        });
    }
}
