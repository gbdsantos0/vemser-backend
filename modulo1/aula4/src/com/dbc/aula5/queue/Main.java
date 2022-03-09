package com.dbc.aula5.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.add("a");
        fila.add("b");
        fila.add("c");

        System.out.println(fila);
        System.out.println(fila.poll());
        System.out.println(fila);
        System.out.println(fila.peek());
        System.out.println(fila);
    }
}
