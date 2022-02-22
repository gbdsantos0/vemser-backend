package com.dbc.exercicio5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String,String> cpfs = new HashMap<>();
        String cpf = "";
        String nome = "";

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o cpf: (\"sair\" para sair)");
        cpf = sc.nextLine();
        while(!cpf.equalsIgnoreCase("sair")){
            System.out.println("Digite o nome: ");
            nome = sc.nextLine();

            cpfs.put(cpf,nome);

            System.out.println("Digite o cpf: (\"sair\" para sair)");
            cpf = sc.nextLine();
        }

        System.out.println("Consulte um cpf: ");
        cpf = sc.nextLine();
        if(cpfs.containsKey(cpf)){
            System.out.println("Nome do indivíduo com o cpf buscado: " + cpfs.remove(cpf));
        }else{
            System.out.println("Cpf não encontrado");
        }

        System.out.println("Lista final: ");
        System.out.println(cpfs);

    }
}
