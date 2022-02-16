package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        float valorTotalConsumido;
        float valorPagoPeloCliente;

        System.out.println("Digite o valor total da conta do cliente: ");
        valorTotalConsumido = sc.nextFloat();
        sc.nextLine();

        System.out.println("Digite o valor pago pelo cliente: ");
        valorPagoPeloCliente = sc.nextFloat();
        sc.nextLine();

        if(valorTotalConsumido>valorPagoPeloCliente){
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido");
        }else{
            System.out.println("Valor do troco: "+(valorPagoPeloCliente-valorTotalConsumido));
        }

    }
}
