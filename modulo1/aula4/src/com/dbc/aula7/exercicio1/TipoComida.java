package com.dbc.aula7.exercicio1;

import java.util.Arrays;
import java.util.List;

public enum TipoComida {
    JAPONESA(50, "japonesa"), FAST_FOOD(30, "fast food"), TRADICIONAL(20, "tradicional");

    private double valor;
    private String descricao;

    TipoComida(double valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }

    //COMO BUSCAR POR VALOR? POR EXEMPLO, QUERO COMIDAS COM VALOR MENOR QUE 40 STREAMS?
    public static List<TipoComida> comidasComValorMenorQue(double valorMaximo){
        return Arrays.asList(values()).stream()
                .filter(tipoComida -> tipoComida.getValor()<valorMaximo)
                .toList();
    }

    public static TipoComida valueOfByDescricao(String descricao){
        return Arrays.asList(values()).stream()
                .filter(tipoComida -> tipoComida.getDescricao().equalsIgnoreCase(descricao))
                .findFirst()
                .get();
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Comida " + descricao +
                " valor: R$ " + valor;
    }
}
