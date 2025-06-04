package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.DetallePedido;
import com.backend.BackEndAmigurimisAtelier.repository.IDetallePedidoRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class DetallePedidoService implements IDetallePedidoService {

    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedido> obtenerTodosLosDetallesPedido() {
        try {
            return  detallePedidoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los detalles del pedido.", e);
        }
    }

    @Override
    public DetallePedido obtenerDetallePedidoPorId(Long id) {
        try {
            return detallePedidoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("DetallePedido no encontrado con id: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el detalle del pedido con id: " + id, e);
        }
    }

    @Override
    public DetallePedido crearDetallePedido(DetallePedido detallePedido) {
        try {
            return detallePedidoRepository.save(detallePedido);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el detalle del pedido", e);
        }
    }

    @Override
    public DetallePedido actualizarDetallePedido(Long id, DetallePedido detalleActualizado) {
        try {
            Optional<DetallePedido> detalleExistente = detallePedidoRepository.findById(id);

            if (detalleExistente.isPresent()) {
                DetallePedido detalle = detalleExistente.get();
                detalle.setCantidad(detalleActualizado.getCantidad());
                detalle.setPrecioUnitario(detalleActualizado.getPrecioUnitario());
                detalle.setSubtotal(detalleActualizado.getSubtotal());
                detalle.setProducto(detalleActualizado.getProducto());
                detalle.setPedido(detalleActualizado.getPedido());

                return detallePedidoRepository.save(detalle);
            } else {
                throw new RuntimeException("DetallePedido no encontrado con id: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el detalle del pedido con id: " + id, e);
        }
    }

    @Override
    public void eliminarDetallePedido(Long id) {
        try {
            if (!detallePedidoRepository.existsById(id)) {
                throw new RuntimeException("No existe un DetallePedido con id: " + id);
            }
            detallePedidoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el detalle del pedido con id: " + id, e);
        }
    }
}
