package com.dbc;

public class Main {

    public static void main(String[] args) {
        //criar uma main para testar todas as operaçoes de conta corrente
        //esse teste deve ter ao menos 2 clientes com uma conta corrente cada um
        //1 transferencia entre eles
        //ao final imprimir as duas contas

        //atentar as excessoes
        //nao eh permitido sacar mais do que o saldo+cheque especial
        //nao eh permitido depositar, transferir e sacar valores negativos

        System.out.println("##############################################################");
        System.out.println("###ENDERECO###");

        Endereco endereco = new Endereco(1,"Sao Pedro", 115, "Casa", "96170-000", "Sao Lourenco do Sul", "RS", "Brasil");
        endereco.imprimirEndereco();

        Endereco[] enderecos = new Endereco[2];
        enderecos[0] = endereco;
        //enderecos[1] = new Endereco(1,"Jacob Rheingantz", 185, "Casa", "96170-000", "Sao Lourenco do Sul", "RS", "Brasil");

        System.out.println("##############################################################");
        System.out.println("###CONTATO###");

        Contato contato = new Contato("apenas ele","12312312323", 2);
        contato.imprimirContato();
        Contato[] contatos = new Contato[2];
        contatos[0] = contato;
        contatos[1] = new Contato("ele mesmo","321321321321", 1);

        System.out.println("##############################################################");
        System.out.println("###CLIENTE###");

        Cliente cliente = new Cliente("Gustavo","000.000.000-00", contatos, enderecos);

        cliente.imprimirCliente();
        cliente.imprimirContatos();
        cliente.imprimirEnderecos();

        System.out.println("##############################################################");
        System.out.println("###CONTA CORRENTE 1###");

        ContaCorrente contaCorrente = new ContaCorrente(cliente,"123456",123);

        contaCorrente.imprimir();

        System.out.println("##############################################################");
        System.out.println("###CONTA POUPANCA 1###");

        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente,"999999",888);

        contaPoupanca.imprimir();
        //impressao da conta corrente

        System.out.println("##############################################################");
        System.out.println("###SAQUE DE 1100 SEM SALDO###");
        //tentativa falha de sacar
        if(contaCorrente.sacar(1100)){
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Sem saldo.");
        }

        System.out.println();

        contaCorrente.imprimir();
        System.out.println("##############################################################");
        System.out.println("###DEPOSITO DE 1000###");
        //deposito
        if(contaCorrente.depositar(1000)){
            System.out.println("Deposito efetuado com sucesso!");
        }else{
            System.out.println("Falha no deposito.");
        }

        System.out.println();

        contaCorrente.imprimir();
        System.out.println("##############################################################");
        System.out.println("###SAQUE DE 100###");
        //tentativa com sucesso
        if(contaCorrente.sacar(100)){
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Sem saldo.");
        }

        System.out.println();

        contaCorrente.imprimir();
        System.out.println("##############################################################");


        System.out.println("###SAQUE DE 1000, COM USO DO CHEQUE ESPECIAL###");
        //saque cheque especial(resultado 900 no especial)
        if(contaCorrente.sacar(1000)){
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Sem saldo.");
        }
        contaCorrente.imprimir();
        System.out.println("##############################################################");
        System.out.println("###TRANSFERENCIA DE 800 DA CONTA 1 PARA A CONTA 2###");

        //transferencia

        contaCorrente.imprimir();
        System.out.println();

        contaPoupanca.imprimir();
        System.out.println();
        if(contaCorrente.transferir(contaPoupanca,800)){
            System.out.println("Transferencia realizada com sucesso");
        }else{
            System.out.println("Sem saldo para transferencia");
        }

        System.out.println();
        contaCorrente.imprimir();

        System.out.println();
        contaPoupanca.imprimir();

        System.out.println("##############################################################");
        System.out.println("###TRANSFERENCIA FALHA DE 800 DA CONTA 1 PARA A CONTA 2###");

        //transferencia

        contaCorrente.imprimir();
        System.out.println();

        contaPoupanca.imprimir();
        System.out.println();
        if(contaCorrente.transferir(contaPoupanca,800)){
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
