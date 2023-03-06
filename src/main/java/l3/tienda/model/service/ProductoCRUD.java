package l3.tienda.model.service;

import l3.tienda.model.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoCRUD {

    private final ProductoService productoService;

    public ProductoCRUD(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void mostrarTodosProductos(List<Producto> productos) {
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("id   | nombre                         |       precio |exist.|  disponible   | categoria                   ");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for(Producto p : productos)
            System.out.println(p.toString());
    }
}
