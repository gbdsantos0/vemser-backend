package com.dbc.produtorconsumidor.controller;

import com.dbc.produtorconsumidor.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-produtor")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/enviar")
    private void send(String message){
        producerService.sendMessage(message);
    }
}
