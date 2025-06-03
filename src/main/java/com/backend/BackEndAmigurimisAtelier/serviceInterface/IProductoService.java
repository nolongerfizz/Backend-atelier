package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.Producto;

import java.util.List;

public interface IProductoService {

    // Metodo para devolver todos los productos
    List<Producto> obtenerTodosProductos();

    // Metodo para encontrar producto por su id
    Producto obtenerProductoId(Long id);

    // Metodo para guardar nuevo producto a la lista de productos
    void guardarProducto(Producto producto);

    // Metodo para eliminar producto de la lista
    void eliminarProducto(Long Id);

    // Metodo para editar producto de la lista (PUT)
    void editarProducto(Long id, Producto productoActualizado);
}
