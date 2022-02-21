package com.dbc;

public class Contato {
    private String descricao;
    private String telefone;
    private int tipo;//1 - residencial, 2 - comercial

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if(tipo!=1&&tipo!=2){
            this.tipo = 1;
        }else{
            this.tipo = tipo;
        }
    }
}
