package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.Carrito;
import com.backend.BackEndAmigurimisAtelier.model.Usuario;
import com.backend.BackEndAmigurimisAtelier.repository.ICarritoRepository;
import com.backend.BackEndAmigurimisAtelier.repository.IUsuarioRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.ICarritoService;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Carrito guardarCarritoParaUsuario(Long idUsuario, Carrito carrito) {
        try {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();
                carrito.setUsuario(usuario);
                usuario.setCarrito(carrito);
                usuarioRepository.save(usuario);
                return usuario.getCarrito();
            } else {
                throw new RuntimeException("Usuario no encontrado con ID " + idUsuario);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el carrito para el usuario", e);
        }
    }
    @Override
    @Transactional
    public void asignarCarritoAUsuario(Long idUsuario, Long idCarrito) {
        try {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
            Optional<Carrito> carritoOptional = carritoRepository.findById(idCarrito);

            if (usuarioOptional.isPresent() && carritoOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();
                Carrito carrito = carritoOptional.get();

                carrito.setUsuario(usuario);
                usuario.setCarrito(carrito);

                usuarioRepository.save(usuario); // Guardar la relación
            } else {
                if (usuarioOptional.isEmpty()) {
                    throw new RuntimeException("Usuario no encontrado con ID " + idUsuario);
                } else {
                    throw new RuntimeException("Carrito no encontrado con ID " + idCarrito);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al asignar el carrito al usuario", e);
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
