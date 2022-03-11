package com.dbc.aulamodulo3.repository;

import com.dbc.aulamodulo3.entity.Contato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "(00) 0 0000-0000"));
    }

    public Contato create(Contato contato){
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list(){
        return listaContatos;
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(c -> c.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());

        return contatoRecuperado;
    }

    public Contato delete(Integer id) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(c -> c.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrada"));
        listaContatos.remove(contatoRecuperado);
        return contatoRecuperado;
    }

    public List<Contato> getByIdPessoa(Integer id){
        return listaContatos.stream()
                .filter(c -> c.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }


}
