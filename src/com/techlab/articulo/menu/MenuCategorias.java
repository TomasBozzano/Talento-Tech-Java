package com.techlab.articulo.menu;

/**
 * CONSIGNA DE ESTA CLASE
 * ------------------------------------------------------------
 * Esta clase debe heredar de Menu y encargarse del CRUD de categorías.
 *
 * Debe trabajar con:
 * - Repositorio<Categoria>
 * - Repositorio<Articulo>
 *
 * ¿Por qué necesita también artículos?
 * Porque antes de eliminar una categoría debe verificarse si está
 * siendo utilizada por algún artículo.
 *
 * FUNCIONALIDADES ESPERADAS
 * ------------------------------------------------------------
 * 1) Ingresar categoría
 * 2) Listar categorías
 * 3) Consultar una categoría por código
 * 4) Modificar una categoría
 * 5) Eliminar una categoría
 * 0) Volver
 *
 * VALIDACIONES
 * ------------------------------------------------------------
 * - nombre no vacío
 * - descripción no vacía
 * - no permitir categorías repetidas por nombre
 *
 * REGLA DE NEGOCIO IMPORTANTE
 * ------------------------------------------------------------
 * No se puede eliminar una categoría si existe al menos un artículo
 * asociado a ella.
 *
 * SUGERENCIA DE MÉTODOS
 * ------------------------------------------------------------
 * - ingresarCategoria()
 * - listarCategorias()
 * - consultarCategoria()
 * - modificarCategoria()
 * - eliminarCategoria()
 * - categoriaTieneArticulosAsociados(...)
 */
public class MenuCategorias extends Menu {

    public MenuCategorias(java.util.Scanner scanner) {
        super(scanner);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ CATEGORÍAS ---");
        System.out.println("1 - Ingresar categoría");
        System.out.println("2 - Listar categorías");
        System.out.println("3 - Consultar categoría");
        System.out.println("4 - Modificar categoría");
        System.out.println("5 - Eliminar categoría");
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
                    ingresarCategoria();
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 3:
                    consultarCategoria();
                    break;
                case 4:
                    modificarCategoria();
                    break;
                case 5:
                    eliminarCategoria();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private void ingresarCategoria() {
        
    }

    private void listarCategorias() {
    }

    private void consultarCategoria() {
    }

    private void modificarCategoria() {
    }

    private void eliminarCategoria() {
    }
}
