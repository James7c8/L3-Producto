package l3.tienda.model.service;

import l3.tienda.model.DAO.ProductoDAO;
import l3.tienda.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Un service proporciona una funcionalidad o capacidad específica a otras partes de un programa. Los servicios están
// diseñados a ser 'loosely coupled' para que puedan sustituirse o modificarse fácilmente sin afectar a otras partes del
// sistema.
@Service
public class ProductoService {

    // Usar Autowired significa que no tenemos que crear manualmente una nueva instancia de la clase DAO.
    // En su lugar, Spring creará y gestionará la instancia DAO por nosotros.
    @Autowired
    private ProductoDAO productoDAO;

    @Transactional(readOnly = true)  // las consultas llevan readOnly = true
    public List<Producto> buscarAsignaturasTodas() {
        return productoDAO.findAll();
    }

    @Transactional(readOnly = true)
    public Producto buscarAsignaturaPorId(Integer id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Transactional
    public void agregarAsignatura(Producto producto) {
        productoDAO.save(producto);
    }

    @Transactional
    public void eliminarAsignatura(Integer id) {
        productoDAO.deleteById(id);
    }
}
