package br.com.estudo.consultafip.br.com.estudo.consultafip.record;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Valor(
        @JsonAlias("Valor") String valor,
        @JsonAlias("Marca") String marca,
        @JsonAlias("Model") String modelo,
        @JsonAlias("AnoModelo") String anoModelo
) {

}
