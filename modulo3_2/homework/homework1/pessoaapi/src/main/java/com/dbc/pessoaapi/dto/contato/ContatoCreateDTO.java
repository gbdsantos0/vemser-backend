package com.dbc.pessoaapi.dto.contato;

import com.dbc.pessoaapi.enums.TipoContato;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {
    @ApiModelProperty(value = "tipo de contato")
    @NotNull
    TipoContato tipoContato;

    @ApiModelProperty(value = "numero do contato")
    @NotEmpty
    @Size(max=13)
    String numero;

    @ApiModelProperty(value = "descrição do contato")
    @NotEmpty
    String descricao;
}
