package com.dbc;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.println("Escolha um estado:\n1 - RS\n2 - SC\n3 - PR");
        opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao){
            case 1:
                System.out.println("Escolha uma cidade:\n1 - Porto Alegre\n2 - Pelotas");
                opcao = sc.nextInt();
                sc.nextLine();
                if(opcao == 1){
                    System.out.println("População: 1409351\nIDH: 0.805(2010)");
                }else if(opcao == 2){
                    System.out.println("População: 343132\nIDH: 0.739(2010)");
                }else{
                    System.out.println("Cidade inválida");
                }
                break;
            case 2:
                System.out.println("Escolha uma cidade:\n1 - Florianópolis\n2 - Itajaí");
                opcao = sc.nextInt();
                sc.nextLine();
                if(opcao == 1){
                    System.out.println("População: 508826\nIDH: 0.847(2010)");
                }else if(opcao == 2){
                    System.out.println("População: 223112\nIDH: 0.795(2010)");
                }else{
                    System.out.println("Cidade inválida");
                }
                break;
            case 3:
                System.out.println("Escolha uma cidade:\n1 - Curitiba\n2 - Araucária");
                opcao = sc.nextInt();
                sc.nextLine();
                if(opcao == 1){
                    System.out.println("População: 1963723\nIDH: 0.823(2010)");
                }else if(opcao == 2){
                    System.out.println("População: 146214\nIDH: 0.740(2010)");
                }else{
                    System.out.println("Cidade inválida");
                }
                break;
            default:
                System.out.println("Estado inválido");
                break;
        }
    }
}
