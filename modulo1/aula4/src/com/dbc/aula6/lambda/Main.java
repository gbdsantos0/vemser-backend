package com.dbc.aula6.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        Funcao funcao = new Funcao(){
//            @Override
//            public String gerar(String valor){
//                return "Sr. "+valor;
//            }
//        };
//
//        Funcao funcaoLambda = valor -> "Sr. "+valor;
//        Funcao funcaoLambdaSra = valor -> "Sra. "+valor;
//
//
//
//        System.out.println(funcao.gerar("Senhor"));
//        System.out.println(funcaoLambda.gerar("Senhor"));
//        System.out.println(funcaoLambdaSra.gerar("Senhor"));


        ArrayList<NomeCpf> listaNomes = new ArrayList<>(Arrays.asList(new NomeCpf("a","1"), new NomeCpf("b","2"), new NomeCpf("c","3")));

        System.out.println(listaNomes);

        listaNomes.sort(Comparator.comparing(NomeCpf::getNome).reversed());

        System.out.println(listaNomes);

        //imutabilidade = classe apenas com atributos final e consequentemente, sem setters



    }
}
