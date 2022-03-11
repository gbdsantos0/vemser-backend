package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Endereco create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody Endereco endereco){
        endereco.setIdPessoa(idPessoa);
        return enderecoService.create(endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer id, @RequestBody Endereco enderecoAlterado) throws Exception{
        return enderecoService.update(id, enderecoAlterado);
    }

    @DeleteMapping("/{idEndereco}")
    public Endereco delete(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.delete(id);
    }
}
