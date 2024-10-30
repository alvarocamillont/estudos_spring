package br.com.estudo.consultafip.br.com.estudo.consultafip.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(
        List<Modelo> modelos
) {
}
