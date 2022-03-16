package com.dbc.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {
    Integer idPessoa;

    @NotNull
    String tipoContato;

    @NotEmpty
    @Size(max=13)
    String numero;

    @NotEmpty
    String descricao;
}
