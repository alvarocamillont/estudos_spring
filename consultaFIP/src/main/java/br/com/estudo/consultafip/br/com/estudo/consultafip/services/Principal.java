package br.com.estudo.consultafip.br.com.estudo.consultafip.services;

import br.com.estudo.consultafip.br.com.estudo.consultafip.record.Marca;
import br.com.estudo.consultafip.enums.Categorias;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private Scanner input = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsultaAPI consultaAPI = new ConsultaAPI();
    private ConverteDados conversor = new ConverteDados();

    public void mostraMenuPrincipal() {
        System.out.println("Seja bem vindo!");
        var categoria = this.selecionaCategoria();
        var marca = this.selectionaMarca(categoria);

        System.out.println(marca);

    }

    private String selectionaMarca(Categorias categoria) {

        var url = switch (categoria){
            case CARRO -> URL_BASE + "carros/marcas";
            case CAMINHAO -> URL_BASE + "caminhoes/marcas";
            case MOTO -> URL_BASE + "motos/marcas";
        };
        var json = this.consultaAPI.obterDados(url);
        var marcas = this.conversor.obterlista(json, Marca.class);

        marcas.stream()
                .sorted(Comparator.comparing(Marca::codigo))
                .forEach(System.out::println);

        System.out.println("Selecione a categoria:");

        return this.input.next();
    }

    private Categorias selecionaCategoria() {
        System.out.println("Selecione a categoria:");
        System.out.println("""
                1 - Carro
                2 - Moto
                3 - Caminhão
                """);
        var categoria = input.nextInt();

        switch (categoria){
            case 1 -> {return Categorias.CARRO;}
            case 2 -> {return Categorias.MOTO;}
            case 3 -> {return Categorias.CAMINHAO;}
            default -> throw new IllegalStateException("Unexpected value: " + categoria);
        }

    }
}
