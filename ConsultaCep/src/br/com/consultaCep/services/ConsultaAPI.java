package br.com.consultaCep.services;

import br.com.consultaCep.model.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    private final HttpClient client = HttpClient.newHttpClient();

    public Endereco consultaCep(String cep) throws InterruptedException, IOException {
        var url = String.format("https://viacep.com.br/ws/%s/json/",cep);
        var gson = new Gson();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(),Endereco.class);

    }

    public void salvaJson(Endereco endereco) throws IOException {
        var gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();
    }
}
