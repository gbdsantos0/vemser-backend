package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import lombok.Data;

@Data
public class ContatoDTO {
    private Integer idContato;
    private Integer idPessoa;
    private Integer tipoContato;
    private String numero;
    private String descricao;
}
