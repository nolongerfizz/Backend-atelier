package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.Pedido;
import com.backend.BackEndAmigurimisAtelier.repository.IPedidoRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        try {
            return pedidoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los pedidos", e);
        }
    }

    @Override
    public Pedido obtenerPedidoPorId(Long id) {
        try {
            Optional<Pedido> pedido = pedidoRepository.findById(id);
            if (pedido.isPresent()) {
                return pedido.get();
            } else {
                throw new RuntimeException("Pedido no encontrado con ID" + id);

            }
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar pedido", e);
        }
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        try {
            return pedidoRepository.save(pedido);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el pedido", e);
        }
    }

    @Override
    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado) {
        try {
            Pedido pedidoExistente = obtenerPedidoPorId(id);
            pedidoExistente.setDireccion(pedidoActualizado.getDireccion());
            pedidoExistente.setFecha(pedidoActualizado.getFecha());
            pedidoExistente.setEstado(pedidoActualizado.getEstado());
            pedidoExistente.setTotalPrecioPedido(pedidoActualizado.getTotalPrecioPedido());
            pedidoExistente.setCantidadProducto(pedidoActualizado.getCantidadProducto());
            pedidoExistente.setUsuario(pedidoActualizado.getUsuario());
            pedidoExistente.setMetodoPago(pedidoActualizado.getMetodoPago());
            pedidoExistente.setDetalles(pedidoActualizado.getDetalles());

            return pedidoRepository.save(pedidoExistente);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el pedido", e);
        }
    }

    @Override
    public void eliminarPedido(Long id) {
        try {
            pedidoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el pedido", e);
        }
    }
}
