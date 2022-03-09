package com.dbc.aula6.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>(Arrays.asList(
                new Pessoa("a","",10,"123"),
                new Pessoa("b","",20,"456"),
                new Pessoa("c","",20,"789"),
                new Pessoa("d","",30,"321")
        ));

        List<Pessoa> listaFiltrada = lista.stream()
                .filter(pessoa -> pessoa.ehMaiorDeIdade())
                .map(pessoa -> pessoa)
                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
                .collect(Collectors.toList());

        System.out.println(lista);
        System.out.println(listaFiltrada);

        System.out.println("\n############################################################################################################################" +
                "############################################################################################################################\n");

        List<Pessoa> listaFiltrada2 = lista.stream()
                .filter(pessoa -> {
                    return pessoa.ehMaiorDeIdade() && pessoa.getWhatsApp().contains("1");
                })
                .map(pessoa -> pessoa)
                .collect(Collectors.toList());

        System.out.println(lista);
        System.out.println(listaFiltrada2);
    }
}
