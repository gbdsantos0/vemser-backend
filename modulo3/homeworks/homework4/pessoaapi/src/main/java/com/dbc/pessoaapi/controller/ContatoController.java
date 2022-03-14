package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody Contato contato) throws Exception{
        //setar idPessoa para o contato antes de passar para o service
        return new ResponseEntity<>(contatoService.create(idPessoa, contato), HttpStatus.CREATED);
    }

    @PutMapping("/{idContato}")
    @Validated
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id, @Valid @RequestBody Contato contato) throws Exception {
        return new ResponseEntity<>(contatoService.update(id, contato), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Contato> delete(@PathVariable("idContato") Integer id) throws Exception {
        return new ResponseEntity<>(contatoService.delete(id),HttpStatus.ACCEPTED);
    }
}
