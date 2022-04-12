package com.dbc.chatkafka.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class MensagemDTO {
    @NotEmpty
    private String usuario;
    @NotNull
    private String mensagem;
    @NotNull
    private LocalDateTime dataCriacao;
}
