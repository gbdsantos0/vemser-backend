package com.dbc.aula5.pratica1;

public class Main {
    public static void main(String[] args) {
        Soma soma = new Soma();
        System.out.println(soma.calcula(1,1));

        Subtracao subtracao = new Subtracao();
        System.out.println(subtracao.calcula(1,1));

        Multiplicacao multiplicacao = new Multiplicacao();
        System.out.println(multiplicacao.calcula(2,2));

        Divisao divisao = new Divisao();
        System.out.println(divisao.calcula(4,2));
    }
}
