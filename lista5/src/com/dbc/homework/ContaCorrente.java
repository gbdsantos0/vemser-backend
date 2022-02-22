package com.dbc.homework;

import java.text.DecimalFormat;

public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia){
        super(cliente, numeroConta, agencia);
        this.setChequeEspecial(1000);
    }

    @Override
    public boolean sacar(double valorParaSacar){
        if(valorParaSacar>0){
            //valor maior do que o disponível
            if(valorParaSacar>this.retornarSaldoComChequeEspecial()){
                return false;
            }
            super.setSaldo(super.getSaldo()-valorParaSacar);
            return true;
        }
        //valor menor ou igual a 0
        return false;
    }

    public double retornarSaldoComChequeEspecial(){
        return super.getSaldo()+this.chequeEspecial;//getChequeEspecial
    }

//    public double getChequeEspecial() {
//        return chequeEspecial;
//    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void imprimir() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Informações da conta do cliente: ");
        super.getCliente().imprimirCliente();
        System.out.println("Agência: "+super.getAgencia()+" Conta: "+super.getNumeroConta());
        System.out.println("Saldo: "+df.format(super.getSaldo()));
        System.out.println("Cheque Especial: "+df.format(this.chequeEspecial));//getChequeEspecial
    }
}
