package com.backend.BackEndAmigurimisAtelier.model;


import jakarta.persistence.*;

@Entity
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetodo;
    private String nombreMetodo;
    private String descripcion;
    private Boolean activo;

    public MetodoPago() {
    }

    public MetodoPago(Long idMetodo, String nombreMetodo, String descripcion, Boolean activo, List<Pedido> pedidos) {
        this.idMetodo = idMetodo;
        this.nombreMetodo = nombreMetodo;
        this.descripcion = descripcion;
        this.activo = activo;
        this.pedidos = pedidos;
    }


    public Long getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(Long idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @OneToMany(mappedBy = "metodoPago")
        private List<Pedido> pedidos = new ArrayList<>();
}
