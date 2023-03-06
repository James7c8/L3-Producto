package l3.tienda.model.bootstrap;

import l3.tienda.model.entity.Producto;
import l3.tienda.model.DAO.ProductoDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
// CommandLineRunner es una interfaz que proporciona el único método `run(String... args)`.
public class Inicializador implements CommandLineRunner {

    private final ProductoDAO productoDAO;

    public Inicializador(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }


    @Override
    public void run(String... args) throws Exception {
        Producto producto1 = new Producto("manzana", 1000, 20, true, "frutas y verduras");

    }
}
