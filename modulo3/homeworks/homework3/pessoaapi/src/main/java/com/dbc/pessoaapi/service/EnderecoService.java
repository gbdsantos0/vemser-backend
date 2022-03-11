package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listAll(){
        return enderecoRepository.listAll();
    }

    public Endereco getByIdEndereco(Integer id) throws Exception{
        return enderecoRepository.getByIdEndereco(id);
    }

    public List<Endereco> listByIdPessoa(Integer id){
        return enderecoRepository.listByIdPessoa(id);
    }

    public Endereco create(Endereco endereco){
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer id, Endereco enderecoAlterado) throws Exception{
        return enderecoRepository.update(id,enderecoAlterado);
    }

    public Endereco delete(Integer id) throws Exception{
        return enderecoRepository.delete(id);
    }
}
