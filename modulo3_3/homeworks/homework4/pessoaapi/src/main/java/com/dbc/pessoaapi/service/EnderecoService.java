package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.endereco.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.endereco.EnderecoDTO;
import com.dbc.pessoaapi.dto.endereco.EnderecoUpdateDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    /*@Autowired
    private EmailService emailService;*/

    @Autowired
    private ObjectMapper objectMapper;

    public List<EnderecoDTO> listAll() throws Exception{
        return enderecoRepository.findAll().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO getByIdEndereco(Integer id) throws Exception{
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRepository.findById(id), EnderecoDTO.class);
        return enderecoDTO;
    }

    //todo corrigir idPessoa
    /*public List<EnderecoDTO> listByIdPessoa(Integer id) throws Exception{
        return enderecoRepository.findAll().stream()
                .filter(enderecoEntity -> enderecoEntity.getIdPessoa().equals(id))
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }*/

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception{
//        PessoaEntity pessoa = pessoaRepository.getById(endereco.getIdPessoa());
//        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
        //emailService.sendEmailMessage(pessoaDTO, "Novo endereço adicionado","Você adicionou com sucesso o seu endereço ao nosso sistema!");
        //testa se a pessoa existe
//        pessoaRepository.getById(idPessoa);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        enderecoEntity.setPessoas(new HashSet<>());
        enderecoEntity.getPessoas().add(pessoaRepository.getById(idPessoa));
        EnderecoEntity enderecoRetorno = enderecoRepository.save(enderecoEntity);


        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRetorno, EnderecoDTO.class);

        return enderecoDTO;
    }

    public EnderecoDTO update(Integer id, EnderecoUpdateDTO enderecoAlterado) throws Exception{
//        PessoaEntity pessoa = pessoaRepository.getById(enderecoAlterado.getIdPessoa());
//        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
        //emailService.sendEmailMessage(pessoaDTO, "Atualização de endereço","Você atualizou com sucesso o seu endereço em nosso sistema!");
        //testa se a pessoa existe
        //pessoaRepository.getById(enderecoAlterado.getIdPessoa());
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoAlterado, EnderecoEntity.class);
        enderecoEntity.setIdEndereco(id);
        EnderecoEntity enderecoRetorno = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRetorno, EnderecoDTO.class);

        return enderecoDTO;
    }

    public EnderecoDTO delete(Integer id) throws Exception{
//        PessoaEntity pessoa = pessoaRepository.getById(enderecoRepository.getByIdEndereco(id).getIdPessoa());
//        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
        //emailService.sendEmailMessage(pessoaDTO, "Exclusão de endereço","Você deletou com sucesso o seu endereço de nosso sistema!");
        EnderecoEntity enderecoRetorno = enderecoRepository.findById(id)
                .orElseThrow(()->new RegraDeNegocioException("Endereço não encontrado por ID"));
        enderecoRepository.deleteById(id);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRetorno, EnderecoDTO.class);

        return enderecoDTO;
    }
}
