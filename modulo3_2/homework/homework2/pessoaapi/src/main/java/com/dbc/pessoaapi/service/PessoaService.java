package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.contato.ContatoDTO;
import com.dbc.pessoaapi.dto.endereco.EnderecoDTO;
import com.dbc.pessoaapi.dto.pessoa.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.pessoa.PessoaDTO;
import com.dbc.pessoaapi.dto.pessoa.PessoaDTOComContatos;
import com.dbc.pessoaapi.dto.pessoa.PessoaDTOComEnderecos;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<PessoaDTO> listByName(String nome) throws Exception{
        return pessoaRepository.findByNomeContainsIgnoreCase(nome).stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity,PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByCpf(String cpf) throws Exception{
        return pessoaRepository.findByCpf(cpf).stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity,PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByDatePeriod(LocalDate dataNascimento1, LocalDate dataNascimento2) throws Exception{
        return pessoaRepository.findByDataNascimentoBetween(dataNascimento1, dataNascimento2).stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity,PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTOComContatos> listComContatos(Integer idPessoa) throws Exception{
        List<PessoaDTOComContatos> pessoaDTOList = new ArrayList<>();
        if(idPessoa==null){
            pessoaDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTOComContatos pessoaDTOComContatos = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
                        pessoaDTOComContatos.setContatos(pessoaEntity.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .collect(Collectors.toList()));
                        return pessoaDTOComContatos;
                    }).collect(Collectors.toList()));
        }else{
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(()->new RegraDeNegocioException("Pessoa não encontrada pelo ID informado"));
            PessoaDTOComContatos pessoaDTOComContatos = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTOComContatos.setContatos(pessoaEntity.getContatos().stream()
                    .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                    .collect(Collectors.toList()));
            pessoaDTOList.add(pessoaDTOComContatos);
        }
        return pessoaDTOList;
    }

    public List<PessoaDTOComEnderecos> listComEnderecos(Integer idPessoa) throws Exception{
        List<PessoaDTOComEnderecos> pessoaDTOList = new ArrayList<>();
        if(idPessoa==null){
            pessoaDTOList.addAll(
                    pessoaRepository.findAll().stream()
                            .map(pessoaEntity -> {
                                PessoaDTOComEnderecos pessoaDTOComEnderecos = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecos.class);
                                pessoaDTOComEnderecos.setEnderecos(pessoaEntity.getEnderecos().stream()
                                        .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                        .collect(Collectors.toList()));
                                return pessoaDTOComEnderecos;
                            }).collect(Collectors.toList()));
        }else{
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(()->new RegraDeNegocioException("Pessoa não encontrada pelo ID informado"));
            PessoaDTOComEnderecos pessoaDTOComEnderecos = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecos.class);
            pessoaDTOComEnderecos.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                    .collect(Collectors.toList()));
            pessoaDTOList.add(pessoaDTOComEnderecos);
        }
        return pessoaDTOList;
    }

}
