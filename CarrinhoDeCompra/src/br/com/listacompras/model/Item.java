package br.com.listacompras.model;

public class Item implements Comparable<Item>{
    private String descricao;
    private double valor;

    public Item(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public int compareTo(Item item) {
        return (int) (this.valor - item.valor);
    }

    @Override
    public String toString() {
        return descricao + "-" + valor;
    }
}
