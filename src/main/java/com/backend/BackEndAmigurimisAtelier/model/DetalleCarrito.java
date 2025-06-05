package com.backend.BackEndAmigurimisAtelier.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class DetalleCarrito {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarritoProducto;

    private String personalizacion;
    private String tamaño;
    private String empaqueEspecial;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;


    public DetalleCarrito() {
    }

    public DetalleCarrito(Long idCarritoProducto, String personalizacion, String tamaño, String empaqueEspecial, Integer cantidad, Double precioUnitario, Double subtotal, Carrito carrito, Producto producto) {
        this.idCarritoProducto = idCarritoProducto;
        this.personalizacion = personalizacion;
        this.tamaño = tamaño;
        this.empaqueEspecial = empaqueEspecial;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.carrito = carrito;
        this.producto = producto;
    }


    public Long getIdCarritoProducto() {
        return idCarritoProducto;
    }

    public void setIdCarritoProducto(Long idCarritoProducto) {
        this.idCarritoProducto = idCarritoProducto;
    }

    public String getPersonalizacion() {
        return personalizacion;
    }

    public void setPersonalizacion(String personalizacion) {
        this.personalizacion = personalizacion;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getEmpaqueEspecial() {
        return empaqueEspecial;
    }

    public void setEmpaqueEspecial(String empaqueEspecial) {
        this.empaqueEspecial = empaqueEspecial;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @ManyToOne
    @JoinColumn(name = "idCarrito")
    @JsonBackReference
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    @JsonBackReference
    private Producto producto;

}
