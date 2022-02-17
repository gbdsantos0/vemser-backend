package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int[] vetor = new int[20];

        System.out.println("Escreva 20 valores: ");
        for(int i=0;i<20;i++){
            vetor[i] = sc.nextInt();
        }
        sc.nextLine();

        //print invertido
        for(int i=19;i>=0;i--){
            System.out.print(vetor[i]+" ");
        }
    }
}
