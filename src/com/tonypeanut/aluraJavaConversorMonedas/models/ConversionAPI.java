package com.tonypeanut.aluraJavaConversorMonedas.models;

public record ConversionAPI(
        String result,
        String base_code,
        String target_code,
        double conversion_result) {
}
