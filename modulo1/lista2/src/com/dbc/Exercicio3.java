package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int contador;
        int maior = 0;
        int velho = 0;
        int pesado = 0;
        float mediaAltura = 0.0f;

        String[] nome = new String[100];
        float[] altura = new float[100];
        int[] idade = new int[100];
        float[] peso = new float[100];

        //laco de coleta de dados
        for(contador=0;;contador++){
            System.out.println("Digite o nome do jogador: (Digite \"fim\" para sair)");
            nome[contador] = sc.nextLine();
            //identificar fim e limpar ultimo nome.
            if(nome[contador].equalsIgnoreCase("fim")){
                nome[contador] = "";
                clearScreen();
                break;
            }

            System.out.println("Digite a altura do jogador:");
            altura[contador] = sc.nextFloat();
            sc.nextLine();

            System.out.println("Digite a idade do jogador:");
            idade[contador] = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite o peso do jogador:");
            peso[contador] = sc.nextFloat();
            sc.nextLine();

            clearScreen();
        }

        //quantidade de jogadores
        System.out.println("Quantidade de jogadores cadastrados: "+contador+"\n");

        //altura do maior jogador
        for(int i=1;i<contador;i++){
            if(altura[maior]<altura[i]){
                maior = i;
            }
        }
        System.out.println("Maior jogador: "+ nome[maior] +"\nAltura: "+ altura[maior]+"\n");

        //jogador mais velho
        for(int i=1;i<contador;i++){
            if(idade[velho]<idade[i]){
                velho = i;
            }
        }
        System.out.println("Jogador mais velho: "+ nome[velho] +"\nIdade: "+ idade[velho]+"\n");

        //jogador mais pesado
        for(int i=1;i<contador;i++){
            if(peso[pesado]<peso[i]){
                pesado = i;
            }
        }
        System.out.println("Jogador mais pesado: "+ nome[pesado] +"\nPeso: "+ peso[pesado]+"\n");

        //media de altura
        for(int i=0;i<contador;i++){
            mediaAltura += altura[i];
        }
        mediaAltura /= contador;
        System.out.println("Média da altura dos jogadores: "+mediaAltura+"\n");

    }

    static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
