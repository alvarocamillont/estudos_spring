package br.com.estudo.consultafip.br.com.estudo.consultafip.record;

public record Modelo(
        String codigo,
        String nome
) {
    public String toString() {
        return "Cód: " + codigo + " Descrição: " + nome;
    }
}
