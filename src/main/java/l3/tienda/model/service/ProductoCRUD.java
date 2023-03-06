package l3.tienda.model.service;

import l3.tienda.model.entity.Producto;
import l3.tienda.utils.Sc;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
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

    public void mostrarProducto(Producto producto) {
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("id   | nombre                         |       precio |exist.|  disponible   | categoria                   ");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(producto.toString());
    }

    public Producto modificarProducto(Producto producto) {
        int opcion = 0;
        do {
            try{
                mostrarProducto(producto);
                System.out.println("Digite el campo que quiere modificar");
                opcion = Sc.leerEntero("\n1 - Nombre\n2 - Precio\n3 - Existencia\n4 - Disponibilidad\n5 - Categoría\n6 - SALIR\n>");

                switch(opcion) {
                    case 1:
                        String nombre = Sc.leerTexto("Ingrese el nuevo nombre\n>");
                        producto.setNombre(nombre);
                        break;
                    case 2:
                        double precio = Sc.leerReal("Ingrese el nuevo precio\n>");
                        producto.setPrecio(precio);
                        break;
                    case 3:
                        int existencia = Sc.leerEntero("Ingrese la nueva existencia\n>");
                        producto.setExistencia(existencia);
                        break;
                    case 4:
                        int disponibilidad = Sc.leerEntero("Es el producto disponible?\n1 - SÍ\n2 - NO\n>");
                        boolean disponible = producto.isDisponible();

                        if (disponibilidad == 1) disponible = true;
                        else if (disponibilidad == 2) disponible = false;
                        else System.out.println("Opción no válida!");

                        break;
                    case 5:
                        String categoria = Sc.leerTexto("Ingrese la nueva categoría\n>");
                        producto.setCategoria(categoria);
                        break;
                    case 6:
                        System.out.println("PROGRAMA SALIDO CON ÉXITO");
                        break;
                    default:
                        System.out.println("Opción no válida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite solo un número entre 1-6!");
            }
        } while (opcion != 6);
        return producto;
    }
}
