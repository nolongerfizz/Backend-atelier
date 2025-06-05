package com.backend.BackEndAmigurimisAtelier.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private LocalDateTime fecha;

    private String estado;
    private Double totalPrecioPedido;
    private Integer cantidadProducto;


    public Pedido() {
    }

    public Pedido(Long idPedido, String direccion, LocalDateTime fecha, String estado, Double totalPrecioPedido, Integer cantidadProducto, Usuario usuario, MetodoPago metodoPago, List<DetallePedido> detalles) {
        this.idPedido = idPedido;
        this.direccion = direccion;
        this.fecha = fecha;
        this.estado = estado;
        this.totalPrecioPedido = totalPrecioPedido;
        this.cantidadProducto = cantidadProducto;
        this.usuario = usuario;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotalPrecioPedido() {
        return totalPrecioPedido;
    }

    public void setTotalPrecioPedido(Double totalPrecioPedido) {
        this.totalPrecioPedido = totalPrecioPedido;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idMetodo")
    @JsonBackReference
    private MetodoPago metodoPago;

    @OneToMany(mappedBy = "pedido")
    @JsonManagedReference
    private List<DetallePedido> detalles = new ArrayList<>();

}
