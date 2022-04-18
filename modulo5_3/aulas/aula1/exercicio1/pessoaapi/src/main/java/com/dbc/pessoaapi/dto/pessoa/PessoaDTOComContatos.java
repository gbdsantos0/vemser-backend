package com.dbc.pessoaapi.dto.pessoa;

import com.dbc.pessoaapi.dto.contato.ContatoDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTOComContatos extends PessoaDTO{
    @ApiModelProperty(value = "Lista de contatos da pessoa")
    private List<ContatoDTO> contatos;
}
