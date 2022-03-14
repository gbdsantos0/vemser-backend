package com.dbc.aulamodulo3.controller;

import com.dbc.aulamodulo3.components.PropertieReader;
import com.dbc.aulamodulo3.entity.Pessoa;
import com.dbc.aulamodulo3.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

   /* public PessoaController() {
        this.pessoaService = new PessoaService();
    }*/

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }

    @PostMapping
    @Validated
    public Pessoa create(@Valid @RequestBody Pessoa pessoa){
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
    @Validated
    public Pessoa update(@PathVariable("idPessoa") Integer id, @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public Pessoa delete(@PathVariable("idPessoa") Integer id) throws Exception {
        return pessoaService.delete(id);
    }


    @GetMapping("/ambiente")
    public String returnPropertieReader(){
        return propertieReader.retorno();
    }
}
