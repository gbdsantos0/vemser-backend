package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.professor.ProfessorDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.entity.ProfessorPK;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public List<ProfessorDTO> listAll() throws Exception{
        return professorRepository.findAll().stream()
                .map(professorEntity -> objectMapper.convertValue(professorEntity, ProfessorDTO.class))
                .collect(Collectors.toList());
    }

    public ProfessorDTO create(ProfessorDTO professorDTO) throws Exception{
        ProfessorEntity professorEntity = objectMapper.convertValue(professorDTO, ProfessorEntity.class);
        professorDTO = objectMapper.convertValue(professorRepository.save(professorEntity), ProfessorDTO.class);
        return professorDTO;
    }

    public ProfessorDTO findById(Integer idProfessor, Integer idUniversidade) throws Exception{
        ProfessorEntity professorEntity = professorRepository.findById(new ProfessorPK(idProfessor,idUniversidade))
                .orElseThrow(()->new RegraDeNegocioException("Professor não encontrado"));
        return objectMapper.convertValue(professorEntity, ProfessorDTO.class);
    }
}
