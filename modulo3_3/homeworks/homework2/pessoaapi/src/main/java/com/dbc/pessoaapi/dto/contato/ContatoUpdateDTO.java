package com.dbc.pessoaapi.dto.contato;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoUpdateDTO extends ContatoCreateDTO{
    @ApiModelProperty(value = "Id da pessoa do contato")
    @NotNull
    Integer idPessoa;
}
