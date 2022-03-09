package com.dbc;

public class Endereco {
    public int tipo;//1 - residencial, 2 - comercial
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        if(tipo!=1&&tipo!=2){
            this.tipo = 1;
        }else{
            this.tipo = tipo;
        }
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public void imprimirEndereco(){
        System.out.println("Endereço: \nRua "+this.logradouro+", "+this.numero+ "\n"
                +this.cidade+"/"+this.estado
                +"\nCEP: "+this.cep+" - Complemento: "+this.complemento+" - Tipo: "+((this.tipo==1)?"Residencial":"Comercial")+"\n"
                +this.pais);
    }
}
