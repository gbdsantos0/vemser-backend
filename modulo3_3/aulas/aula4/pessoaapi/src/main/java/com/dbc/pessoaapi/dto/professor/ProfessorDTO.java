package com.dbc.pessoaapi.dto.professor;

import com.dbc.pessoaapi.entity.ProfessorPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO{
    @NotNull
    private ProfessorPK professorPK;
    @NotNull
    private String nome;
    @Min(0)
    private Double salario;
}
