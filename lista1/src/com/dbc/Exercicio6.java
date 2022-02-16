package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavraIngles;

        System.out.println("Digite a palavra em inglês para ser traduzida: ");
        palavraIngles = sc.nextLine();

        switch(palavraIngles.toLowerCase(Locale.ROOT)){
            case "dog":
                System.out.println("Cachorro");
                break;
            case "time":
                System.out.println("Tempo");
                break;
            case "love":
                System.out.println("Amor");
                break;
            case "city":
                System.out.println("Cidade");
                break;
            case "happy":
                System.out.println("Feliz");
                break;
            case "cachorro":
                System.out.println("Dog");
                break;
            case "tempo":
                System.out.println("Time");
                break;
            case "amor":
                System.out.println("Love");
                break;
            case "cidade":
                System.out.println("City");
                break;
            case "feliz":
                System.out.println("Happy");
                break;
            default:
                System.out.println("Essa palavra não é válida");
                break;
        }
    }
}
