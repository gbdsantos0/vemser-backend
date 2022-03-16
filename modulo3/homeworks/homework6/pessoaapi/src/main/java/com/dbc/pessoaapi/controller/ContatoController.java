package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.service.ContatoService;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Log
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<ContatoDTO> list(){
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> getByIdPessoa(@PathVariable("idPessoa") Integer id){
        return contatoService.getByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody ContatoCreateDTO contato) throws Exception{
        //setar idPessoa para o contato antes de passar para o service
        ContatoDTO contatoPronto = contatoService.create(idPessoa, contato);
        log.info("POST concluído");
        return new ResponseEntity<>(contatoPronto, HttpStatus.CREATED);
    }

    @PutMapping("/{idContato}")
    @Validated
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        ContatoDTO contatoPronto = contatoService.update(id, contato);
        log.info("PUT concluído");
        return new ResponseEntity<>(contatoPronto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> delete(@PathVariable("idContato") Integer id) throws Exception {
        ContatoDTO contatoPronto = contatoService.delete(id);
        log.info("DELETE concluído");
        return new ResponseEntity<>(contatoPronto,HttpStatus.ACCEPTED);
    }
}
