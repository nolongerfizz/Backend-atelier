package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.Producto;
import com.backend.BackEndAmigurimisAtelier.repository.IProductoRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IProductoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final IProductoRepository productoRepository;
    @Autowired
    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);

    }

    @Override
    public void eliminarProducto(Long Id) {
        productoRepository.deleteById(Id);

    }

    @Override
    public void editarProducto(Long id, Producto productoActualizado) {

        Producto producto = productoRepository.findById(id).orElse(null);

        if(producto != null){
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setTamaño(productoActualizado.getTamaño());

            productoRepository.save(producto);
        } else {
            throw new RuntimeException(("No existe el producto con id: " + id));
        }

    }
}
