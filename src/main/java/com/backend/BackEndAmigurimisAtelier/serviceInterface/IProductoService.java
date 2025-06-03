package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.Producto;

import java.util.List;

public interface IProductoService {

    // Metodo para devolver todos los productos
    List<Producto> getAllPosts();

    // Metodo para encontrar producto por su id
    Producto getPostById(Long id);

    // Metodo para guardar nuevo producto a la lista de productos
    void saveProducto(Producto producto);

    // Metodo para eliminar producto de la lista
    void deleteProducto(Long Id);

    // Metodo para editar producto de la lista (PUT)
    void editProducto(Long id, Producto productoActualizado);
}
