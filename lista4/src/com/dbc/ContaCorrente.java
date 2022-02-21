package com.dbc;

import java.text.DecimalFormat;

public class ContaCorrente {
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia){
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = 0;
        this.chequeEspecial = 1000;
    }

    public void imprimirContaCorrente(){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Informações da conta do cliente: ");
        this.cliente.imprimirCliente();
        System.out.println("Agência: "+this.agencia+" Conta: "+this.numeroConta);
        System.out.println("Saldo: "+df.format(this.saldo));
        System.out.println("Cheque Especial: "+df.format(this.chequeEspecial));
    }

//    public boolean sacar(double valorParaSacar){
//        if(valorParaSacar<0){
//            return false;
//        }
//        double diferenca = 0;
//
//        if(this.saldo+this.chequeEspecial<valorParaSacar){
//            return false;
//        }else if(this.saldo<valorParaSacar){
//            diferenca = valorParaSacar - this.saldo;
//            this.saldo = 0;
//            this.chequeEspecial-=diferenca;
//            return true;
//        }else{
//            this.saldo-=valorParaSacar;
//            return true;
//        }
//    }

    public boolean sacar(double valorParaSacar){
        if(valorParaSacar>0){
            //valor maior do que o disponível
            if(valorParaSacar>retornarSaldoComChequeEspecial()){
                return false;
            }
            saldo-=valorParaSacar;
            return true;
        }
        //valor menor ou igual a 0
        return false;
    }

//    public boolean depositar(double valorParaDepositar){
//        if(valorParaDepositar<0){
//            return false;
//        }
//        this.saldo+=valorParaDepositar;
//        return true;
//    }

    public boolean depositar(double valorParaDepositar){
        if(valorParaDepositar>0){
            saldo+=valorParaDepositar;
            return true;
        }
        //valor negativo ou 0
        return false;
    }

    public double retornarSaldoComChequeEspecial(){
        return this.saldo+this.chequeEspecial;
    }

//    public boolean transferir(ContaCorrente contaParaTransferir, double valorParaTransferir){
//        if(valorParaTransferir<0){
//            return false;
//        }
//        double diferenca = 0;
//        if(this.saldo+this.chequeEspecial<valorParaTransferir){
//            return false;
//        }else if(this.saldo<valorParaTransferir){
//            diferenca = valorParaTransferir - this.saldo;
//            this.saldo = 0;
//            this.chequeEspecial-=diferenca;
//            contaParaTransferir.depositar(valorParaTransferir);
//            return true;
//        }else{
//            this.saldo-=valorParaTransferir;
//            contaParaTransferir.depositar(valorParaTransferir);
//            return true;
//        }
//    }

    public boolean transferir(ContaCorrente contaParaTransferir, double valorParaTransferir){
        if(valorParaTransferir>0){
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

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}
