package com.backend.BackEndAmigurimisAtelier.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// Tabla
@Entity // Crear tabla en base de datos
@Table(name = "producto") // Asignar nombre para la tabla
public class Producto {


    // Asignar auto-increment a idProducto
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombre;
    private String tamaño;

    @Column(nullable = false)
    private Double precio;


    // Constructors
    public Producto() {

    }

    public Producto(Long idProducto, String nombre, String tamaño, Double precio, List<DetalleCarrito> detallesCarrito, List<DetallePedido> detallesPedido) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.precio = precio;
        this.detallesCarrito = detallesCarrito;
        this.detallesPedido = detallesPedido;
    }

    // Getters and Setters

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<DetalleCarrito> getDetallesCarrito() {
        return detallesCarrito;
    }

    public void setDetallesCarrito(List<DetalleCarrito> detallesCarrito) {
        this.detallesCarrito = detallesCarrito;
    }

    public List<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }

    @OneToMany(mappedBy = "producto")
    private List<DetalleCarrito> detallesCarrito = new ArrayList<>();

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallesPedido = new ArrayList<>();
}
