package com.dbc.exercicio4;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> pilha = new Stack<>();

        int numero;


        System.out.println("digite 15 numeros");
        for(int i=0;i<15;i++){
            numero = sc.nextInt();
            if(numero%2==0){
                pilha.add(numero);
            }else{
                //caso a pilha esteja vazia, nao remove
                if(!pilha.isEmpty()){
                    pilha.pop();
                }
            }
        }
        sc.nextLine();
        while(!pilha.isEmpty()){
            System.out.print(pilha.pop()+" ");
        }
        System.out.println();
    }
}
