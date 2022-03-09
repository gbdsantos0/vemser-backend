package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int[][] matriz = new int[5][4];

        int maiorNotaFinal = 0;
        float mediaNotasFinais = 0;

        //coleta de dados
        for(int i=0;i<5;i++){
            System.out.println("Digite o numero da matricula do "+(i+1)+"° aluno:");
            matriz[i][0] = sc.nextInt();
            System.out.println("Digite a média das provas do "+(i+1)+"° aluno:");
            matriz[i][1] = sc.nextInt();
            System.out.println("Digite a média dos trabalhos do "+(i+1)+"° aluno:");
            matriz[i][2] = sc.nextInt();
        }
        //calculo de nota final
        //detalhe, perda de informações pela matriz ser de inteiros(conforme enunciado)
        for(int i=0;i<5;i++){
            matriz[i][3] = (int) (matriz[i][1] * 0.6 + matriz[i][2] * 0.4);
        }

        //maior nota final
        for(int i=1;i<5;i++){
            if(matriz[maiorNotaFinal][3]<matriz[i][3]){
                maiorNotaFinal = i;
            }
        }
        System.out.println("Aluno com maior nota: "+matriz[maiorNotaFinal][0]+"\nNota final: "+matriz[maiorNotaFinal][3]);

        //media das notas finais
        for(int i=0;i<5;i++){
            mediaNotasFinais += matriz[i][3];
        }
        System.out.println("Média das notas finais: "+(mediaNotasFinais/5));

    }
}
