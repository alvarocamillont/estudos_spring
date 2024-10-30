package br.com.estudo.consultafip.br.com.estudo.consultafip.record;

import java.util.List;

public record Modelos(
        List<Ano> anos,
        List<Modelo> modelos
) {
}
