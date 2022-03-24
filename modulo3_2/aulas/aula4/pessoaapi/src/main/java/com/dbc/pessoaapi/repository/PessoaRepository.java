package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    List<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataNascimento1, LocalDate dataNascimento2);

    /*@Query("select .... from PESSOA p where p.nome = ?1")
    List<PessoaEntity> findByNomeJPQL(String nome);*/
    /*@Query("select p from PESSOA p where p.nome = :nome")
    List<PessoaEntity> findByNomeJPQL(String nome);

    @Query("select p from PESSOA p " +
            "join fetch p.contatos c " +
            "where p.nome = :nome")
    List<PessoaEntity> findByNomeComContatosJPQL(String nome);*/

    //AULA3
    //EXERCICIO1
    @Query("select p from PESSOA p " +
            "where p.dataNascimento between :dataNascimento1 and :dataNascimento2")
    List<PessoaEntity> findByDateBetween2(LocalDate dataNascimento1, LocalDate dataNascimento2);

    @Query("select p from PESSOA p " +
            "inner join p.enderecos e")
    List<PessoaEntity> findByHasAddress();

    //EXERCICIO2
    @Query(value = "SELECT * FROM VEM_SER.PESSOA p " +
            "LEFT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO ep " +
            "ON p.id_pessoa = ep.id_pessoa " +
            "WHERE ep.id_pessoa IS NULL", nativeQuery = true)
    List<PessoaEntity> findPessoaSemEndereco();

    //AULA4
    //@Query("select p from PESSOA p where upper(p.nome) like :nome")
//    Page<PessoaEntity> findByNomeContainsIgnoreCase(String nome, Pageable pageable);
}
