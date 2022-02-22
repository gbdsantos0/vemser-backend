package com.dbc.aula5.pratica1;

public class Divisao implements OperacaoMatematica{
    @Override
    public double calcula(double a, double b) {
        if(b==0){
            System.err.println("divisao por 0");
            return 0;
        }
        return a/b;
    }
}
