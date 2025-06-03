package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.Producto;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IProductoService;

import java.util.List;


public class ProductoService implements IProductoService {

    @Override
    public List<Producto> getAllPosts() {
        return List.of();
    }

    @Override
    public Producto getPostById(Long id) {
        return null;
    }

    @Override
    public void saveProducto(Producto producto) {

    }

    @Override
    public void deleteProducto(Long Id) {

    }

    @Override
    public void editProducto(Long id, Producto productoActualizado) {

    }
}
