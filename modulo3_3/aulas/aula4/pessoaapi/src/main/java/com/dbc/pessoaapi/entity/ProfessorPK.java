package com.dbc.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ProfessorPK implements Serializable {
    @Column(name = "id_professor")
    private Integer idProfessor;
    @Column(name = "id_universidade")
    private Integer idUniversidade;
}
