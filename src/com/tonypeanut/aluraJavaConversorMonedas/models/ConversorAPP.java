package com.tonypeanut.aluraJavaConversorMonedas.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorAPP {
    boolean modoAvanzado;
    List<Conversion> listaConversiones = new ArrayList<>();

    public static void setModoAvanzado(boolean modoAvanzado) {
        this.modoAvanzado = modoAvanzado;
    }

    public static void showMenu(){
        System.out.println("""
                *******************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Dólar =>> Peso Mexicano
                8) Peso Mexicano =>> Dólar
                9) Ingresa al modo avanzado
                0) Salir
                Elija una opción válida:
                 *******************************************************
                """);
    }

    public static void choosedOption(String selectedOption, double montoConvertir){
        String baseCode;
        String targetCode;

        switch (selectedOption){
            case "1":
                baseCode = "USD"; targetCode= "ARS";
                break;
            case "2":
                baseCode = "ARS"; targetCode= "USD";
                break;
            case "3":
                baseCode = "USD"; targetCode= "BRL";
                break;
            case "4":
                baseCode = "BRL"; targetCode= "USD";
                break;
            case "5":
                baseCode = "USD"; targetCode= "COP";
                break;
            case "6":
                baseCode = "COP"; targetCode= "USD";
                break;
            case "7":
                baseCode = "USD"; targetCode= "MXN";
                break;
            case "8":
                baseCode = "MXN"; targetCode= "USD";
                break;
            case "9":
                setModoAvanzado(true);
                break;
            default:
                System.out.println("Opción no válida, intenta nuevamente.");
                break;
        }

    }
    public void start(){
        Scanner teclado = new Scanner(System.in);
        double montoConvertir;

        while (true){

            showMenu(); // Mostrar el menú de opciones

            // Recibimos la opción del usuario, si es "0", finalizamos el programa.
            String opcion = teclado.next();
            if (opcion.equals("0")){
                break;
            }

            // Recibimos el núero, en caso de que no ingrese un número se solicita nuevamente el monto a convertir, hasta que sea válido.
            while(true){
                System.out.println("Ingrese el monto a convertir: ");
                String montoConvertirString = teclado.next();
                try{
                    montoConvertir = Double.valueOf(montoConvertirString);
                    break;
                } catch (NumberFormatException e){
                    System.out.println("El dato ingresado no es válido, intente nuevamente, verifique que sea númerico.");
                }
            }

            choosedOption(opcion, montoConvertir); // Ejecutar la opción elegida
        }
    }
}
