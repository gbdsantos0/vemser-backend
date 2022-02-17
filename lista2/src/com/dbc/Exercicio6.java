package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int[] vetor = new int[10];
        int numero;
        boolean estaPresente = false;

        preencheVetor(vetor);

        System.out.println("Digite um número para ser buscado no vetor: ");
        do{
            numero = sc.nextInt();
            sc.nextLine();

            for(int i=0;i<vetor.length;i++){
                if(vetor[i]==numero){
                    estaPresente = true;
                }
            }
            if(!estaPresente){
                System.out.println("Este número não está presente");
            }

        }while(!estaPresente);



    }

    static void preencheVetor(int[] vetor){
        for(int i=0;i<vetor.length;i++){
            vetor[i] = i+1;
        }
    }
}
