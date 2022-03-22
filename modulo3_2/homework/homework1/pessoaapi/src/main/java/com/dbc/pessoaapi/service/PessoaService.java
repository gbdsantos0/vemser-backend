package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.pessoa.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.pessoa.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    /*@Autowired
    private EmailService emailService;*/

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        //emailService.sendEmailToNewUser(pessoaDTO);
        return pessoaDTO;
    }

    public List<PessoaDTO> list() throws Exception{
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaAtualizar, PessoaEntity.class);
        pessoaEntity.setIdPessoa(id);
        PessoaEntity pessoaAtualizada = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);
        //emailService.sendEmailToUpdatedUser(pessoaDTO);
        return pessoaDTO;
    }

    public PessoaDTO delete(Integer id) throws Exception {
        PessoaEntity pessoaDeletada = pessoaRepository.findById(id).orElseThrow(()->new RegraDeNegocioException("Pessoa não encontrada por esse ID"));
        pessoaRepository.deleteById(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaDeletada, PessoaDTO.class);
        //emailService.sendEmailToDeletedUser(pessoaDTO);
        return pessoaDTO;
    }

    public PessoaDTO getById(Integer id) throws Exception {
        PessoaEntity pessoa = pessoaRepository.findById(id).orElseThrow(()->new RegraDeNegocioException("Pessoa não encontrada por esse ID"));
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
        return pessoaDTO;
    }

    /*public List<PessoaDTO> listByName(String nome) throws Exception {
        return pessoaRepository.listByName(nome)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }*/

}
