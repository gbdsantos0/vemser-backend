package com.dbc.veiculoprodutorconsumidor.controller;

import com.dbc.veiculoprodutorconsumidor.DTO.VehicleDTO;
import com.dbc.veiculoprodutorconsumidor.exception.RegraDeNegocioException;
import com.dbc.veiculoprodutorconsumidor.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veiculo-consumidor")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;
    @GetMapping("/todas-posicoes-salvas")
    public List<VehicleDTO> getAllPositionsSaved(){
        return vehicleService.getAll();
    }
    @GetMapping("/velocidade-media")
    public Double avgSpeed() throws Exception {
        return vehicleService.getAvgSpeed();
    }
    @GetMapping("/rotacao-media")
    public Double rpm() throws Exception {
        return vehicleService.getRpm();
    }
    @GetMapping("/total-leituras")
    public Integer readCount() throws Exception {
        return vehicleService.getReadCount();
    }
}
