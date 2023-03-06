package l3.tienda.model.entity;

import jakarta.persistence.*;

// Indica a JPA que esta clase es una entidad que se puede aplicar a una tabla de una BD.
@Entity
@Table(name = "productos")
public class Producto {

    // Se usa para especificar la clave primaria.
    @Id
    // Se usa para decidir cómo se genera la clave primaria. IDENTITY significa que se la creará la BD.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 30, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int existencia;

    @Column(nullable = false)
    private boolean disponible;

    @Column(length = 30, nullable = false)
    private String categoria;


    // Se necesita un constructor sin argumentos porque Hibernate necesita poder instanciar los objetos entidad
    // utilizando un constructor por defecto. Cuando JPA recupera datos de la base de datos, necesita crear una nueva
    // instancia de la clase entity para contener los datos recuperados. Si no hay un constructor sin argumentos, JPA no
    // puede crear esta nueva instancia. Sólo es necesario si se define un constructor, como a continuación.
    public Producto() {

    }

    public Producto(String nombre, double precio, int existencia, boolean disponible, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
        this.disponible = disponible;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("%04d | %-30s | %10f | %4d | %b | %-30s%n", id, nombre, precio, existencia, disponible, categoria);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
