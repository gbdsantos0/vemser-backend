package com.dbc.homework;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos;
    private ArrayList<Endereco> enderecos;

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos){
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = new ArrayList<>(contatos);
        this.enderecos = new ArrayList<>(enderecos);
    }

    public void imprimirContatos(){
        for(int i=0;!contatos.isEmpty();i++){
            System.out.println("Contato "+ (i+1) +":");
            contatos.get(i).imprimirContato();
        }
    }

    public void imprimirEnderecos(){
        for(int i=0;!enderecos.isEmpty();i++){
            System.out.println("Endereco "+ (i+1) +":");
            enderecos.get(i).imprimirEndereco();
        }
    }

    public void imprimirCliente(){
        System.out.println("Cliente: "+this.nome+" CPF: "+this.cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }
}
