public class Main {
    public static void main(String[] args) {

        //Criando clientes.
        Cliente cliente1 = new Cliente("João Silva");
        Cliente cliente2 = new Cliente("Valdir Gomes");
        Cliente cliente3 = new Cliente("Joana Pereira");

        //Criando bancos.
        Banco banco = new Banco("Banco do Brasil");
        Banco banco2 = new Banco("Bradesco");

        //Criando contas de clientes em bancos;
        Conta CC1 = new ContaCorrente(cliente1, banco);
        Conta CP1 = new ContaPoupanca(cliente2, banco);
        Conta CC2 = new ContaPoupanca(cliente3, banco2);

        //Comando para executar o extrato antes de usar os métodos.
        //CC1.imprimirExtrato(cliente, banco);
        //CP.imprimirExtrato(cliente2, banco);
        //CC2.imprimirExtrato(cliente3, banco2);

        //Exemplos de como utilizar métodos.
        CC1.depositar(100, cliente1);
        CC1.abrirConta();
        CC1.sacar(10, cliente1);
        CC1.transferir(50,CP1,cliente2);
        CP1.depositar(15,cliente2);
        CC2.sacar(50, cliente3);

       //Comando para executar o extrato após usar os métodos.
        CC1.imprimirExtrato(cliente1, banco);
        CP1.imprimirExtrato(cliente2, banco);
        CC2.imprimirExtrato(cliente3, banco2);

    }
}
