package com.techlab.articulo.menu;

import java.util.Scanner;

/**
 * CONSIGNA DE ESTA CLASE
 * ------------------------------------------------------------
 * Esta debe ser la clase base de todos los menús.
 *
 * Objetivo:
 * centralizar la lógica común para no repetir código.
 *
 * Esta clase debe:
 * - guardar un Scanner compartido
 * - declarar el método mostrarMenu()
 * - declarar el método ejecutar()
 *
 * Además, podés agregar métodos protegidos reutilizables, por ejemplo:
 * - leerEntero(String mensaje)
 * - leerDouble(String mensaje)
 * - leerTexto(String mensaje)
 * - leerSiNo(String mensaje)
 *
 * IMPORTANTE:
 * Esta clase debe ser abstracta, porque no tiene sentido crear un
 * "menú genérico" instanciable. Solo debe servir como base para:
 * - MenuArticulos
 * - MenuCategorias
 */
public abstract class Menu {

    protected Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void mostrarMenu();


    public abstract void ejecutar();

    protected int leerEntero(String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        }
    }

    protected double leerDouble(String mensaje) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número decimal.");
            }
        }
    }

    protected String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    protected boolean leerSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) {
                return true;
            } else if (respuesta.equals("n")) {
                return false;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese 's' para sí o 'n' para no.");
            }
        }
    }
}
