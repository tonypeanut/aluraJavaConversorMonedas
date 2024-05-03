package com.tonypeanut.aluraJavaConversorMonedas.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    private String estadoConversion;
    private String baseCode;
    private String targetCode;
    private Double montoConvertir;
    private Double montoResultado;
    private String formattedDateTime;


    // Constructor de la clase
    public Conversion(String baseCode, String targetCode, Double montoConvertir) throws IOException, InterruptedException {
        Gson gson = new Gson();
        String json = getConversionAPI(baseCode, targetCode, montoConvertir); // Obtenemos respuesta de la api
        ConversionAPI respuestaConversion = gson.fromJson(json, ConversionAPI.class); // instaciamos una clase record para acceder a la respuesta.

        LocalDateTime now = LocalDateTime.now(); // obtenemos la fecha y hora actual.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Establecemos el formato de la fecha y hora.

        // Almacenamos en los atributos la información del record de la respuesta de la API y la fecha y hora actuales.
        this.estadoConversion = respuestaConversion.result();
        this.baseCode = respuestaConversion.base_code();
        this.targetCode = respuestaConversion.target_code();
        this.montoConvertir = montoConvertir;
        this.montoResultado = respuestaConversion.conversion_result();
        this.formattedDateTime = now.format(formatter);

        System.out.println(String.format("%.3f %s = %.3f %s", this.montoConvertir, this.baseCode, this.montoResultado, this.targetCode));

        Thread.sleep(1000); // breve pausa para permitir al usuario leer el resultado.
    }

    // Comunicación con la API, devuelve el body de la respuesta.
    private String getConversionAPI(String baseCode, String targetCode, double montoConvertir) throws IOException, InterruptedException {
        String APIKEY = "ec6b857fa2f71b06f9d8f49a";
        String direccion = "https://v6.exchangerate-api.com/v6/"+APIKEY+"/pair/"+baseCode+"/"+targetCode+"/"+montoConvertir;
        System.out.println("Conversión en proceso....");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    @Override
    public String toString() {
        String columna1 = formattedDateTime;
        String columna2 = montoConvertir + " " + baseCode + " = " + montoResultado + " " + targetCode;
        String columna3 = estadoConversion;
        return String.format("| %-20s | %-45s | %-15s |%n", columna1, columna2, columna3);
    }
}

