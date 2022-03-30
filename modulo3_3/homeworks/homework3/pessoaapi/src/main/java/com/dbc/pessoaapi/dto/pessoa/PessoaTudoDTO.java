package com.dbc.pessoaapi.dto.pessoa;

import com.dbc.pessoaapi.dto.contato.ContatoDTO;
import com.dbc.pessoaapi.dto.endereco.EnderecoDTO;
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
public class PessoaTudoDTO extends PessoaDTO{
    @ApiModelProperty(value = "Lista de contatos da pessoa")
    private List<ContatoDTO> contatos;
    @ApiModelProperty(value = "Lista de enderecos da pessoa")
    private List<EnderecoDTO> enderecos;
}
