package com.backend.BackEndAmigurimisAtelier.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrito;

    private Double totalPrecioCarrito;
    private Integer cantidadProductos;

    public Carrito() {
    }

    public Carrito(Long idCarrito, Double totalPrecioCarrito, Integer cantidadProductos, Usuario usuario, List<DetalleCarrito> detalles) {
        this.idCarrito = idCarrito;
        this.totalPrecioCarrito = totalPrecioCarrito;
        this.cantidadProductos = cantidadProductos;
        this.usuario = usuario;
        this.detalles = detalles;
    }

    public Long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Double getTotalPrecioCarrito() {
        return totalPrecioCarrito;
    }

    public void setTotalPrecioCarrito(Double totalPrecioCarrito) {
        this.totalPrecioCarrito = totalPrecioCarrito;
    }

    public Integer getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(Integer cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetalleCarrito> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCarrito> detalles) {
        this.detalles = detalles;
    }

    @OneToOne
    @JoinColumn(name = "idUsuario")
    @JsonManagedReference
    private Usuario usuario;

    @OneToMany(mappedBy = "carrito")
    private List<DetalleCarrito> detalles = new ArrayList<>();




}
