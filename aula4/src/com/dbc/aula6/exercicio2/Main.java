package com.dbc.aula6.exercicio2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Double,Double> coseno = a -> Math.cos(a);
        Function<Double,Double> raiz = a -> Math.sqrt(a);

        System.out.println(coseno.apply(1.0));
        System.out.println(raiz.apply(0.5403023058681398));

        Function<Double,Double> osDois = coseno.andThen(raiz);

        System.out.println(coseno.andThen(raiz).apply(1.0));
        System.out.println(osDois.apply(1.0));

        BiFunction<Double,Double,Double> biCoisa = (a,b)-> a-b;
        //BiFunction<Double,Double,Double> biCoisa2 = (a,b) -> Math.sqrt(a);

        BiFunction<Double,Double,Double> biCoisa3 = biCoisa.andThen(raiz);

        System.out.println(biCoisa.apply(3.0,1.0));


    }
}
