package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int numero;
        int tentativa;

        System.out.println("Digite o número para seu colega adivinhar:");
        numero = sc.nextInt();
        sc.nextLine();

        clearScreen();

        do{
            System.out.println("Digite um número para tentar acertar:");
            tentativa = sc.nextInt();
            sc.nextLine();
            if(tentativa<numero){
                System.out.println("O número a ser encontrado é maior do que você digitou.\n\n");
            }else if(tentativa>numero){
                System.out.println("O número a ser encontrado é menor do que você digitou.\n\n");
            }
        }while(numero!=tentativa);

        System.out.println("Parabéns, você acertou!!");

    }

    static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
