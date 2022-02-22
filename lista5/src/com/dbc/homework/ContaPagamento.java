package com.dbc.homework;

import java.text.DecimalFormat;

public class ContaPagamento extends Conta implements Impressao{

    private static double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, int agencia) {
        super(cliente, numeroConta, agencia);
    }

    @Override
    public boolean sacar(double valorParaSacar){
        if(valorParaSacar>0){
            //valor maior do que o disponível
            if(valorParaSacar+TAXA_SAQUE>this.getSaldo()){
                return false;
            }
            super.setSaldo(super.getSaldo()-(valorParaSacar+TAXA_SAQUE));
            return true;
        }
        //valor menor ou igual a 0
        return false;
    }

    @Override
    public boolean transferir(Conta contaParaTransferir, double valorParaTransferir){
        if(valorParaTransferir>0){//redundante
            //se saque for efetuado com sucesso, pode depositar na outra conta
            if(super.sacar(valorParaTransferir)){
                contaParaTransferir.depositar(valorParaTransferir);
                return true;
            }
        }
        return false;
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
