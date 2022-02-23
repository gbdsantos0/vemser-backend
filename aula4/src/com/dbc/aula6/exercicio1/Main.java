package com.dbc.aula6.exercicio1;

public class Main {
    public static void main(String[] args) {
        Calculo soma = (a, b) -> a+b;
        Calculo multiplicacao = (a,b) -> a*b;
        System.out.println("Soma 1+1 = "+soma.calcular(1,1));
        System.out.println("Multiplicação 2*5 = "+multiplicacao.calcular(2,5));

    }
}
