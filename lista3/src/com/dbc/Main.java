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

        Endereco endereco = new Endereco(1,"Sao Pedro", 115, "Casa", "96170-000", "Sao Lourenco do Sul", "RS", "Brasil");
        endereco.imprimirEndereco();

        Endereco[] enderecos = new Endereco[2];
        enderecos[0] = endereco;
        enderecos[1] = new Endereco(1,"Jacob Rheingantz", 185, "Casa", "96170-000", "Sao Lourenco do Sul", "RS", "Brasil");

        System.out.println("##############################################################");

        Contato contato = new Contato("apenas ele","12312312323", 2);
        contato.imprimirContato();
        Contato[] contatos = new Contato[2];
        contatos[0] = contato;
        contatos[1] = new Contato("ele mesmo","321321321321", 1);

        System.out.println("##############################################################");

        Cliente cliente = new Cliente("Gustavo","000.000.000-00", contatos, enderecos);

        cliente.imprimirCliente();
        cliente.imprimirContatos();
        cliente.imprimirEnderecos();

        System.out.println("##############################################################");

        ContaCorrente contaCorrente = new ContaCorrente(cliente,"123456",123);

        //conta 2 com o mesmo cliente para testes
        ContaCorrente contaCorrente2 = new ContaCorrente(cliente,"999999",888);


        //impressao da conta corrente
        contaCorrente.imprimirContaCorrente();
        System.out.println("##############################################################");
        //tentativa falha de sacar
        if(contaCorrente.sacar(1100)){
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Sem saldo.");
        }
        contaCorrente.imprimirContaCorrente();
        System.out.println("##############################################################");
        //deposito
        if(contaCorrente.depositar(1000)){
            System.out.println("Deposito efetuado com sucesso!");
        }else{
            System.out.println("Falha no deposito.");
        }
        contaCorrente.imprimirContaCorrente();
        System.out.println("##############################################################");
        //tentativa com sucesso
        if(contaCorrente.sacar(100)){
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Sem saldo.");
        }
        contaCorrente.imprimirContaCorrente();
        System.out.println("##############################################################");
        //saque cheque especial(resultado 900 no especial)
        if(contaCorrente.sacar(1000)){
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Sem saldo.");
        }
        contaCorrente.imprimirContaCorrente();
        System.out.println("##############################################################");

        //transferencia
        contaCorrente2.imprimirContaCorrente();
        contaCorrente.transferir(contaCorrente2,800);
        contaCorrente2.imprimirContaCorrente();
        contaCorrente.imprimirContaCorrente();
        System.out.println("##############################################################");
    }
}
