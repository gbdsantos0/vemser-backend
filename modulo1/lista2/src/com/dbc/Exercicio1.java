package com.dbc;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        DecimalFormat df = new DecimalFormat("0.00");

        String produto;
        float valor;


        //solicitacao de dados
        System.out.println("Escreva o nome do produto: ");
        produto = sc.nextLine();
        System.out.println("Escreva o valor do produto: ");
        valor = sc.nextFloat();
        sc.nextLine();

        //print descricao
        System.out.println("Produto.: "+produto+"\nPreço R$.: "+df.format(valor)+"\nPromoção.: "+produto+"\n------------------------");

        //print dos valores
        for(int i=1;i<=10;i++){

            System.out.println(i+" x R$ "+df.format((1-(0.05*i))*valor)+" = R$ "+df.format((1-(0.05*i))*valor*i));
        }

    }
}
