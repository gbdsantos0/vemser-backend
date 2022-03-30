package com.dbc.pessoaapi.dto.endereco;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO extends EnderecoUpdateDTO{
    @ApiModelProperty(value = "Id do endereço")
    private Integer idEndereco;
}
