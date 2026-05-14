package com.techlab.articulo.repository;

import com.techlab.articulo.interfaces.Identificable;
import java.util.ArrayList;

/**
 * CONSIGNA DE ESTA CLASE
 * ------------------------------------------------------------
 * Esta clase debe ser GENÉRICA.
 *
 * Debe modelarse así:
 * Repositorio<T extends Identificable>
 *
 * ¿Qué significa eso?
 * Que podrá trabajar con distintos tipos de objetos, siempre que esos
 * objetos tengan código.
 *
 * EJEMPLOS DE USO ESPERADOS
 * ------------------------------------------------------------
 * - Repositorio<Categoria>
 * - Repositorio<Articulo>
 *
 * ESTA CLASE DEBE GUARDAR LOS DATOS EN MEMORIA
 * ------------------------------------------------------------
 * Usando:
 * - ArrayList<T>
 *
 * MÉTODOS MÍNIMOS ESPERADOS
 * ------------------------------------------------------------
 * - agregar(T objeto)
 * - listar()
 * - buscarPorCodigo(int codigo)
 * - eliminar(T objeto)
 * - estaVacio()
 *
 * OBJETIVO DIDÁCTICO
 * ------------------------------------------------------------
 * Esta clase prepara el terreno para entender luego estructuras como:
 * JpaRepository<T, ID> en Spring Boot.
 */
public class Repositorio<T extends Identificable> {

    private ArrayList<T> lista = new ArrayList<>();

    public boolean agregar(T objeto) {
        return lista.add(objeto);
    }

    public ArrayList<T> listar() {
        return lista;
    }

    public T buscarPorCodigo(int codigo) {
        for (T objeto : lista) {
            if (objeto.getCodigo() == codigo) {
                return objeto;
            }
        }
        return null; // Retorna null si no se encuentra el objeto.
    }

    public boolean eliminar(T objeto) {
        return lista.remove(objeto);
    }

    public boolean estaVacio() {
        return lista.isEmpty();
    }
}
