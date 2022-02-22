package com.dbc.exercicio3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        //5 entram na fila
        for(int i=0;i<5;i++){
            fila.add(i+1);
        }
        System.out.println(fila);
        //2 atendidos
        for(int i=0;i<2;i++){
            fila.poll();
        }
        System.out.println(fila);
        //+1 atendido
        fila.poll();
        System.out.println(fila);
        //+3 entram na fila
        for(int i=0;i<3;i++){
            fila.add(i+1+5);
        }
        System.out.println(fila);
        //+3 atendidos
        for(int i=0;i<3;i++){
            fila.poll();
        }
        System.out.println(fila);
    }
}
