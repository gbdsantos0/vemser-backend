package com.dbc;

import java.text.DecimalFormat;

public class ContaPoupanca extends Conta implements Impressao{

    private static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, int agencia){
        super(cliente, numeroConta, agencia);
    }

    public void creditarTaxa(){
        super.setSaldo(super.getSaldo()*JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Informações da conta do cliente: ");
        super.getCliente().imprimirCliente();
        System.out.println("Agência: "+super.getAgencia()+" Conta: "+super.getNumeroConta());
        System.out.println("Saldo: "+df.format(super.getSaldo()));
    }
}
