package com.dbc.pessoaapi.dto.endereco;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class EnderecoUpdateDTO extends EnderecoCreateDTO{
   /* @ApiModelProperty(value = "Id da pessoa dentro do endereço")
    @NotNull
    private Integer idPessoa;*/
}
