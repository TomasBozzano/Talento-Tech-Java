package com.techlab.articulo.menu;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.model.ArticuloAlimenticio;
import com.techlab.articulo.model.ArticuloElectronico;
import com.techlab.articulo.model.Categoria;
import com.techlab.articulo.repository.Repositorio;
import com.techlab.articulo.utils.Secuencias;
import java.util.Scanner;


/**
 * CONSIGNA DE ESTA CLASE
 * ------------------------------------------------------------
 * Esta clase debe heredar de Menu y encargarse del CRUD de artículos.
 *
 * Debe trabajar con:
 * - Repositorio<Articulo>
 * - Repositorio<Categoria>
 *
 * ¿Por qué necesita también categorías?
 * Porque un artículo debe asociarse a una categoría ya existente.
 *
 * FUNCIONALIDADES ESPERADAS
 * ------------------------------------------------------------
 * 1) Ingresar artículo
 * 2) Listar artículos
 * 3) Consultar un artículo por código
 * 4) Modificar un artículo
 * 5) Eliminar un artículo
 * 0) Volver
 *
 * REQUISITOS IMPORTANTES
 * ------------------------------------------------------------
 * - Antes de crear un artículo, debe verificarse que existan categorías.
 * - Debe preguntarse qué tipo de artículo se quiere crear:
 *   - electrónico
 *   - alimenticio
 * - Debe pedirse:
 *   - nombre
 *   - precio
 *   - categoría por código
 * - Si es electrónico:
 *   - garantía en meses
 * - Si es alimenticio:
 *   - días para vencimiento
 *
 * VALIDACIONES
 * ------------------------------------------------------------
 * - nombre no vacío
 * - precio no negativo
 * - categoría existente
 * - garantía no negativa
 * - días para vencimiento no negativos
 *
 * SUGERENCIA DE MÉTODOS
 * ------------------------------------------------------------
 * - ingresarArticulo()
 * - listarArticulos()
 * - consultarArticulo()
 * - modificarArticulo()
 * - eliminarArticulo()
 * - pedirCategoriaExistente()
 * - pedirNombreArticulo()
 * - pedirPrecioArticulo()
 * - pedirGarantia()
 * - pedirDiasParaVencimiento()
 */
public class MenuArticulos extends Menu {

    private final Repositorio<Articulo> repositorioArticulos;
    private final Repositorio<Categoria> repositorioCategorias;

     public MenuArticulos(
            Scanner scanner,
            Repositorio<Articulo> repositorioArticulos,
            Repositorio<Categoria> repositorioCategorias
    ) {
        // Llamamos al constructor de la clase padre.
        super(scanner);

        // Guardamos las referencias recibidas.
        this.repositorioArticulos = repositorioArticulos;
        this.repositorioCategorias = repositorioCategorias;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ ARTÍCULOS ---");
        System.out.println("1 - Ingresar artículo");
        System.out.println("2 - Listar artículos");
        System.out.println("3 - Consultar artículo");
        System.out.println("4 - Modificar artículo");
        System.out.println("5 - Eliminar artículo");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    ingresarArticulo();
                    break;
                case 2:
                    listarArticulos();
                    break;
                case 3:
                    consultarArticulo();
                    break;
                case 4:
                    modificarArticulo();
                    break;
                case 5:
                    eliminarArticulo();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private void ingresarArticulo() {
       if(repositorioArticulos.estaVacio()) {
           System.out.println("No se pueden ingresar artículos porque no hay categorías disponibles.");
           return;
       }

       System.out.println("\nAlta de artículo");
        System.out.println("1 - Artículo electrónico");
        System.out.println("2 - Artículo alimenticio");

        int tipo;
        do {
            tipo = leerEntero("Seleccione el tipo de artículo: ");
            if (tipo != 1 && tipo != 2) {
                System.out.println("Error: debe elegir 1 o 2.");
            }
        } while (tipo != 1 && tipo != 2);

        String nombre = pedirNombreArticulo();
        double precio = pedirPrecioArticulo();
        Categoria categoria = pedirCategoriaExistente();

        // Validamos duplicados lógicos.
        if (existeArticuloDuplicado(nombre, categoria, -1)) {
            System.out.println("\nError: ya existe un artículo con ese nombre dentro de esa categoría.");
            return;
        }

        // Generamos el código automático.
        int codigo = Secuencias.generarCodigoArticulo();

        Articulo nuevoArticulo;

        if (tipo == 1) {
            int garantiaMeses = pedirGarantia();

            // Creamos un artículo electrónico.
            nuevoArticulo = new ArticuloElectronico(codigo, nombre, precio, categoria, garantiaMeses);
        } else {
            int diasParaVencimiento = pedirDiasParaVencimiento();

            // Creamos un artículo alimenticio.
            nuevoArticulo = new ArticuloAlimenticio(codigo, nombre, precio, categoria, diasParaVencimiento);
        }

        boolean agregado = repositorioArticulos.agregar(nuevoArticulo);

        if (agregado) {
            System.out.println("\nArtículo ingresado correctamente.");
            System.out.println(nuevoArticulo);
        } else {
            System.out.println("\nError: no se pudo guardar el artículo.");
        }



    }

    private void listarArticulos() {
    }

    private void consultarArticulo() {
    }

    private void modificarArticulo() {
    }

    private void eliminarArticulo() {
    }

    private Categoria pedirCategoriaExistente() {
        Categoria categoria = null;
        do {
            int codigoCategoria = leerEntero("Ingrese el código de la categoría: ");
            categoria = repositorioCategorias.buscarPorCodigo(codigoCategoria);
            if (categoria == null) {
                System.out.println("Error: no existe una categoría con ese código. Intente nuevamente.");
            }
        } while (categoria == null);
        return categoria;
    }

    private String pedirNombreArticulo() {
        String nombre;
        do {
            nombre = leerTexto("Ingrese el nombre del artículo: ");
            if (nombre.trim().isEmpty()) {
                System.out.println("Error: el nombre no puede estar vacío. Intente nuevamente.");
            }
        } while (nombre.trim().isEmpty());
        return nombre;
    }

    private double pedirPrecioArticulo() {
        double precio;
        do {
            precio = leerDouble("Ingrese el precio del artículo: ");
            if (precio < 0) {
                System.out.println("Error: el precio no puede ser negativo. Intente nuevamente.");
            }
        } while (precio < 0);
        return precio;
    }

    private int pedirGarantia() {
        int garantia;
        do {
            garantia = leerEntero("Ingrese la garantía en meses: ");
            if (garantia < 0) {
                System.out.println("Error: la garantía no puede ser negativa. Intente nuevamente.");
            }
        } while (garantia < 0);
        return garantia;
    }

    private int pedirDiasParaVencimiento() {
        int dias;
        do {
            dias = leerEntero("Ingrese los días para vencimiento: ");
            if (dias < 0) {
                System.out.println("Error: los días para vencimiento no pueden ser negativos. Intente nuevamente.");
            }
        } while (dias < 0);
        return dias;
    }

    private boolean existeArticuloDuplicado(String nombre, Categoria categoria, int codigoExcluido) {
        for (Articulo articulo : repositorioArticulos.listar()) {
            if (articulo.getNombre().equalsIgnoreCase(nombre)
                    && articulo.getCategoria().getCodigo() == categoria.getCodigo()
                    && articulo.getCodigo() != codigoExcluido) {
                return true;
            }
        }
        return false;
    }


}
