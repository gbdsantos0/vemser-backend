package com.dbc.aula5.sort;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> vetor = new ArrayList<>();
        vetor.add(3);
        vetor.add(2);
        vetor.add(1);

        System.out.println(vetor);

        vetor.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });

        System.out.println(vetor);

    }
}
