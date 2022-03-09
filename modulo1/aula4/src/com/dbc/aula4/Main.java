package com.dbc.aula4;

public class Main {
    public static void main(String[] args) {
//        Pessoa pessoa = new Pessoa();
//        pessoa.nome = "maicon";
//        pessoa.sobrenome = "machado";
//        pessoa.idade = 30;
//        pessoa.whatsApp = "51995869866";
//
//        Pessoa pessoa2 = new Pessoa();
//        pessoa2.nome = "maria";
//        pessoa2.sobrenome = "machado";
//        pessoa2.idade = 28;
//        pessoa2.whatsApp = "51995868866";

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("maicon");
        pessoa.setSobrenome("machado");
        pessoa.setIdade(30);
        pessoa.setWhatsApp("51995869866");

        Pessoa pessoa2 = new Pessoa("maria", "machado", 28, "51995868866");


        System.out.println(pessoa.ehMaiorDeIdade());
        System.out.println(pessoa2.ehMaiorDeIdade());

        pessoa.conversar(pessoa2);

        System.out.println(pessoa.retornarNomeCompleto());
        pessoa.mandarWhats(pessoa2, "Olá, gosta de java?");
    }
}
