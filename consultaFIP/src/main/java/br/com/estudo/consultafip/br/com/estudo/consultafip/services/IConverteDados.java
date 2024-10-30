package br.com.estudo.consultafip.br.com.estudo.consultafip.services;

import java.util.List;

public interface IConverteDados {
    <T> T obterDados (String json, Class<T> classe);
    <T> List<T> obterlista(String json, Class<T> classe);
}
