package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.DadosPessoaisService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
@Log
public class PessoaRepository {
    private static List<Pessoa> listaPessoas = new ArrayList<>();
    private static AtomicInteger COUNTER = new AtomicInteger();
    private DadosPessoaisClient dadosPessoaisClient;
    @Autowired
    private ObjectMapper objectMapper;



    public PessoaRepository(){
        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "Gustavo Barbosa", LocalDate.parse("07/12/1995", formatter), "00000000000", "haha@gmail.com"));
        listaPessoas.add(Pessoa.builder()
                .idPessoa(COUNTER.incrementAndGet())
                .nome("Pessoa Dois")
                .dataNascimento(LocalDate.parse("07/12/1942", formatter))
                .cpf("00000000000")
                .build());*/
        log.info("construtor do PessoaRepository");
        listaPessoas.addAll(dadosPessoaisClient.getAll().stream()
                .map(PessoaRepository::convertPessoaFromDadosPessoaisDTO)
                .collect(Collectors.toList())
        );//todo problema ao instanciar o dadosPessoaisClient
    }

    public static Pessoa convertPessoaFromDadosPessoaisDTO(DadosPessoaisDTO dadosPessoaisDTO){
        return Pessoa.builder()
                .idPessoa(COUNTER.incrementAndGet())
                .nome(dadosPessoaisDTO.getNome())
                .cpf(dadosPessoaisDTO.getCpf())
                .build();
    }

    public Pessoa create(Pessoa pessoa){
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> list(){
        return listaPessoas;
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public Pessoa delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        listaPessoas.remove(pessoaRecuperada);
        return pessoaRecuperada;
    }

    public Pessoa getById(Integer id) throws Exception {
        return listaPessoas.stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Essa pessoa não existe"));
    }

    public List<Pessoa> listByName(String nome){
        return listaPessoas.stream()
                .filter(p -> p.getNome().contains(nome))
                .toList();
    }
}
