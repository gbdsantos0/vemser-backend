package com.dbc.homework;

public interface Movimentacao {
    public boolean sacar(double valorParaSacar);
    public boolean depositar(double valorParaDepositar);
    public boolean transferir(Conta contaParaTransferir, double valorParaTransferir);
}
