package com.backend.BackEndAmigurimisAtelier.model;

import jakarta.persistence.*;
@Entity

@Entity
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoProducto;

    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;

    public DetallePedido() {
    }

    public DetallePedido(Long idPedidoProducto, Integer cantidad, Double precioUnitario, Double subtotal, Producto producto, Pedido pedido) {
        this.idPedidoProducto = idPedidoProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.producto = producto;
        this.pedido = pedido;
    }

    public Long getIdPedidoProducto() {
        return idPedidoProducto;
    }

    public void setIdPedidoProducto(Long idPedidoProducto) {
        this.idPedidoProducto = idPedidoProducto;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;
}
