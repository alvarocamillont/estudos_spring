package br.com.listacompras.model;

public class Cartao {
    private double limite;
    private double saldo;

    public Cartao(double limite){
        this.limite = limite;
        this.saldo = 0;
    }

    public boolean avaliaSaldo(double valor) {
        return this.limite - (this.saldo + valor) >= 0;
    }

    public void debita(double valor) {
        this.saldo += valor;
    }

    @Override
    public String toString() {
        return "Saldo do cartão:" + this.saldo;
    }
}
