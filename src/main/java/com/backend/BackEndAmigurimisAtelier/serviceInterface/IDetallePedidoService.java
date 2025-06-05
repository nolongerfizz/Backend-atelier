package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.DetallePedido;

import java.util.List;

public interface IDetallePedidoService {
    List<DetallePedido> obtenerTodosLosDetallesPedido();
    DetallePedido obtenerDetallePedidoPorId(Long id);
    DetallePedido crearDetallePedido(DetallePedido detallePedido);
    DetallePedido actualizarDetallePedido(Long id, DetallePedido detallePedido);
    void eliminarDetallePedido(Long id);
    DetallePedido guardarDetalleParaPedido(Long idPedido, DetallePedido detalle);
    DetallePedido agregarDetalleExistenteAPedido(Long idPedido, Long idDetalle);
}
