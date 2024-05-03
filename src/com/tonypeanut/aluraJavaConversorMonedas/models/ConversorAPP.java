package com.tonypeanut.aluraJavaConversorMonedas.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorAPP {

    private boolean activarModoAvanzado = false; // Define si el modo avanzado esta activado o no.
    List<Conversion> listaConversiones = new ArrayList<>(); // Lo empleamos para almacenar un historial de conversiones.

    private boolean isActivarModoAvanzado() {
        return activarModoAvanzado;
    }

    private void setActivarModoAvanzado(boolean activarModoAvanzado) {
        this.activarModoAvanzado = activarModoAvanzado;
    }

    // Muestra el menú normal de la aplicación.
    private void showMenu(){
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

    // Muestra el menú avanzado de la aplicación.
    private void showMenuAvanzado(){
        System.out.println("""
                *******************************************************
                Sea bienvenido/a al modo avanzado del Conversor de Moneda =]
                
                1) Iniciar conversión
                9) Ingresa al modo normal
                0) Salir
                
                Elija una opción válida:
                *******************************************************
                """);
    }

    // Recibe y valida una opción ingresada por teclado.
    private String recibirOpcion(){
        Scanner teclado = new Scanner(System.in);

        while(true) {
            String opcion = teclado.next();
            try{
                if (Integer.valueOf(opcion)>=0 && Integer.valueOf(opcion) <= 9){
                    return opcion;
                } else {
                    System.out.println("Opción ingresada no válida. Vuelve a ingresar una opción.");
                }
            } catch (NumberFormatException e){
                System.out.println("Opción ingresada no válida. Vuelve a ingresar una opción.");
            }
        }
    }

    // Recibe y valida una opción del modo avanzado ingresada por teclado.
    private String recibirOpcionAvanzada(){
        Scanner teclado = new Scanner(System.in);

        while(true) {
            String opcion = teclado.next();
            try{
                int valor = Integer.valueOf(opcion);

                if (valor == 1 || valor == 9 || valor == 0){
                    return opcion;
                } else {
                    System.out.println("Opción ingresada no válida. Vuelve a ingresar una opción.");
                }
            } catch (NumberFormatException e){
                System.out.println("Opción ingresada no válida. Vuelve a ingresar una opción.");
            }
        }
    }

    // Recibe y valida un dato double ingresado por teclado.
    private double recibirDouble(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el monto a convertir: ");
        while(true){
            try{
                return Double.valueOf(teclado.next()) ;
            } catch (NumberFormatException e){
                System.out.println("El dato ingresado no es un número válido. Intente nuevamente.");
            }
        }
    }

    // Recibe un valor ingresado por teclado, lo valida y si es correcto devuelve el código correspondiente de moneda.
    private String recibirCodigoMoneda(){
        Scanner teclado = new Scanner(System.in);
        String input;

        System.out.println("""
                1)  ARS - Peso argentino
                2)  BOB - Boliviano
                3)  BRL - Real brasileño
                4)  BZD - Dólar beliceño
                5)  CAD - Dólar canadiense
                6)  CLP - Peso chileno
                7)  COP - Peso colombiano
                8)  CUP - Peso cubano
                9)  DOP - Peso dominicano
                10) EUR - Euro
                11) GTQ - Quetzal
                12) MXN - Peso mexicano
                13) NIO - Córdoba
                14) PAB - Balboa
                15) PEN - Sol peruano
                16) USD - Dolar estadounidense
                """);

        while (true){
            input = teclado.next();
            try{
                if (Integer.valueOf(input)>= 1 && Integer.valueOf(input)<= 16){
                    break;
                } else {
                    System.out.println("El dato ingresado no es válido. Intentelo nuevamente");
                }
            } catch (Exception e){
                System.out.println("El dato ingresado no es válido. Intentelo nuevamente");
            }
        }

        return switch (input) {
            case "1" -> "ARS";
            case "2" -> "BOB";
            case "3" -> "BRL";
            case "4" -> "BZD";
            case "5" -> "CAD";
            case "6" -> "CLP";
            case "7" -> "COP";
            case "8" -> "CUP";
            case "9" -> "DOP";
            case "10" -> "EUR";
            case "11" -> "GTQ";
            case "12" -> "MXN";
            case "13" -> "NIO";
            case "14" -> "PAB";
            case "15" -> "PEN";
            case "16" -> "USD";
            default -> "";
        };

    }

    // Devuelve el código de la moneda de acuerdo a la opción seleccionada en modo normal.
    private String recibirBaseCode(String opcion){
        switch (opcion){
            case "1": return "USD";
            case "2": return "ARS";
            case "3": return "USD";
            case "4": return "BRL";
            case "5": return "USD";
            case "6": return "COP";
            case "7": return "USD";
            case "8": return "MXN";
            default: return "";
        }
    }

    // Devuelve el código de la moneda de acuerdo a la opción seleccionada en modo normal.
    private String recibirTargetCode(String opcion){
        switch (opcion){
            case "1": return "ARS";
            case "2": return "USD";
            case "3": return "BRL";
            case "4": return "USD";
            case "5": return "COP";
            case "6": return "USD";
            case "7": return "MXN";
            case "8": return "USD";
            default: return "";
        }
    }

    // Secuencia de ejecución del modo normal de la aplicación.
    private void modoNormal() {
        while (true){
            showMenu(); // Mostrar el menú de opciones
            String opcion = recibirOpcion(); // Recibimos una opción válida

            if (opcion.equals("0")){
                break;
            } else if (opcion.equals("9")) {
                setActivarModoAvanzado(true);
                break;
            }

            String baseCode = recibirBaseCode(opcion);
            String targetCode = recibirTargetCode(opcion);
            double montoConvertir = recibirDouble();

            try {
                Conversion conversion = new Conversion(baseCode, targetCode, montoConvertir);
                listaConversiones.add(conversion);
            } catch (Exception e){
                System.out.println("Ocurrió un error con la conversión. Intentalo nuevamente.");
            }
        }

        if ( isActivarModoAvanzado() ){
            modoAvanzado();
        }

    }

    // Secuencia de ejecución del modo avanzado de la aplicación.
    private void modoAvanzado() {
        while (true) {
            showMenuAvanzado();

            String opcion = recibirOpcionAvanzada(); // Recibimos una opción válida
            if (opcion.equals("0")) {
                break;
            } else if (opcion.equals("9")) {
                setActivarModoAvanzado(false);
                break;
            }

            System.out.println("Ingrese la opción que indique el código de la moneda que desea convertir:");
            String baseCode = recibirCodigoMoneda();

            System.out.println("Ingrese el monto que desea convertir: ");
            double montoConvertir = recibirDouble();

            System.out.println("Ingrese la opción que indique el código de la moneda objetivo:");
            String targetCode = recibirCodigoMoneda();

            try {
                Conversion conversion = new Conversion(baseCode, targetCode, montoConvertir);
                listaConversiones.add(conversion);
            } catch (Exception e){
                System.out.println("Ocurrió un error con la conversión. Intentalo nuevamente.");
            }
        }
        if (!isActivarModoAvanzado()){
            modoNormal();
        }
    }

    public void start() {

        modoNormal(); // Inicializamos en modo normal

        // Al finalizar se genera una tabla con el historial de conversiones de la sesión.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.printf("------------------------------------------------------------------------------------------%n");
        System.out.printf("                          Historial de Conversiones en esta sesión                 %n");
        System.out.printf("------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-20s | %-45s | %-15s |%n", "FECHA Y HORA", "CONVERSIÓN", "ESTADO CONSULTA");
        System.out.printf("------------------------------------------------------------------------------------------%n");
        listaConversiones.forEach(System.out::print);
        System.out.printf("------------------------------------------------------------------------------------------%n");
    }
}

