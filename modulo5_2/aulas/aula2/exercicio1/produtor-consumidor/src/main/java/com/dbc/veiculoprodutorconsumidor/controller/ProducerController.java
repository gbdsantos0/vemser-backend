package com.dbc.veiculoprodutorconsumidor.controller;

import com.dbc.veiculoprodutorconsumidor.DTO.VehicleCreateDTO;
import com.dbc.veiculoprodutorconsumidor.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo-produtor")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/enviar-dados-carro")
    private void sendVehicleData(@RequestBody VehicleCreateDTO vehicleDTO) throws JsonProcessingException {
        producerService.sendVehicleData(vehicleDTO);
    }
}
