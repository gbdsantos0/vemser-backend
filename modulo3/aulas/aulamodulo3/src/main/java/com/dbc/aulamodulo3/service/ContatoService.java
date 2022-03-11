package com.dbc.aulamodulo3.service;

import com.dbc.aulamodulo3.entity.Contato;
import com.dbc.aulamodulo3.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;


    /*public ContatoService() {
        this.contatoRepository = new ContatoRepository();
    }*/

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
