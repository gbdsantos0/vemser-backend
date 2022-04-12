package com.dbc.veiculoprodutorconsumidor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document("vehicle")
public class VehicleEntity {
    /*@Id
    private Integer id;*/
    private LocalDateTime dataLeitura;
    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}