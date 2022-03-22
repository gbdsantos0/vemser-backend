package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.contato.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.contato.ContatoDTO;
import com.dbc.pessoaapi.dto.contato.ContatoUpdateDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws Exception{
        //testa se a pessoa existe
        pessoaRepository.getById(idPessoa);
        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        contatoEntity.setIdPessoa(idPessoa);
        ContatoEntity contatoCriado = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);

        return contatoDTO;
    }

    public List<ContatoDTO> list(){
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoUpdateDTO contatoAtualizar) throws Exception {
        //testa se a pessoa existe
        pessoaRepository.getById(contatoAtualizar.getIdPessoa());
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoAtualizar, ContatoEntity.class);
        contatoEntity.setIdContato(id);
        ContatoEntity contatoAtualizado = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoAtualizado, ContatoDTO.class);

        return contatoDTO;
    }

    public ContatoDTO delete(Integer id) throws Exception {

        ContatoEntity contatoAtualizado = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado por esse ID"));
        contatoRepository.deleteById(id);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoAtualizado, ContatoDTO.class);

        return contatoDTO;
    }

    public List<ContatoDTO> getByIdPessoa(Integer id){
        return contatoRepository.findAll()
                .stream()
                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(id))
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }
}
