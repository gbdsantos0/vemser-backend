package com.dbc.aulamodulo3.service;

import com.dbc.aulamodulo3.entity.Pessoa;
import com.dbc.aulamodulo3.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

   /* public PessoaService() {
        this.pessoaRepository = new PessoaRepository();
    }*/

    public Pessoa create(Pessoa pessoa){

        try {
            //regras nome
            if(StringUtils.isBlank(pessoa.getNome())){
                throw new Exception("Preencha o nome");
            }else if(!StringUtils.containsWhitespace(pessoa.getNome())){
                throw new Exception("Preencha nome e sobrenome");
            }
            //regras data
            if(ObjectUtils.isEmpty(pessoa.getDataNascimento())){
                throw new Exception("Insira data de nascimento");
            }
            //regras cpf
            if(StringUtils.isBlank(pessoa.getCpf())){
                throw new Exception("Insira o CPF");
            }else if(StringUtils.length(pessoa.getCpf())!=11 || !StringUtils.isNumeric(pessoa.getCpf())){
                throw new Exception("Insira os 11 números de seu cpf");
            }

            return pessoaRepository.create(pessoa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
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
