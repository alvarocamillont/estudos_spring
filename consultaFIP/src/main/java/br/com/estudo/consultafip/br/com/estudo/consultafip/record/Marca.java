package br.com.estudo.consultafip.br.com.estudo.consultafip.record;

public record Marca(
        String codigo,
        String nome
) {
    @Override
    public String toString() {
        return "Cód: " + codigo + " Descrição: " + nome;
    }
}
