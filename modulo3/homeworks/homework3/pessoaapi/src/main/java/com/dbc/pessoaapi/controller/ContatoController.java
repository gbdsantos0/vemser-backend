package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> list(){
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> getByIdPessoa(@PathVariable("idPessoa") Integer id){
        return contatoService.getByIdPessoa(id);
    }

    //todo DEVO TRATAR EXCEPTION
    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody Contato contato){
        //setar idPessoa para o contato antes de passar para o service
        contato.setIdPessoa(idPessoa);
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id, @RequestBody Contato contato) throws Exception {
        return contatoService.update(id, contato);
    }

    @DeleteMapping("/{idContato}")
    public Contato delete(@PathVariable("idContato") Integer id) throws Exception {
        return contatoService.delete(id);
    }
}
