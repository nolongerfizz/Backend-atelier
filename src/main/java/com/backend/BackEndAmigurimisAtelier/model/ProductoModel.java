package com.backend.BackEndAmigurimisAtelier.model;

import jakarta.persistence.*;

// Tabla
@Entity // Crear tabla en base de datos
@Table(name = "producto") // Asignar nombre para la tabla
public class ProductoModel {

    // Attributes
    @Id // Asignar nuestro atributo idProducto como primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Asignar auto-increment a idProducto
    private Long idProducto;
    private String nombre;
    private Double precio;
    private Boolean empaqueEspecial;

    // Constructors

    public ProductoModel() {
    }

    public ProductoModel(Long idProducto, String nombre, Double precio, Boolean empaqueEspecial) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.empaqueEspecial = empaqueEspecial;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getEmpaqueEspecial() {
        return empaqueEspecial;
    }

    public void setEmpaqueEspecial(Boolean empaqueEspecial) {
        this.empaqueEspecial = empaqueEspecial;
    }
}
