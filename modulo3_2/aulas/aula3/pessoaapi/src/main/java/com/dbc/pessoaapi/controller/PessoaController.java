package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.pessoa.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.pessoa.PessoaDTO;
import com.dbc.pessoaapi.dto.pessoa.PessoaDTOComContatos;
import com.dbc.pessoaapi.dto.pessoa.PessoaDTOComEnderecos;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Log
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Value("${nome}")
    private String nomeAppProperties;

    /*@ApiOperation(value = "Hello world!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o Hello World!"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/hello")
    public String hello(){
        log.info("/hello chamado.");
        //emailService.sendEmail();
        return "Hello world! " + nomeAppProperties;
    }

    @ApiOperation(value = "Método de teste")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 202, message = "Aceito"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/teste")
    public ResponseEntity alo(){
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }*/

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() throws Exception {
        List<PessoaDTO> lista = pessoaService.list();
        return new ResponseEntity<>(lista, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Retorna uma pessoa por Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idPessoa}")
    public PessoaDTO getById(@PathVariable("idPessoa") Integer id) throws Exception{
        return pessoaService.getById(id);
    }

    /*@ApiOperation(value = "Retorna uma lista de pessoas por nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas listadas por nome"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) throws Exception{
        return pessoaService.listByName(nome);
    }*/

    @ApiOperation(value = "Cria uma nova pessoa e retorna as informações")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa criada"),
            @ApiResponse(code = 201, message = "Retorna uma pessoa criada com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    @Validated
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception{
//        return ResponseEntity.ok(pessoaService.create(pessoa));
        PessoaDTO pessoaCriada = pessoaService.create(pessoa);
        log.info("POST concluído");
        return new ResponseEntity<>(pessoaCriada, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Atualiza as informações de uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa atualizada"),
            @ApiResponse(code = 202, message = "Retorna uma pessoa atualizada com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{idPessoa}")
    @Validated
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaDTO pessoaAtualizada = pessoaService.update(id, pessoaAtualizar);
        log.info("PUT concluído");
        return new ResponseEntity<>(pessoaAtualizada, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Deleta uma pessoa e retorna as informações")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa deletada"),
            @ApiResponse(code = 202, message = "Retorna uma pessoa deletada com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        PessoaDTO pessoaDeletada = pessoaService.delete(id);
        log.info("DELETE concluído");
        return new ResponseEntity<>(pessoaDeletada, HttpStatus.ACCEPTED);
    }

//EXERCICIO2 - AULA2 MODULO3
    @ApiOperation(value = "Retorna uma lista de pessoas por nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-por-nome")
    public List<PessoaDTO> listByName(@RequestParam(value = "nome") String nome) throws Exception{
        return pessoaService.listByName(nome);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas por cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-por-cpf")
    public List<PessoaDTO> listByCpf(@RequestParam(value = "cpf") String cpf) throws Exception{
        return pessoaService.listByCpf(cpf);
    }

    //HOMEWORK2 - AULA2 MODULO3

    @ApiOperation(value = "Retorna uma lista de pessoas por data de nascimento, dentro dos intervalos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-por-data-periodo")
    public List<PessoaDTO> listByDatePeriod(@RequestParam(value = "data_inicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento1,
                                            @RequestParam(value = "data_final") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento2) throws Exception{
        return pessoaService.listByDatePeriod(dataNascimento1, dataNascimento2);
    }


    @ApiOperation(value = "Retorna uma pessoa por Id com seus contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-com-contatos")
    public List<PessoaDTOComContatos> listComContatos(@RequestParam(value = "id", required = false)Integer idPessoa) throws Exception{
        return pessoaService.listComContatos(idPessoa);
    }

    @ApiOperation(value = "Retorna uma pessoa por Id com seus enderecos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-com-enderecos")
    public List<PessoaDTOComEnderecos> listComEnderecos(@RequestParam(value = "id", required = false)Integer idPessoa) throws Exception{
        return pessoaService.listComEnderecos(idPessoa);
    }

}
