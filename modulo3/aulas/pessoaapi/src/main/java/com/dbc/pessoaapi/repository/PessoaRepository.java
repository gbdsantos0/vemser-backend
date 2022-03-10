package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class PessoaRepository {
    private static List<Pessoa> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet(), "nome1", LocalDate.parse("01/01/2000", formatter), "000.000.000-00"));
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
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public Pessoa delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        listaPessoas.remove(pessoaRecuperada);
        return pessoaRecuperada;
    }

    public Pessoa getById(Integer id){
        return listaPessoas.stream()
                .filter(p -> p.getIdPessoa().equals(id))
                .findFirst().orElse(null);
    }

    public List<Pessoa> listByName(String nome){
        return listaPessoas.stream()
                .filter(p -> p.getNome().contains(nome))
                .toList();
    }
}
