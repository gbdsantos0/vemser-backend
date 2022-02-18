package com.dbc;

import java.text.DecimalFormat;

public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

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

    public boolean sacar(double valorParaSacar){
        if(valorParaSacar<0){
            return false;
        }
        double diferenca = 0;

        if(this.saldo+this.chequeEspecial<valorParaSacar){
            return false;
        }else if(this.saldo<valorParaSacar){
            diferenca = valorParaSacar - this.saldo;
            this.saldo = 0;
            this.chequeEspecial-=diferenca;
            return true;
        }else{
            this.saldo-=valorParaSacar;
            return true;
        }
    }

    public boolean depositar(double valorParaDepositar){
        if(valorParaDepositar<0){
            return false;
        }
        this.saldo+=valorParaDepositar;
        return true;
    }

    public double retornarSaldoComChequeEspecial(){
        return this.saldo+this.chequeEspecial;
    }

    public boolean transferir(ContaCorrente contaParaTransferir, double valorParaTransferir){
        if(valorParaTransferir<0){
            return false;
        }
        double diferenca = 0;
        if(this.saldo+this.chequeEspecial<valorParaTransferir){
            return false;
        }else if(this.saldo<valorParaTransferir){
            diferenca = valorParaTransferir - this.saldo;
            this.saldo = 0;
            this.chequeEspecial-=diferenca;
            contaParaTransferir.depositar(valorParaTransferir);
            return true;
        }else{
            this.saldo-=valorParaTransferir;
            contaParaTransferir.depositar(valorParaTransferir);
            return true;
        }
    }
}
