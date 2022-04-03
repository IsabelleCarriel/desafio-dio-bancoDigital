public interface InterfaceConta {

    void sacar(double valor, Cliente cliente);

    void depositar(double valor, Cliente cliente);

    void transferir(double valor, Conta contaDestino, Cliente cliente);

    void imprimirExtrato(Cliente cliente, Banco banco);
}
