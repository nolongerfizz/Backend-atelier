package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.DetallePedido;

import java.util.List;

public interface IDetallePedidoService {
    List<DetallePedido> obtenerTodosLosDetallesPedido();
    DetallePedido obtenerDetallePedidoPorId(Long id);
    DetallePedido crearDetallePedido(DetallePedido detallePedido); // <-- MAKE SURE THIS IS HERE
    DetallePedido actualizarDetallePedido(Long id, DetallePedido detallePedido);
    void eliminarDetallePedido(Long id);
}
