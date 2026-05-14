package com.techlab.articulo.utils;

/**
 * CONSIGNA DE ESTA CLASE
 * ------------------------------------------------------------
 * Esta clase debe concentrar validaciones reutilizables.
 *
 * RECOMENDACIÓN
 * ------------------------------------------------------------
 * Hacerla utilitaria:
 * - clase final
 * - constructor privado
 * - métodos static
 *
 * VALIDACIONES SUGERIDAS
 * ------------------------------------------------------------
 * - validarTextoNoVacio(String texto)
 * - validarLongitudMaxima(String texto, int maximo)
 * - validarNoNegativo(int valor)
 * - validarNoNegativo(double valor)
 *
 * BENEFICIO
 * ------------------------------------------------------------
 * Evita repetir la misma lógica de validación en distintas partes
 * del sistema.
 */
public final class Validaciones {

    private Validaciones() {
    }

    public static void validarTextoNoVacio(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío.");
        }
    }

    public static void validarLongitudMaxima(String texto, int maximo) {
        if (texto != null && texto.length() > maximo) {
            throw new IllegalArgumentException("El texto no puede tener más de " + maximo + " caracteres.");
        }
    }

    public static void validarNoNegativo(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo.");
        }
    }

    public static void validarNoNegativo(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo.");
        }
    }
}
