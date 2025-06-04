package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.DetalleCarrito;

import java.util.List;


public interface IDetalleCarritoService {
    List<DetalleCarrito> listarTodos();
    DetalleCarrito obtenerPorId(Long id);
    DetalleCarrito guardar(DetalleCarrito detalleCarrito);
    void eliminar(Long id);
    void editar(Long id, DetalleCarrito detalleActualizado);
}
