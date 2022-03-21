package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa entity = new Pessoa();
        entity.setCpf(pessoa.getCpf());
        entity.setNome(pessoa.getNome());
        entity.setDataNascimento(pessoa.getDataNascimento());
//
        Pessoa pessoa1 = pessoaRepository.create(entity);
        PessoaDTO pessoaDTO = new PessoaDTO();
//        PessoaDTO pessoaDTO2 = objectMapper.convertValue(pessoa1, PessoaDTO.class);
        pessoaDTO.setIdPessoa(pessoa1.getIdPessoa());
        pessoaDTO.setCpf(pessoa1.getCpf());
        pessoaDTO.setNome(pessoa1.getNome());
        pessoaDTO.setDataNascimento(pessoa1.getDataNascimento());

        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {
        Pessoa pessoa = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        Pessoa update = pessoaRepository.update(id, pessoa);
        PessoaDTO pessoaDTO = objectMapper.convertValue(update, PessoaDTO.class);
        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
}
