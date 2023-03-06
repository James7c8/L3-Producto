package l3.tienda.model.bootstrap;

import l3.tienda.model.entity.Producto;
import l3.tienda.model.service.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// CommandLineRunner es una interfaz que proporciona el único método `run(String... args)`.
public class Inicializador implements CommandLineRunner {

    // Permite que la clase Inicializador puede acceder y utilizar los métodos de ProductoService.
    // `final` significa que el variable productoService solo puede asignarse una vez, lo que ocurre en el constructor.
    private final ProductoService productoService;

    public Inicializador(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Debido a que se crean los registros acá y no en la DB (para la práctica), hay que eliminarlo toddo al
        // principio para evitar repetirlos despues de cada ejecución.
        productoService.eliminarTodo();

        // Se crean unos productos para tener algo en la BD.
        Producto producto1 = new Producto("manzana", 1000, 20, true, "frutas y verduras");
        productoService.agregarProducto(producto1);

        // En comparación con producto1 este se implementa en una sola linea para ahorrar espacio.
        productoService.agregarProducto(new Producto("banano", 500, 70, true, "frutas y verduras"));
        productoService.agregarProducto(new Producto("colombiana", 2500, 10, true, "bebidas"));
        productoService.agregarProducto(new Producto("coca-cola", 3500, 12, true, "bebidas"));
        productoService.agregarProducto(new Producto("dandelion and burdock", 4500, 0, false, "bebidas"));

//        productoService.buscarProductosTodos().forEach(producto -> {
//            System.out.println(producto.toString());
//        });

        List<Producto> listaProductos = productoService.buscarProductosTodos();
        productoService.mostrarTodosProductos(listaProductos);
    }
}
