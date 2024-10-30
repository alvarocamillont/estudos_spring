package br.com.estudo.consultafip.br.com.estudo.consultafip.services;

import br.com.estudo.consultafip.br.com.estudo.consultafip.record.*;
import br.com.estudo.consultafip.enums.Categorias;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner input = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private String urlMarca;
    private String urlModelo;
    private ConsultaAPI consultaAPI = new ConsultaAPI();
    private ConverteDados conversor = new ConverteDados();

    public void mostraMenuPrincipal() {
        System.out.println("Seja bem vindo!");
        var categoria = this.selecionaCategoria();
        var marca = this.selectionaMarca(categoria);
        var modelo = this.selectionaModelo(marca);
        var listaValores = this.mostraModelo(modelo);



    }

    private List<Valor> mostraModelo(String modelo) {
        var json = this.consultaAPI.obterDados(this.urlModelo+ "/" + modelo + "/anos");
        var listaAnos = this.conversor.obterlista(json, Ano.class);
        var listaVeiculo = new ArrayList<Valor>();

        listaAnos.stream().forEach(ano->{
            var veiculo = this.getValorVeiculo(ano.codigo(),modelo);
            listaVeiculo.add(veiculo);
        });

        listaVeiculo.forEach(System.out::println);

        return listaVeiculo;
    }

    private Valor getValorVeiculo(String ano, String modelo) {
        var url = this.urlModelo+ "/" + modelo + "/anos/" + ano;
        var json = this.consultaAPI.obterDados(url);
        return this.conversor.obterDados(json,Valor.class);
    }

    private String selectionaModelo(String marca) {
        this.urlModelo = this.urlMarca + "/" + marca + "/modelos";
        var json = this.consultaAPI.obterDados(this.urlModelo);
        var modelos = this.conversor.obterDados(json, Modelos.class);
        modelos.modelos().stream()
                .sorted(Comparator.comparing(Modelo::codigo))
                .forEach(System.out::println);

        System.out.println("Selecione o modelo:");

        return this.input.next();
    }

    private String selectionaMarca(Categorias categoria) {

        this.urlMarca = switch (categoria){
            case CARRO -> URL_BASE + "carros/marcas";
            case CAMINHAO -> URL_BASE + "caminhoes/marcas";
            case MOTO -> URL_BASE + "motos/marcas";
        };
        var json = this.consultaAPI.obterDados(this.urlMarca);
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
