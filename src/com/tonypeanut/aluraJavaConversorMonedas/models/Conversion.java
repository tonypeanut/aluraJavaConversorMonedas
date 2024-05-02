package com.tonypeanut.aluraJavaConversorMonedas.models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversion {
    private String baseCode;
    private String targetCode;
    private Double montoConvertir;
    private Double montoResultado;

    public Conversion(String baseCode, String targetCode, Double montoConvertir) throws IOException, InterruptedException {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.montoConvertir = montoConvertir;

        getConversionAPI();
    }

    private void getConversionAPI() throws IOException, InterruptedException {
        String APIKEY = "ec6b857fa2f71b06f9d8f49a";
        String direccion = "https://v6.exchangerate-api.com/v6/"+APIKEY+"/pair/"+baseCode+"/"+targetCode+"/"+montoConvertir;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        System.out.println(json);
    }
}

