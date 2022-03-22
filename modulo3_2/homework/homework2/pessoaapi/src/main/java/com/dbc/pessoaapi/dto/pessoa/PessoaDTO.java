package com.dbc.pessoaapi.dto.pessoa;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends PessoaCreateDTO{
    @ApiModelProperty(value = "Id da pessoa")
    private Integer idPessoa;
}
