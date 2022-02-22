package com.dbc.aula5.arraylist;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ArrayList<String> minhalista = new ArrayList<>();
//
//        minhalista.add("VAMO");
//        minhalista.add("la");
//        System.out.println(minhalista.size());
//        System.out.println(minhalista.get(1));
//        System.out.println(minhalista);
//        minhalista.set(1,"LA");
//        System.out.println(minhalista);

        Scanner sc = new Scanner(System.in);
        String nome = "";
        ArrayList<String> listaNomes = new ArrayList<>();

//        do{
//            nome = sc.nextLine();
//            if(!nome.equalsIgnoreCase("sair")){
//                listaNomes.add(nome);
//            }
//        }while(!nome.equalsIgnoreCase("sair"));

        System.out.println("Digite um nome: (\"sair\" para sair)");
        nome = sc.nextLine();
        while(!nome.equalsIgnoreCase("sair")){
            listaNomes.add(nome);
            System.out.println("Digite um nome: (\"sair\" para sair)");
            nome = sc.nextLine();
        }

        //penultimo nome
        if(listaNomes.size()>1){
            System.out.println("Penultimo nome: "+ listaNomes.get(listaNomes.size()-2));
        }

        //primeiro nome
        if(listaNomes.size()>0){
            System.out.println("Primeiro nome: "+ listaNomes.get(0));
        }

        //remover e printar lista
        System.out.println(listaNomes);
        if(listaNomes.size()>0){
            listaNomes.remove(listaNomes.size()-1);
            System.out.println("Lista com ultimo removido: "+listaNomes);
        }

        //lista e tamanho
        System.out.println("Lista: "+listaNomes+"\tTamanho: "+listaNomes.size());

    }
}
