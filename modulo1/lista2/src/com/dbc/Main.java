package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //EX1
//        double[] vetor = {1,2,3};
//        System.out.println((vetor[0]+vetor[1]+vetor[2])+" "+(vetor[0]+vetor[1]+vetor[2])/4);

        //EX2
//        int[][] matriz = {{1,2,10},{3,4,10}};
//        printMat(matriz);
//
//        int soma = 0;
//        //soma total
//        for(int i=0;i< matriz.length;i++){
//            for(int j=0;j<matriz[0].length;j++) {
//                soma += matriz[i][j];
//            }
//        }
//        System.out.println(soma);
//        soma = 0;
//        //soma 1 linha
//        for(int i=0;i<matriz[0].length;i++) {
//            soma += matriz[0][i];
//        }
//        System.out.println(soma);
//        int soma1=soma;
//        soma = 0;
//        //soma 2 linha
//        for(int i=0;i<matriz[0].length;i++) {
//            soma += matriz[1][i];
//        }
//        System.out.println(soma);
//        //diferenca linha 1-2
//        System.out.println(soma1-soma);

//        int[][] matriz = {{1,2},{3,4}};

        //EX3
        double[] vetor;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        System.out.println("Quantos elementos você quer no seu vetor?");
        int quantidadeElementos = sc.nextInt();
        sc.nextLine();
        vetor = new double[quantidadeElementos];
        System.out.println("Preencha os elementos separados por espaço:");
        for(int i=0;i<quantidadeElementos;i++){
            vetor[i] = sc.nextDouble();
        }
        sc.nextLine();
        double soma = 0;
        for(double i:vetor){
            System.out.print(i+" ");
            soma += i;
        }
        System.out.println("Média: "+(soma/quantidadeElementos));

        //EX4
//        String str;
//        Scanner sc = new Scanner(System.in);
//        do {
//            System.out.println("Digite uma palavra: ");
//            str = sc.nextLine();
//            System.out.println(str);
//        }while(!str.equalsIgnoreCase("fim"));

    }

    static void printMat(int[][] matriz){
        int sizeH = matriz.length;
        int sizeV = matriz[0].length;
        for(int i=0;i<sizeH;i++){
            System.out.print("| ");
            for(int j=0;j<sizeV;j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}
