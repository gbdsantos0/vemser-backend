package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    /*Optional<PessoaEntity> findByNome(String nome);
    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    List<PessoaEntity> findByNomeOrDataNascimento(String nome, LocalDate dataNascimento);*/

    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);
    Optional<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataNascimento1, LocalDate dataNascimento2);
}
