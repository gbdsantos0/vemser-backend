package com.dbc.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {
    private Integer idPessoa;
    @NotEmpty
    @Size(max=250)
    private String logradouro;
    @NotNull
    @Min(0)
    private Integer numero;
    @NotEmpty
    @Size(max=250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
    @NotNull
    private String tipo;
    @NotEmpty
    @Size(max=8)
    private String cep;
}
