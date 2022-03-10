package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.PessoaRepository;

import java.util.List;

public class PessoaService {
    private PessoaRepository pessoaRepository;

    public PessoaService() {
        this.pessoaRepository = new PessoaRepository();
    }

    public Pessoa create(Pessoa pessoa){
        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public Pessoa delete(Integer id) throws Exception {
        return pessoaRepository.delete(id);
    }

    public Pessoa getById(Integer id){
        return pessoaRepository.getById(id);
    }

    public List<Pessoa> listByName(String nome){
        return pessoaRepository.listByName(nome);
    }

}
