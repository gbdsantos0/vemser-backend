package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int[] vetor = new int[3];
        int posicao = 0;


        for(int i=0;i<3;i++){
            vetor[i] = sc.nextInt();
        }
        sc.nextLine();

        for(int i=1;i<3;i++){
            if(vetor[posicao]>vetor[i]){
                posicao = i;
            }
        }
        //printa posicao em forma de indice mesmo
        System.out.println("Posição do menor número no vetor: "+posicao+"\nMenor número: "+vetor[posicao]);


    }
}
