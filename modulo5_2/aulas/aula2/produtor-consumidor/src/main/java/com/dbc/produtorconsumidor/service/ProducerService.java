package com.dbc.produtorconsumidor.service;


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

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {
    private final KafkaTemplate<String,String> kafkaTemplate;

    @Value(value = "${kafka.topic}")
    private String topic;//nome do topico puxado do app.properties

    public void sendMessage(String message) {
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
