package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }

    @PostMapping
    @Validated
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa){
//        return ResponseEntity.ok(pessoaService.create(pessoa));
        Pessoa pessoaCriada = pessoaService.create(pessoa);
        return new ResponseEntity<>(pessoaCriada, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> list(){
        List<Pessoa> lista = pessoaService.list();
        return new ResponseEntity<>(lista, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idPessoa}")
    public Pessoa getById(@PathVariable("idPessoa") Integer id){
        return pessoaService.getById(id);
    }

    @GetMapping("/byname")
    public List<Pessoa> listByName(@RequestParam("nome") String nome){
        return pessoaService.listByName(nome);
    }

    @PutMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id, @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaAtualizada = pessoaService.update(id, pessoaAtualizar);
        return new ResponseEntity<>(pessoaAtualizada, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        Pessoa pessoaDeletada = pessoaService.delete(id);
        return new ResponseEntity<>(pessoaDeletada, HttpStatus.ACCEPTED);
    }

}
