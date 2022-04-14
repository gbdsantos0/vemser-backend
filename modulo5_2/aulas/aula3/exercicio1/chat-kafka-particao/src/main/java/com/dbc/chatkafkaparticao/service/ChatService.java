package com.dbc.chatkafkaparticao.service;

import com.dbc.chatkafkaparticao.DTO.MensagemDTO;
import com.dbc.chatkafkaparticao.enums.NomesChats;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    //teste cores
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @Value("${kafka.client-name}")
    private String user;

    @Value("${kafka.general.topic}")
    private String topic;

    //METODO LISTENER PARA TOPICO PARTICULAR
    @KafkaListener(
//            topics = "${kafka.topic}",
            topicPartitions = {@TopicPartition(topic = "${kafka.general.topic}", partitions = {"${kafka.client-partition}"})},
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "private")
    public void consumeParticular(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MensagemDTO messageDTO = objectMapper.readValue(message, MensagemDTO.class);

        log.info(ANSI_GREEN+messageDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " [" + messageDTO.getUsuario() + "]"+ANSI_RED+"(privada)"+ANSI_GREEN+": "+ ANSI_RESET + messageDTO.getMensagem()+ ANSI_RESET);

        log.info("#### offset -> '" + offset + "' key -> '" + key + "' -> Consumed Object message -> '" + message + "'");
    }

    //METODO LISTENER PARA TOPICO GERAL
    @KafkaListener(
//            topics = "${kafka.general.topic}",
            topicPartitions = {@TopicPartition(topic = "${kafka.general.topic}", partitions = {"0"})},
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
    clientIdPrefix = "geral")
    public void consumeGeneral(@Payload String message,
                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                  @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MensagemDTO messageDTO = objectMapper.readValue(message, MensagemDTO.class);

        log.info(ANSI_GREEN+messageDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " [" + messageDTO.getUsuario() + "]: " + ANSI_RESET + messageDTO.getMensagem()+ ANSI_RESET);

        log.info("#### offset -> '" + offset + "' key -> '" + key + "' -> Consumed Object message -> '" + message + "'");
    }

    //METODOS PRODUTORES
    public void send(String message, Integer partition) {
        Message<String> builtMessage = MessageBuilder.withPayload(message)//construtor de mensagem setando a mensagem
                .setHeader(KafkaHeaders.TOPIC, topic)//seta o topico da mensagem
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())//seta a chave da mensagem
                .setHeader(KafkaHeaders.PARTITION_ID, partition)
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(builtMessage);//??

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

    public void sendMessage(String message, List<NomesChats> destinatarios) throws JsonProcessingException {
        MensagemDTO mensagemDTO = MensagemDTO.builder()
                .usuario(user)
                .mensagem(message)
                .dataCriacao(LocalDateTime.now())
                .build();

        String convertedMessage = objectMapper.writeValueAsString(mensagemDTO);

        for(NomesChats nomesChats:destinatarios){
            this.send(convertedMessage, nomesChats.ordinal());
        }
    }

}
