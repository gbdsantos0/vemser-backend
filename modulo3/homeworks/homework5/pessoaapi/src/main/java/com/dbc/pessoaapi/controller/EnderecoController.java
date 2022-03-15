package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.service.EnderecoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Log
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDTO> listAll() throws Exception{
        return enderecoService.listAll();
    }

    @GetMapping("/{idEndereco}")
    public EnderecoDTO getByIdEndereco(@PathVariable("idEndereco") Integer id) throws Exception{
        return enderecoService.getByIdEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer id) throws Exception{
        return enderecoService.listByIdPessoa(id);
    }

    @PostMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception{
        EnderecoDTO enderecoPronto = enderecoService.create(idPessoa, endereco);
        log.info("POST concluído");
        return new ResponseEntity<>(enderecoPronto, HttpStatus.CREATED);
    }

    @PutMapping("/{idEndereco}")
    @Validated
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id, @Valid @RequestBody EnderecoCreateDTO enderecoAlterado) throws Exception{
        EnderecoDTO enderecoPronto = enderecoService.update(id, enderecoAlterado);
        log.info("PUT concluído");
        return new ResponseEntity<>(enderecoPronto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> delete(@PathVariable("idEndereco") Integer id) throws Exception{
        EnderecoDTO enderecoPronto = enderecoService.delete(id);
        log.info("DELETE concluído");
        return new ResponseEntity<>(enderecoPronto, HttpStatus.ACCEPTED);
    }
}
