package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.messaging.MailMessageDTO;
import com.dbc.pessoaapi.dto.pessoa.PessoaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailProducerService {
    private final PessoaService pessoaService;
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.topic}")
    private String topic;

    //MODULO5_3
    //AULA1
    //EXERCICIO1
    @Scheduled(cron = "0 0 8,20 * * *")//fixedDelay = 15000)//
    public void sendScheduledEmailToUser() throws Exception {
        log.info("TO DENTRO DO EMAIL (diario 8/20 endereco presente)");
        List<PessoaDTO> pessoaDTOList = pessoaService.listPessoaSemEndereco();

        for(PessoaDTO pessoaDTO:pessoaDTOList){
            MailMessageDTO mailMessageDTO = MailMessageDTO.builder()
                    .title("Requisição de endereço")
                    .name(pessoaDTO.getNome())
                    .message("")
                    .supportMail("gustavo.barbosa@dbccompany.com.br")
                    .email(pessoaDTO.getEmail())
                    .build();

            this.send(objectMapper.writeValueAsString(mailMessageDTO), this.topic);
        }

    }

    //EXERCICIO2
    @Scheduled(fixedDelay = 15000)//cron = "0 0 0 1 * *")//
    public void sendScheduledMonthlyEmailToUser() throws Exception{
        log.info("TO DENTRO DO EMAIL (mensal promos)");
        List<PessoaDTO> pessoaDTOList = pessoaService.list();

        for(PessoaDTO pessoaDTO:pessoaDTOList){
            MailMessageDTO mailMessageDTO = MailMessageDTO.builder()
                    .title("Promoções Magazine OldSchool")
                    .name(pessoaDTO.getNome())
                    .message("")
                    .supportMail("gustavo.barbosa@dbccompany.com.br")
                    .email(pessoaDTO.getEmail())
                    .build();

            this.send(objectMapper.writeValueAsString(mailMessageDTO), this.topic);
        }
    }

    //HOMEWORK1
    @Scheduled(cron = "0 0 8 * * *")//fixedDelay = 15000)//
    public void sendScheduledDailyEmailToUser() throws Exception{
        log.info("TO DENTRO DO EMAIL (diario aniversario)");
        List<PessoaDTO> pessoaDTOList = pessoaService.listPessoaAniversario();

        for(PessoaDTO pessoaDTO:pessoaDTOList){
            MailMessageDTO mailMessageDTO = MailMessageDTO.builder()
                    .title("Hoje é o seu dia!")
                    .name(pessoaDTO.getNome())
                    .message("")
                    .supportMail("gustavo.barbosa@dbccompany.com.br")
                    .email(pessoaDTO.getEmail())
                    .build();

            this.send(objectMapper.writeValueAsString(mailMessageDTO), this.topic);
        }
    }

//kafka send message
    public void send(String message, String topic) {
        Message<String> builtMessage = MessageBuilder.withPayload(message)//construtor de mensagem setando a mensagem
                .setHeader(KafkaHeaders.TOPIC, topic)//seta o topico da mensagem
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())//seta a chave da mensagem
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
}
