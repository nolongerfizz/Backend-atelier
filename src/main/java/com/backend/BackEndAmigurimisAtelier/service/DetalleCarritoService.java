package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.Carrito;
import com.backend.BackEndAmigurimisAtelier.model.DetalleCarrito;
import com.backend.BackEndAmigurimisAtelier.repository.ICarritoRepository;
import com.backend.BackEndAmigurimisAtelier.repository.IDetalleCarritoRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IDetalleCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCarritoService implements IDetalleCarritoService {

    @Autowired
    private IDetalleCarritoRepository detalleCarritoRepository;
    @Autowired
    private ICarritoRepository carritoRepository;

    @Override
    public List<DetalleCarrito> listarTodos() {
        try {
            return detalleCarritoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los detalles del carrito", e);
        }
    }

    @Override
    public DetalleCarrito obtenerPorId(Long id) {
        try {
            return detalleCarritoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("DetalleCarrito no encontrado con ID " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar detalle del carrito", e);
        }
    }

    @Override
    public DetalleCarrito guardar(DetalleCarrito detalleCarrito) {
        try {
            return detalleCarritoRepository.save(detalleCarrito);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el detalle del carrito", e);
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            detalleCarritoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el detalle del carrito", e);
        }
    }

    @Override
    public void editar(Long id, DetalleCarrito detalleActualizado) {
        try {
            DetalleCarrito existente = obtenerPorId(id);
            existente.setPersonalizacion(detalleActualizado.getPersonalizacion());
            existente.setTamaño(detalleActualizado.getTamaño());
            existente.setEmpaqueEspecial(detalleActualizado.getEmpaqueEspecial());
            existente.setCantidad(detalleActualizado.getCantidad());
            existente.setPrecioUnitario(detalleActualizado.getPrecioUnitario());
            existente.setSubtotal(detalleActualizado.getSubtotal());
            existente.setCarrito(detalleActualizado.getCarrito());
            existente.setProducto(detalleActualizado.getProducto());
            detalleCarritoRepository.save(existente);
        } catch (Exception e) {
            throw new RuntimeException("Error al editar el detalle del carrito", e);
        }
    }
    @Override
    public DetalleCarrito agregarDetalleACarrito(Long idCarrito, DetalleCarrito detalle) {
        try {
            Carrito carrito = carritoRepository.findById(idCarrito).orElse(null);
            if (carrito == null) {
                throw new RuntimeException("Carrito no encontrado con ID " + idCarrito);
            }

            detalle.setCarrito(carrito);
            return detalleCarritoRepository.save(detalle);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar detalle al carrito", e);
        }
    }

    @Override
    public DetalleCarrito asociarDetalleExistenteACarrito(Long idDetalle, Long idCarrito) {
        try {
            DetalleCarrito detalle = detalleCarritoRepository.findById(idDetalle).orElse(null);
            if (detalle == null) {
                throw new RuntimeException("DetalleCarrito no encontrado con ID " + idDetalle);
            }

            Carrito carrito = carritoRepository.findById(idCarrito).orElse(null);
            if (carrito == null) {
                throw new RuntimeException("Carrito no encontrado con ID " + idCarrito);
            }

            detalle.setCarrito(carrito);
            return detalleCarritoRepository.save(detalle);
        } catch (Exception e) {
            throw new RuntimeException("Error al asociar detalle existente al carrito", e);
        }
    }

}
