package br.com.listacompras.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lista {

    private List<Item> lista;

    public Lista() {
        this.lista = new ArrayList<>();
    }

    public void adicionaItem(String descricao, double valor) {
        this.lista.add(new Item(descricao,valor));
    }

    public void imprimeLista() {
        this.lista.sort(Comparator.naturalOrder());
        System.out.println("COMPRAS REALIZADAS:");
        this.lista.forEach(System.out::println);
    }
}
