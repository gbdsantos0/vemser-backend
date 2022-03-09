package com.dbc;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome;
        int idade;
        String cidade;
        String estado;

        System.out.println("digite seu nome: ");
            nome = sc.nextLine();
        System.out.println("digite sua idade: ");
            idade = sc.nextInt();
            sc.nextLine();
        System.out.println("digite sua cidade: ");
            cidade = sc.nextLine();
        System.out.println("digite seu estado: ");
            estado = sc.nextLine();

        System.out.println("Olá seu nome é "+nome+", você tem "+idade+" anos, é da cidade de "+cidade+", situada no estado de "+estado+".");
    }
}
