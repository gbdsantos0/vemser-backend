package com.dbc.emailapi.service;

import com.dbc.emailapi.dto.messaging.MailMessageDTO;
import com.dbc.emailapi.entity.MailMessage;
import com.dbc.emailapi.repository.MailRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {
    private final ObjectMapper objectMapper;
    private final MailRepository mailRepository;

//mail
    private final freemarker.template.Configuration fmConfiguration;
    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "${kafka.client-id}")
    public void consumeGeneral(@Payload String message,
                               @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                               @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MailMessageDTO mailMessageDTO = objectMapper.readValue(message, MailMessageDTO.class);

        MailMessage mailMessage = objectMapper.convertValue(mailMessageDTO,MailMessage.class);
        mailRepository.save(mailMessage);

        log.info("Offset -> '" + offset + "' key -> '" + key + "' -> Consumed Object message -> '" + message + "'");
    }

    @Scheduled(fixedDelay = 15000)
    public void sendStoredMails(){
        List<MailMessage> mailList = mailRepository.findAll();
        if(!mailList.isEmpty()){
            mailList.stream()
                    .map(m->objectMapper.convertValue(m,MailMessageDTO.class))
                    .collect(Collectors.toList())
                    .forEach(this::sendEmail);

            mailRepository.deleteAll(mailList);
        }
    }

    public void sendEmail(MailMessageDTO mailMessageDTO){
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(mailMessageDTO.getTitle());
            mimeMessageHelper.setTo(mailMessageDTO.getEmail());
            mimeMessageHelper.setText(getContentFromTemplateMail(mailMessageDTO), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
            log.info("ENVIEI O EMAIL ("+mailMessageDTO.getTitle()+") para o email: "+mailMessageDTO.getEmail());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String getContentFromTemplateMail(MailMessageDTO mailMessageDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("name", mailMessageDTO.getName());
        dados.put("message",mailMessageDTO.getMessage());
        dados.put("title",mailMessageDTO.getTitle());
        dados.put("supportMail",mailMessageDTO.getSupportMail());
        //setar caminho
        fmConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        Template template = fmConfiguration.getTemplate("email-template-padrao.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
