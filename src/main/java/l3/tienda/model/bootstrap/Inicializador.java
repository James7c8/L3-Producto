package l3.tienda.model.bootstrap;

import l3.tienda.model.entity.Producto;
import l3.tienda.model.DAO.ProductoDAO;
import l3.tienda.model.service.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
// CommandLineRunner es una interfaz que proporciona el único método `run(String... args)`.
public class Inicializador implements CommandLineRunner {

    private final ProductoService productoService;

    public Inicializador(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Se crean unos productos para tener algo en la BD.
        Producto producto1 = new Producto("manzana", 1000, 20, true, "frutas y verduras");
        productoService.agregarProducto(producto1);

        // En comparación con producto1 este se implementa en una sola linea para ahorrar espacio.
        productoService.agregarProducto(new Producto("banano", 500, 70, true, "frutas y verduras"));

        productoService.buscarProductosTodos().forEach(producto -> {
            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
        });
    }
}
