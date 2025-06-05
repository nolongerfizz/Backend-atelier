package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.MetodoPago;
import com.backend.BackEndAmigurimisAtelier.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface IMetodoPagoService {
    List<MetodoPago> listar();
    MetodoPago guardar(MetodoPago metodoPago);
    void eliminar(Long id);
    Optional<MetodoPago> buscarPorId(Long id);
    Pedido asignarMetodoPagoAPedido(Long idPedido, Long idMetodoPago);
    Pedido cambiarMetodoPagoDePedido(Long idPedido, Long idMetodoPago);
}
