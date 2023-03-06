package l3.tienda.model.DAO;

import l3.tienda.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/*  Recuerda: una interfaz es como un plano o un contrato que define un conjunto de reglas que una clase debe seguir.
    A diferencia de una clase, una interfaz no puede ser instanciada por sí misma. Se está implementada por clases.

    La interfaz `JpaRepository` proporciona muchos métodos comunes para realizar operaciones CRUD sobre clases de
    entidades. Recibe dos parámetros: Producto, que es la clase de entidad, y Integer, que es el tipo de clave primaria
    de la entidad.
*/
public interface ProductoDAO extends JpaRepository<Producto, Integer> {

}
