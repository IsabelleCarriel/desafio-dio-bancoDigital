public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }

    @Override
    public void imprimirExtrato(Cliente cliente, Banco banco) {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns(cliente, banco);
    }
}
