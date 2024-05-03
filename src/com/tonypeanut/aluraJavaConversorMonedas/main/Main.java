package com.tonypeanut.aluraJavaConversorMonedas.main;

import com.tonypeanut.aluraJavaConversorMonedas.models.ConversorAPP;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Instanciamos la app conversor de moneda y la inicializamos con start();
        ConversorAPP app = new ConversorAPP();
        app.start();
        System.out.println("Programa finalizado con éxito.");

    }
}