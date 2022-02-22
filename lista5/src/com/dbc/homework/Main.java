package com.dbc.homework;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //criar uma main para testar todas as operaçoes de conta corrente
        //esse teste deve ter ao menos 2 clientes com uma conta corrente cada um
        //1 transferencia entre eles
        //ao final imprimir as duas contas

        //atentar as excessoes
        //nao eh permitido sacar mais do que o saldo+cheque especial
        //nao eh permitido depositar, transferir e sacar valores negativos

//        System.out.println("##############################################################");
//        System.out.println("###ENDERECO###");

        Endereco endereco = new Endereco(1,"Sao Pedro", 115, "Casa", "96170-000", "Sao Lourenco do Sul", "RS", "Brasil");
//        endereco.imprimirEndereco();

        ArrayList<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        //enderecos[1] = new Endereco(1,"Jacob Rheingantz", 185, "Casa", "96170-000", "Sao Lourenco do Sul", "RS", "Brasil");

//        System.out.println("##############################################################");
//        System.out.println("###CONTATO###");

        Contato contato = new Contato("descricao1","12312312323", 2);
//        contato.imprimirContato();
        ArrayList<Contato> contatos = new ArrayList<>();
        contatos.add(contato);
        contatos.add(new Contato("descricao2","321321321321", 1));

//        System.out.println("##############################################################");
//        System.out.println("###CLIENTE###");

        Cliente cliente = new Cliente("Gustavo","000.000.000-00", contatos, enderecos);

//        cliente.imprimirCliente();
//        cliente.imprimirContatos();
//        cliente.imprimirEnderecos();

        Cliente cliente2 = new Cliente("Hatii","999.999.999-99", contatos, enderecos);

        System.out.println("##############################################################");
        System.out.println("###CONTA CORRENTE 1###");

        ContaCorrente contaCorrente = new ContaCorrente(cliente,"123456",123);

        contaCorrente.imprimir();

        System.out.println("##############################################################");
        System.out.println("###CONTA POUPANCA 1###");

        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente2,"999999",888);

        contaPoupanca.imprimir();

        System.out.println("##############################################################");
        System.out.println("###CONTA PAGAMENTO 1###");

        ContaPagamento contaPagamento = new ContaPagamento(cliente, "777777", 777);

        contaPagamento.imprimir();

        System.out.println("##############################################################");
        System.out.println("###SAQUE DE 1100 SEM SALDO###");
        //tentativa falha de sacar
        if(contaPagamento.sacar(1100)){
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Sem saldo.");
        }

        System.out.println();

        contaPagamento.imprimir();
        System.out.println("##############################################################");
        System.out.println("###DEPOSITO DE 1000###");
        //deposito
        if(contaPagamento.depositar(1000)){
            System.out.println("Deposito efetuado com sucesso!");
        }else{
            System.out.println("Falha no deposito.");
        }

        System.out.println();

        contaPagamento.imprimir();

        System.out.println("##############################################################");
        System.out.println("###SAQUE FALHO DE 999 POR CONTA DA TAXA DE 4,25###");
        //tentativa com sucesso
        if(contaPagamento.sacar(999)){
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Sem saldo.");
        }

        System.out.println();

        contaPagamento.imprimir();

        System.out.println("##############################################################");
        System.out.println("###SAQUE DE 100###");
        //tentativa com sucesso
        if(contaPagamento.sacar(100)){
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Sem saldo.");
        }

        System.out.println();

        contaPagamento.imprimir();

        System.out.println("##############################################################");
        System.out.println("###TRANSFERENCIA FALHA DE 1200 DA CONTA CORRENTE PARA A CONTA POUPANCA###");

        //transferencia

        contaCorrente.imprimir();
        System.out.println();

        contaPoupanca.imprimir();
        System.out.println();
        if(contaCorrente.transferir(contaPoupanca,1200)){
            System.out.println("Transferencia realizada com sucesso");
        }else{
            System.out.println("Sem saldo para transferencia");
        }

        System.out.println();
        contaCorrente.imprimir();

        System.out.println();
        contaPoupanca.imprimir();

        System.out.println("##############################################################");
        System.out.println("###TRANSFERENCIA  DE 200 DA CONTA PAGAMENTO PARA A CONTA CORRENTE###");

        //transferencia

        contaPagamento.imprimir();
        System.out.println();

        contaCorrente.imprimir();
        System.out.println();
        if(contaPagamento.transferir(contaCorrente,200)){
            System.out.println("Transferencia realizada com sucesso");
        }else{
            System.out.println("Sem saldo para transferencia");
        }

        System.out.println();
        contaPagamento.imprimir();

        System.out.println();
        contaCorrente.imprimir();

        System.out.println("##############################################################");
        System.out.println("###TRANSFERENCIA  DE 300 DA CONTA CORRENTE PARA A CONTA POUPANCA###");

        //transferencia

        contaCorrente.imprimir();
        System.out.println();

        contaPoupanca.imprimir();
        System.out.println();
        if(contaCorrente.transferir(contaPoupanca,300)){
            System.out.println("Transferencia realizada com sucesso");
        }else{
            System.out.println("Sem saldo para transferencia");
        }

        System.out.println();
        contaCorrente.imprimir();

        System.out.println();
        contaPoupanca.imprimir();

        System.out.println("##############################################################");
        System.out.println("###CREDITAR TAXA CONTA POUPANCA 1###");

        contaPoupanca.creditarTaxa();
        contaPoupanca.imprimir();
    }
}
