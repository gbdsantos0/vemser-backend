package com.dbc.aula5.stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();
        pilha.add("a");
        pilha.add("b");
        pilha.add("c");

        System.out.println(pilha);
        System.out.println(pilha.pop());
        System.out.println(pilha);
        System.out.println(pilha.peek());
    }
}
