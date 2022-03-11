package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaService.create(pessoa);
    }

    @GetMapping
    public List<Pessoa> list(){
        return pessoaService.list();
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
    public Pessoa update(@PathVariable("idPessoa") Integer id, @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public Pessoa delete(@PathVariable("idPessoa") Integer id) throws Exception {
        return pessoaService.delete(id);
    }

}
