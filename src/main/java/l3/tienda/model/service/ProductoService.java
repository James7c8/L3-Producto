package l3.tienda.model.service;

import java.util.List;

import l3.tienda.model.DAO.ProductoDAO;
import l3.tienda.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Un service proporciona una funcionalidad o capacidad específica a otras partes de un programa. Los servicios están
// diseñados a ser 'loosely coupled' para que puedan sustituirse o modificarse fácilmente sin afectar a otras partes del
// sistema.
@Service
public class ProductoService {

    // Usar Autowired significa que no tenemos que crear manualmente una nueva instancia de la clase DAO.
    // En su lugar, Spring creará y gestionará la instancia DAO por nosotros.
    @Autowired
    private ProductoDAO productoDAO;

    // @Transactional gestiona automáticamente las transacciones de la base de datos. Se aplica en métodos o clases que
    // implican operaciones de base de datos, como leer de, escribir en o borrar datos de una base de datos.
    //
    // Cuando se ejecuta un método con @Transactional, se inicia automáticamente una transacción antes de que el método
    // se ejecute y se confirma después de que el método se complete con éxito. Si el método falla, la transacción es
    // rolled back, lo que significa que cualquier cambio realizado en la base de datos es revertido.
    // Esto ayuda a garantizar que la base de datos se mantiene consistente incluso si varios usuarios acceden a ella
    // simultáneamente.
    @Transactional(readOnly = true)  // las consultas llevan readOnly = true
    public List<Producto> buscarProductosTodos() {
        return productoDAO.findAll();
    }

    @Transactional(readOnly = true)
    public Producto buscarProductoPorId(Integer id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Transactional
    public void agregarProducto(Producto producto) {
        productoDAO.save(producto);
    }

    @Transactional
    public void eliminarProducto(Integer id) {
        productoDAO.deleteById(id);
    }

    @Transactional
    public void eliminarTodo() {productoDAO.deleteAll();}
}
