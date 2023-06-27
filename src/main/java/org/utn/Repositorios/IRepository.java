package org.utn.Repositorios;
import java.util.List;

/**
 * Esta interfaz generica se encarga de definir los metodos que deben implementar las clases que la implementen
 * ABML
 * @author  Eliana Rojas
 * @author Milagros Pecar
 * @author Agostina Cardinali
 * @author Matias Siano
 */

public interface IRepository<T> {

    List<T> listar();

    boolean buscar(T objeto);
    void modificar(T objeto);
    void eliminar(T objeto);
    void agregar(T... objeto);

    void cargar();
    void guardar();

}
