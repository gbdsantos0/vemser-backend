package com.dbc.pessoaapi.dto.contato;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO extends ContatoUpdateDTO{
    @ApiModelProperty(value = "Id do contato")
    private Integer idContato;
}
