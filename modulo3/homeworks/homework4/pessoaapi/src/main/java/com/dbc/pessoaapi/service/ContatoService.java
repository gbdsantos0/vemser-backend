package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.exception.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Contato create(Integer idPessoa, Contato contato) throws RegraDeNegocioException{
        contato.setIdPessoa(idPessoa);
        if(pessoaRepository.getById(contato.getIdPessoa())==null){
            throw new RegraDeNegocioException("Essa pessoa não existe");
        }
        return contatoRepository.create(contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        if(pessoaRepository.getById(contatoAtualizar.getIdPessoa())==null){
            throw new RegraDeNegocioException("Essa pessoa não existe");
        }
        return contatoRepository.update(id, contatoAtualizar);
    }

    public Contato delete(Integer id) throws Exception {
        return contatoRepository.delete(id);
    }

    public List<Contato> getByIdPessoa(Integer id){
        return contatoRepository.getByIdPessoa(id);
    }
}
