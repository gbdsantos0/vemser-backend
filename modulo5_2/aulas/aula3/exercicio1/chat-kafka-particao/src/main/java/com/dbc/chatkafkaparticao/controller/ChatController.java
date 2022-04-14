package com.dbc.chatkafkaparticao.controller;

import com.dbc.chatkafkaparticao.enums.NomesChats;
import com.dbc.chatkafkaparticao.service.ChatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/enviar-mensagem")
    private void sendMessageTo(@RequestParam String message, @RequestParam List<NomesChats> destinatarios) throws JsonProcessingException {
        chatService.sendMessage(message,destinatarios);
    }
}
