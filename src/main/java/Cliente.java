public class Cliente {

    private int saldo;
    private boolean isBomPagador;


    public Cliente(int saldo, boolean isBomPagador){
        this.saldo = saldo;
        this.isBomPagador = isBomPagador;
    }

    public boolean PodePegarEmprestado(boolean isConcessao){
        return saldo > 1000 || isBomPagador || isConcessao;
    }

}
