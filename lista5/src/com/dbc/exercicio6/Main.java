package com.dbc.exercicio6;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        listaPessoas.add(new Pessoa("Zorro","B",5,""));
        listaPessoas.add(new Pessoa("Zorro","A",10,""));
        listaPessoas.add(new Pessoa("Corsair","A",19,""));
        listaPessoas.add(new Pessoa("Zorro","D",300,""));
        listaPessoas.add(new Pessoa("Cabral","A",25,""));
        listaPessoas.add(new Pessoa("Zorro","C",13,""));
        listaPessoas.add(new Pessoa("Alce","A",30,""));





        System.out.println(listaPessoas);
        listaPessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getNome().compareToIgnoreCase(o2.getNome());
            }
        });

        System.out.println(listaPessoas);

        listaPessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o2.getIdade()- o1.getIdade();
            }
        });

        System.out.println(listaPessoas);

        listaPessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                if(o2.getNome().equalsIgnoreCase(o1.getNome())){
                    return o1.getIdade() - o2.getIdade();
                }
                return o1.getNome().compareToIgnoreCase(o2.getNome());
            }
        });

        System.out.println(listaPessoas);

    }
}
