package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.Carrito;
import com.backend.BackEndAmigurimisAtelier.repository.ICarritoRepository;
import com.backend.BackEndAmigurimisAtelier.repository.IUsuarioRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarritoService implements ICarritoService {

    private ICarritoRepository carritoRepository;
    private IUsuarioRepository usuarioRepository;

    @Autowired
    public CarritoService(ICarritoRepository carritoRepository, IUsuarioRepository usuarioRepository) {
        this.carritoRepository = carritoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Carrito obtenerCarritoId(Long idCarrito) {
        try {
            Optional<Carrito> carrito = carritoRepository.findById(idCarrito);
            if (carrito.isPresent()) {
                return carrito.get();
            } else {
                throw new RuntimeException("Carrito no encontrado con ID " + idCarrito);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el carrito", e);
        }
    }

    @Override
    public Carrito guardarCarritoParaUsuario(Long idUsuario, Carrito carrito) {
        try {
            return usuarioRepository.findById(idUsuario).map(usuario -> {
                carrito.setUsuario(usuario); // asignar el usuario al carrito
                usuario.setCarrito(carrito);
                return carritoRepository.save(carrito);
            }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID " + idUsuario));
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el carrito para el usuario", e);
        }
    }

    @Override
    public Carrito actualizarCarrito(Long idCarrito, Carrito carritoActualizado) {
        try {
            Carrito carritoExistente = obtenerCarritoId(idCarrito);

            carritoExistente.setCantidadProductos(carritoActualizado.getCantidadProductos());
            carritoExistente.setTotalPrecioCarrito(carritoActualizado.getTotalPrecioCarrito());

            return carritoRepository.save(carritoExistente);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el carrito", e);
        }
    }

    @Override
    public Carrito guardarCarrito(Carrito carrito) {
        try {
            return carritoRepository.save(carrito);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el carrito", e);
        }
    }

    @Override
    public void eliminarCarrito(Long idCarrito) {
        try {
            carritoRepository.deleteById(idCarrito);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el carrito", e);
        }
    }
}
