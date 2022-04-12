package com.dbc.veiculoprodutorconsumidor.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VehicleDTO {
    private LocalDateTime dataLeitura;
    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
