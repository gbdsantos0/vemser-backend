package com.dbc;

public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatos;
    public Endereco[] enderecos;

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos){
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = new Contato[2];
        this.enderecos = new Endereco[2];
        for(int i=0;i<contatos.length;i++){
            this.contatos[i]=contatos[i];
        }
        for(int i=0;i<enderecos.length;i++){
            this.enderecos[i]=enderecos[i];
        }
    }

    public void imprimirContatos(){
        for(int i=0;i<contatos.length;i++){
            System.out.println("Contato "+ (i+1) +":");
            contatos[i].imprimirContato();
        }
    }

    public void imprimirEnderecos(){
        for(int i=0;i<enderecos.length;i++){
            System.out.println("Endereço "+ (i+1) +":");
            enderecos[i].imprimirEndereco();
        }
    }

    public void imprimirCliente(){
        System.out.println("Cliente: "+this.nome+" CPF: "+this.cpf);
    }
}
