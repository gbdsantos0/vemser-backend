package com.dbc;

public abstract class Conta implements Movimentacao{

    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;

    public Conta(Cliente cliente, String numeroConta, int agencia){
        this.setCliente(cliente);
        this.setNumeroConta(numeroConta);
        this.setAgencia(agencia);
        this.setSaldo(0);
    }


    public boolean sacar(double valorParaSacar){
        if(valorParaSacar>0){
            //valor maior do que o disponível
            if(valorParaSacar>this.getSaldo()){
                return false;
            }
            this.setSaldo(this.getSaldo()-valorParaSacar);
            return true;
        }
        //valor menor ou igual a 0
        return false;
    }

    public boolean depositar(double valorParaDepositar){
        if(valorParaDepositar>0){
            this.setSaldo(this.getSaldo()+valorParaDepositar);
            return true;
        }
        //valor negativo ou 0
        return false;
    }

    public boolean transferir(Conta contaParaTransferir, double valorParaTransferir){
        if(valorParaTransferir>0){//redundante
            //se saque for efetuado com sucesso, pode depositar na outra conta
            if(this.sacar(valorParaTransferir)){
                contaParaTransferir.depositar(valorParaTransferir);
                return true;
            }
        }
        return false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
