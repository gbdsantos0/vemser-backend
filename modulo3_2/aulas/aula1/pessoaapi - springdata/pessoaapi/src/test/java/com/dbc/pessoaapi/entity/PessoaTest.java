package com.dbc.pessoaapi.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaTest {

    @Test
    public void testLombok() {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(1);
        pessoa.setNome("OI");
        pessoa.setDataNascimento(LocalDate.of(1991, 10, 10));
        pessoa.setCpf("132456789");
        System.out.println(pessoa.toString());

        Pessoa pessoa1 = Pessoa.builder()
                .idPessoa(1)
                .cpf("teste")
                .dataNascimento(LocalDate.of(1991, 10, 10))
                .nome("Maicon")
                .build();

        var pessoaX = Pessoa.builder()
                .idPessoa(1)
                .cpf("teste")
                .dataNascimento(LocalDate.of(1991, 10, 10))
                .nome("Maicon")
                .build();
    }
}