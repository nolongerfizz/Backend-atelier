package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.Carrito;

public interface ICarritoService {
    Carrito obtenerCarritoId(Long idCarrito);
    Carrito guardarCarritoParaUsuario(Long idUsuario, Carrito carrito);
    void asignarCarritoAUsuario(Long idUsuario, Long idCarrito);
    Carrito actualizarCarrito(Long idCarrito, Carrito carritoActualizado);
    Carrito guardarCarrito(Carrito carrito);
    void eliminarCarrito(Long idCarrito);
}
