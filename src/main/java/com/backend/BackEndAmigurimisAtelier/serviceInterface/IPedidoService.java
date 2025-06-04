package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.Pedido;

import java.util.List;

public interface IPedidoService {
    List<Pedido> obtenerTodosLosPedidos();
    Pedido obtenerPedidoPorId(Long id);
    Pedido guardarPedido(Pedido pedido);
    Pedido actualizarPedido(Long id, Pedido pedidoActualizado);
    void eliminarPedido(Long id);
}
