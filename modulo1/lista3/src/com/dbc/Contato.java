package com.dbc;

public class Contato {
    public String descricao;
    public String telefone;
    public int tipo;//1 - residencial, 2 - comercial

    public Contato(String descricao, String telefone, int tipo){
        this.descricao = descricao;
        this.telefone = telefone;
        if(tipo!=1&&tipo!=2){
            this.tipo = 1;
        }else{
            this.tipo = tipo;
        }
    }

    public void imprimirContato(){
        System.out.println("Telefone: "+this.telefone+" - "+((this.tipo==1)?"Residencial":"Comercial")+"\n"+this.descricao);
    }
}
