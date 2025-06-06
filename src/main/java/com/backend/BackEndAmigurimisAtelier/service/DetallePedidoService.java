package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.DetallePedido;
import com.backend.BackEndAmigurimisAtelier.model.Pedido;
import com.backend.BackEndAmigurimisAtelier.repository.IDetallePedidoRepository;
import com.backend.BackEndAmigurimisAtelier.repository.IPedidoRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService implements IDetallePedidoService {

    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;
    @Autowired
    private IPedidoRepository pedidoRepository;

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
    @Override
    public DetallePedido guardarDetalleParaPedido(Long idPedido, DetallePedido detalle) {
        try {
            Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
            if (pedido == null) {
                throw new RuntimeException("Pedido no encontrado con id: " + idPedido);
            }

            detalle.setPedido(pedido);
            return detallePedidoRepository.save(detalle);

        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el detalle para el pedido con id: " + idPedido, e);
        }
    }

    @Override
    public DetallePedido agregarDetalleExistenteAPedido(Long idPedido, Long idDetalle) {
        try {
            Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
            if (pedido == null) {
                throw new RuntimeException("Pedido no encontrado con id: " + idPedido);
            }

            DetallePedido detalle = detallePedidoRepository.findById(idDetalle).orElse(null);
            if (detalle == null) {
                throw new RuntimeException("DetallePedido no encontrado con id: " + idDetalle);
            }

            detalle.setPedido(pedido);
            return detallePedidoRepository.save(detalle);

        } catch (Exception e) {
            throw new RuntimeException("Error al agregar el detalle existente al pedido con id: " + idPedido, e);
        }
    }

}
