public abstract class Conta implements InterfaceConta{

    private static final int AGENCIA_PADRAO = 1;

    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected boolean status;
    private Cliente cliente;
    private Banco banco;

    public Conta(Cliente cliente, Banco banco) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.status = true;
        cliente.getNome();
        banco.getNome();
    }

    //Para realizar um saque, é necessario conferir o valor do saldo e se a conta está aberta.
    //Não é possivel sacar um valor maior que o existente no saldo.
    @Override
    public void sacar(double saque, Cliente cliente) {
        if (getStatus()) {
            if (getSaldo() >= saque) {
                saldo = getSaldo() - saque;
                System.out.printf("\nSaque realizado da conta de: %s%n", cliente.getNome());
            } else {
                System.out.println("Não foi possivel sacar. Verifique o saldo.");
            }
        } else{
            System.out.println("Não foi possivel sacar. Conta fechada.");
        }
    }

    //Para realizar uma depósito, é necessario conferir se a conta está aberta.
    @Override
    public void depositar(double valor, Cliente cliente) {
        if(getStatus()){
            this.saldo += valor;
            System.out.printf("\nValor depositado na conta de: %s%n", cliente.getNome());
        }
        else{
            System.out.println("Não foi possivel realizar o deposito. A conta esta fechada.");
        }
    }

    //Para realizar uma transferência, é necessario conferir o valor do saldo e se a conta esta aberta.
    //Não é possivel transferir um valor maior que o existente no saldo.
    @Override
    public void transferir(double valor, Conta contaDestino, Cliente cliente) {
        if(getStatus()) {
            if (getSaldo() >= valor) {
                this.sacar(valor, cliente);
                contaDestino.depositar(valor, cliente);
                System.out.printf("\nTranferência realizada com sucesso. ");
            } else {
                System.out.println("Não foi possível realizar a transferência. Verifique seu saldo.");
            }
        }else{
            System.out.println("Não foi possível realizar a transferência. A conta esta fechada.");
        }
    }

    void abrirConta(){
       if(getStatus()){
           System.out.println("A conta já esta aberta.");
       }else{
           this.setStatus(true);
           System.out.println("Conta aberta com sucesso!");
       }
    }

    void fecharConta() {
        if (getSaldo() > 0) {
            System.out.println("Não foi possivel fechar a conta. Verifique o saldo e status.");
        } else{
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public int getAgencia() {return agencia;}

    public int getNumero() {return numero;}

    public double getSaldo() {return saldo;}

    public boolean getStatus() {return status;}

    public boolean setStatus(boolean status) {this.status = status;
        return status;
    }

    protected void imprimirInfosComuns(Cliente cliente, Banco banco) {
        System.out.printf("Nome do Banco: %s", banco.getNome());
        System.out.printf("\nNome do Cliente: %s%n", cliente.getNome());
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
