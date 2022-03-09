package com.dbc.aula7.exercicio1;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TipoComida tipo = null;
        Scanner sc = new Scanner(System.in);

        String escolha;

        System.out.println("Escolha a comida:\n1 - Japonesa\n2 - Fast Food\n3 - Tradicional");
        escolha = sc.nextLine().toUpperCase().replace(" ", "_");

//        if(escolha.matches("[0-9]*")){
//            int numero = (int) escolha.charAt(0);
//            switch (numero) {
//                case 1:
//                    tipo = TipoComida.valueOf("JAPONESA");
//                    break;
//                case 2:
//                    tipo = TipoComida.valueOf("FAST FOOD");
//                    break;
//                case 3:
//                    tipo = TipoComida.valueOf("TRADICIONAL");
//                    break;
//            };
//        }else{
//            switch (TipoComida.valueOf(escolha.toUpperCase(Locale.ROOT))){
//                case JAPONESA:
//                    tipo = TipoComida.valueOf("JAPONESA");
//                    break;
//                case FAST_FOOD:
//                    tipo = TipoComida.valueOf("FAST FOOD");
//                    break;
//                case TRADICIONAL:
//                    tipo = TipoComida.valueOf("TRADICIONAL");
//                    break;
//                default:
//                    tipo = null;
//                    break;
//
//            }
//        }


        tipo = TipoComida.valueOf(escolha);

        if(tipo!=null){
            System.out.println(tipo);
        }

        System.out.println(TipoComida.comidasComValorMenorQue(40));



    }
}
