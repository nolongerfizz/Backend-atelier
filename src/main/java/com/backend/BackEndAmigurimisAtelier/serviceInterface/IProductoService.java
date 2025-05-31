package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.ProductoModel;

import java.util.List;

public interface IProductoService {

    // Metodo para devolver todos los productos
    List<ProductoModel> getAllPosts();

    // Metodo para encontrar producto por su id
    ProductoModel getPostById(Long id);

    // Metodo para guardar nuevo producto a la lista de productos
    void saveProducto(ProductoModel producto);

    // Metodo para eliminar producto de la lista
    void deleteProducto(Long Id);

    // Metodo para editar producto de la lista (PUT)
    void editProducto(Long id, ProductoModel productoActualizado);
}
