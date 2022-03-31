package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    //EXERCICIO1
    @Query("select e from ENDERECO_PESSOA e " +
            "where e.pais = :pais")
    List<EnderecoEntity> findAddressByState(String pais);

    @Query("select e from ENDERECO_PESSOA e " +
            "join fetch e.pessoas p " +
            "where p.idPessoa = :idPessoa")
    List<EnderecoEntity> findAddressByIdPessoa(Integer idPessoa);

    //EXERCICIO2
    @Query(value = "SELECT * FROM VEM_SER.ENDERECO_PESSOA e " +
            "WHERE e.cidade = :cidade OR e.pais = :pais", nativeQuery = true)
    List<EnderecoEntity> findByCidadeOrPais(String cidade, String pais);
    @Query(value = "SELECT * FROM VEM_SER.ENDERECO_PESSOA e " +
            "WHERE e.complemento IS NULL", nativeQuery = true)
    List<EnderecoEntity> findComplementoNull();
}
