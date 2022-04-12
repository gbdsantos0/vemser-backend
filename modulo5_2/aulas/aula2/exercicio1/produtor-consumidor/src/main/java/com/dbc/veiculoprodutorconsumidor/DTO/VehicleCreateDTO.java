package com.dbc.veiculoprodutorconsumidor.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VehicleCreateDTO {
    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}
