package com.dbc.chatkafkaparticao.enums;

public enum NomesChats {
    GERAL("chat-geral"),            //0
    ANA("chat-ana"),                //1
    EZEQUIAS("chat-ezequias"),      //2
    FLAVIO("chat-flavio"),          //3
    FELIPE("chat-felipe"),          //4
    GABRIEL("chat-gabriel"),        //5
    GUILHERME("chat-guilherme"),    //6
    GUSTAVO("chat-gustavo"),        //7
    JOAO("chat-joao"),              //8
    LUCAS("chat-lucas"),            //9
    LUIZ("chat-luiz"),              //10
    MAICON("chat-maicon"),          //11
    NICOLAS("chat-nicolas"),        //12
    PABLO("chat-pablo");            //13

    private String nome;

    NomesChats(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
