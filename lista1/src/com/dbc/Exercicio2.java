package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        float nota1;
        float nota2;
        float nota3;
        float nota4;
        float notaFinal;

        System.out.println("Digite suas quatro notas separadas por espaço: ");
        nota1 = sc.nextFloat();
        nota2 = sc.nextFloat();
        nota3 = sc.nextFloat();
        nota4 = sc.nextFloat();
        sc.nextLine();
        while(notaInvalida(nota1)||notaInvalida(nota2)||notaInvalida(nota3)||notaInvalida(nota4)){
            System.out.println("Nota inválida!\nDigite suas quatro notas separadas por espaço: ");
            nota1 = sc.nextFloat();
            nota2 = sc.nextFloat();
            nota3 = sc.nextFloat();
            nota4 = sc.nextFloat();
            sc.nextLine();
        }

        notaFinal = (float)(nota1 + nota2 + nota3 + nota4)/4;

        if(notaFinal<=5){
            System.out.println("Nota final: "+notaFinal+"\nResultado: Reprovado");
        }else if(notaFinal<7){
            System.out.println("Nota final: "+notaFinal+"\nResultado: Exame");
        }else{
            System.out.println("Nota final: "+notaFinal+"\nResultado: Aprovado");
        }
    }

    static boolean notaInvalida(float nota){
        if(nota>10 || nota<0){
            return true;
        }
        return false;
    }

}
