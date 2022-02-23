package com.dbc.aula6.exercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.println("Digite um numero para calcular o somatório: ");
        numero = sc.nextInt();
        while(numero!=0){
            System.out.println("Valor do somatório de "+numero+": "+somatorio(numero));
            System.out.println();
            System.out.println("Digite um numero para calcular o somatório: ");
            numero = sc.nextInt();
        }

        //lambda nao funcionou
       // Funcao somatorio = i -> (i==1)?1:i+somatorio.somatorio(i-1);


    }

    public static int somatorio(int numero){
//        if(numero == 1){
//            return 1;
//        }
//        return numero+somatorio(numero-1);

        return (numero==1)?1:numero+somatorio(numero-1);
    }
}
