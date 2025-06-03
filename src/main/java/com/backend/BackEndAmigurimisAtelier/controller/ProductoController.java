package com.backend.BackEndAmigurimisAtelier.controller;

import com.backend.BackEndAmigurimisAtelier.model.Producto;
import com.backend.BackEndAmigurimisAtelier.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")   //Ruta de los endpoints

public class ProductoController {
    private  final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoService.obtenerTodosProductos();
    }

    @GetMapping(value = "/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoService.obtenerProductoId(id);
    }

    @PostMapping
    public ResponseEntity<String> saveProducto(@RequestBody Producto producto){
        productoService.guardarProducto(producto);
        return ResponseEntity.ok("Producto guardado");
    }

    @DeleteMapping(value = "/borrar/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        try {
            productoService.eliminarProducto(id);
            return ResponseEntity.ok("Producto eliminado");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        try {
            productoService.editarProducto(id, productoActualizado);
            return ResponseEntity.ok("Producto actualizado");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }
}

