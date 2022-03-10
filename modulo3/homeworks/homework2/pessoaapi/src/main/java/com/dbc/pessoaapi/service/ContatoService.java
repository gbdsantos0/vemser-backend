package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {
    private ContatoRepository contatoRepository;


    public ContatoService() {
        this.contatoRepository = new ContatoRepository();
    }

    public Contato create(Contato contato){
        return contatoRepository.create(contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(id, contatoAtualizar);
    }

    public Contato delete(Integer id) throws Exception {
        return contatoRepository.delete(id);
    }

    public List<Contato> getByIdPessoa(Integer id){
        return contatoRepository.getByIdPessoa(id);
    }
}
