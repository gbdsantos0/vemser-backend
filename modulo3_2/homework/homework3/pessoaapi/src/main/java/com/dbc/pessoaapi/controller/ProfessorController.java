package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.pessoa.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.pessoa.PessoaDTO;
import com.dbc.pessoaapi.dto.professor.ProfessorDTO;
import com.dbc.pessoaapi.service.ProfessorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professor")
@Log
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;


    @ApiOperation(value = "Retorna uma lista de professores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de professores"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> list() throws Exception {
        List<ProfessorDTO> lista = professorService.listAll();
        return new ResponseEntity<>(lista, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Cria um novo professor e retorna as informações")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma pessoa criada"),
            @ApiResponse(code = 201, message = "Retorna uma pessoa criada com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    @Validated
    public ResponseEntity<ProfessorDTO> create(@Valid @RequestBody ProfessorDTO professorDTO) throws Exception{
        professorDTO = professorService.create(professorDTO);
        log.info("POST concluído");
        return new ResponseEntity<>(professorDTO, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna um professor por IDs(idProfessor/idUniversidade)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o professor buscado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/findById/{idProfessor}/{idUniversidade}")
    public ResponseEntity<ProfessorDTO> findById(@PathVariable("idProfessor") Integer idProfessor, @PathVariable("idUniversidade") Integer idUniversidade) throws Exception{
        ProfessorDTO professorDTO = professorService.findById(idProfessor, idUniversidade);
        log.info("GetByIds concluído");
        return new ResponseEntity<>(professorDTO,HttpStatus.ACCEPTED);
    }

}
