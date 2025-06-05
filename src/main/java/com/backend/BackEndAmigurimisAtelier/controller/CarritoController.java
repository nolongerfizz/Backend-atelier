package com.backend.BackEndAmigurimisAtelier.controller;

import com.backend.BackEndAmigurimisAtelier.model.Carrito;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carrito")
public class CarritoController {

    @Autowired
    private ICarritoService carritoService;

    // Obtener carrito por ID
    @GetMapping("/{id}")
    public Carrito obtenerCarritoPorId(@PathVariable Long id) {
        return carritoService.obtenerCarritoId(id);
    }

    // Guardar un carrito
    @PostMapping("/guardar")
    public Carrito guardarCarrito(@RequestBody Carrito carrito) {
        return carritoService.guardarCarrito(carrito);
    }

    // Guardar un carrito para un usuario
    @PostMapping("/guardar/usuario/{idUsuario}")
    public Carrito guardarCarritoParaUsuario(@PathVariable Long idUsuario, @RequestBody Carrito carrito) {
        return carritoService.guardarCarritoParaUsuario(idUsuario, carrito);
    }
    //Asignar un carrito existente a usuario
    @PutMapping("/asignar/{idCarrito}/usuario/{idUsuario}")
    public void asignarCarritoAUsuario(@PathVariable Long idCarrito, @PathVariable Long idUsuario) {
        carritoService.asignarCarritoAUsuario(idUsuario, idCarrito);
    }

    // Actualizar carrito por ID
    @PutMapping("/actualizar/{id}")
    public Carrito actualizarCarrito(@PathVariable Long id, @RequestBody Carrito carritoActualizado) {
        return carritoService.actualizarCarrito(id, carritoActualizado);
    }

    // Eliminar carrito por ID
    @DeleteMapping("/eliminar/{id}")
    public void eliminarCarrito(@PathVariable Long id) {
        carritoService.eliminarCarrito(id);
    }
}


