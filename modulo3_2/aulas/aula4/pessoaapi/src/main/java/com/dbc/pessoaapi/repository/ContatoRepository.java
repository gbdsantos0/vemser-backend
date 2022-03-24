package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.enums.TipoContato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    //AULA3
    //EXERCICIO1
    @Query("select c from CONTATO c " +
            "where c.tipoContato = :tipo")
    List<ContatoEntity> findByTipoContato(TipoContato tipo);
    //EXERCICIO2
    @Query(value = "SELECT * FROM VEM_SER.CONTATO c " +
            "WHERE c.id_pessoa = :idPessoa", nativeQuery = true)
    List<ContatoEntity> findByIdPessoa(Integer idPessoa);
    //AULA4
    //EXERCICIO1
//    Page<ContatoEntity> findAll(Pageable pageable);
}
