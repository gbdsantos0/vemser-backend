package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrupoService {
    private final GrupoRepository grupoRepository;

    public GrupoEntity getById(Integer idGrupo) throws Exception{
        return grupoRepository.findById(idGrupo).orElseThrow(()->new RegraDeNegocioException("Grupo de cargos não encontrado"));
    }
}
