package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listAll(){
        return enderecoService.listAll();
    }

    @GetMapping("/{idEndereco}")
    public Endereco getByIdEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.getByIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer id){
        return enderecoService.listByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody Endereco endereco) throws Exception{
        return new ResponseEntity<>(enderecoService.create(idPessoa, endereco), HttpStatus.CREATED);
    }

    @PutMapping("/{idEndereco}")
    @Validated
    public ResponseEntity<Endereco> update(@PathVariable("idEndereco") Integer id, @Valid @RequestBody Endereco enderecoAlterado) throws Exception{
        return new ResponseEntity<>(enderecoService.update(id, enderecoAlterado), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Endereco> delete(@PathVariable("idEndereco") Integer id) throws Exception{
        return new ResponseEntity<>(enderecoService.delete(id), HttpStatus.ACCEPTED);
    }
}
