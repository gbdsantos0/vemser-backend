package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int[][] matriz = new int[4][4];

        int contador = 0;

        //leitura de dados
        System.out.println("Escreva uma matriz 4x4: ");
        for(int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();

        //contagem
        for(int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                if(matriz[i][j]>10){
                    contador++;
                }
            }
        }
        System.out.println("Quantidade de valores maiores do que 10 na matriz: "+contador);

    }
}
