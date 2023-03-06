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
        System.out.println("\n--------------------------------------------------------------------------------------------------------");
        System.out.println("id   | nombre                         |       precio |exist.|  disponible   | categoría                   ");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for(Producto p : productos)
            System.out.println(p.toString());
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    public void mostrarProducto(Producto producto) {
        System.out.println("\n--------------------------------------------------------------------------------------------------------");
        System.out.println("id   | nombre                         |       precio |exist.|  disponible   | categoría                   ");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(producto.toString());
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    public void agregarProducto() {
        System.out.println("\nIngrese la siguente información para un nuevo producto");
        String nombre = Sc.leerTexto("Nombre");
        double precio = Sc.leerReal("Precio");
        int existencia = Sc.leerEntero("Existencia");

        int disponibilidad = Sc.leerEntero("Es el producto disponible?\n1 - SÍ\n2 - NO");
        boolean disponible = (disponibilidad == 1) ? true : false;

        String categoria = Sc.leerTexto("Categoria");
        productoService.agregarProducto(new Producto(nombre, precio, existencia, disponible, categoria));
        System.out.println("\nProducto se agregó con éxito");
    }

    public Producto modificarProducto(Producto producto) {
        int opcion = 0;
        do {
            try{
                mostrarProducto(producto);
                System.out.println("Digite el campo que quiere modificar");
                opcion = Sc.leerEntero("\n1 - Nombre\n2 - Precio\n3 - Existencia\n4 - Disponibilidad\n" +
                        "5 - Categoría\n6 - Volver al menú principal");

                switch(opcion) {
                    case 1:
                        String nombre = Sc.leerTexto("Ingrese el nuevo nombre");
                        producto.setNombre(nombre);
                        break;
                    case 2:
                        double precio = Sc.leerReal("Ingrese el nuevo precio");
                        producto.setPrecio(precio);
                        break;
                    case 3:
                        int existencia = Sc.leerEntero("Ingrese la nueva existencia");
                        producto.setExistencia(existencia);
                        break;
                    case 4:
                        int disponibilidad = Sc.leerEntero("Es el producto disponible?\n1 - SÍ\n2 - NO");
                        boolean disponible = producto.isDisponible();

                        if (disponibilidad == 1) disponible = true;
                        else if (disponibilidad == 2) disponible = false;
                        else System.out.println("Opción no válida!");

                        producto.setDisponible(disponible);
                        break;
                    case 5:
                        String categoria = Sc.leerTexto("Ingrese la nueva categoría");
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

    public void eliminarProducto(List<Producto> listaProductos, int productoId) {
        boolean found = false;
        for (int i = 0; i < listaProductos.size(); i++) {
            if (productoId == listaProductos.get(i).getId()) {
                productoService.eliminarProducto(productoId);
                System.out.println("Producto se eliminó con éxito");
                found = true;
                break;
            }
        }
        if (found == false) System.out.println("Producto con ID " + productoId + " no se encuentra.");
    }

    public int elegirMenu() {
        String menu = "\nQué desea hacer?" +
                "\n 1 - Agregar nuevo producto" +
                "\n 2 - Ver una lista de los productos" +
                "\n 3 - Actualizar los datos de un producto" +
                "\n 4 - Eliminar un estudiante" +
                "\n 5 - SALIR";

        //  Pregunta al usuario cuál de las opciones quiere eligir y asegura que elija una opcion valida.
        boolean repetir = true;
        int opcion = 0;
        while (repetir) {
            try{
                opcion = Sc.leerEntero(menu);

                if (opcion >= 1 && opcion <= 4)
                    repetir = false;
                else {
                    System.out.println("Por favor, solo digite un número entre 1 - 5.\n");
                    repetir = true;
                }
            }catch (Exception e) {
                System.out.println("Por favor, solo digite un número entre 1 - 5.\n");
                repetir = true;
            }
        }
        return opcion;
    }
}
