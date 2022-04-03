public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }

    @Override
    public void imprimirExtrato(Cliente cliente, Banco banco) {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns(cliente, banco);
    }
}
