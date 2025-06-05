package com.backend.BackEndAmigurimisAtelier.controller;

import com.backend.BackEndAmigurimisAtelier.model.DetalleCarrito;
import com.backend.BackEndAmigurimisAtelier.service.DetalleCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallecarrito")
public class DetalleCarritoController {
    private final DetalleCarritoService detalleCarritoService;

    @Autowired
    public DetalleCarritoController(DetalleCarritoService detalleCarritoService) {
        this.detalleCarritoService = detalleCarritoService;
    }

    @GetMapping
    public List<DetalleCarrito> obtenerTodoDetalles() {
        return detalleCarritoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCarrito> obtenerDetalleById(@PathVariable Long id) {
        try {
            DetalleCarrito detalle = detalleCarritoService.obtenerPorId(id);
            return ResponseEntity.ok(detalle);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> guardarDetalle(@RequestBody DetalleCarrito detalleCarrito) {
        detalleCarritoService.guardar(detalleCarrito);
        return ResponseEntity.ok("DetalleCarrito guardado");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> elimninarDetalle(@PathVariable Long id) {
        try {
            detalleCarritoService.eliminar(id);
            return ResponseEntity.ok("DetalleCarrito eliminado");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> actualizarDetalle(@PathVariable Long id, @RequestBody DetalleCarrito detalleActualizado) {
        try {
            detalleCarritoService.editar(id, detalleActualizado);
            return ResponseEntity.ok("DetalleCarrito actualizado");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/carrito/{idCarrito}/agregar")
    public ResponseEntity<?> agregarDetalleACarrito(@PathVariable Long idCarrito, @RequestBody DetalleCarrito detalle) {
        try {
            DetalleCarrito detalleGuardado = detalleCarritoService.agregarDetalleACarrito(idCarrito, detalle);
            return ResponseEntity.ok(detalleGuardado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + e.getMessage());
        }
    }

    @PutMapping("/{idDetalle}/asociar/carrito/{idCarrito}")
    public ResponseEntity<?> asociarDetalleExistenteACarrito(@PathVariable Long idDetalle, @PathVariable Long idCarrito) {
        try {
            DetalleCarrito detalleActualizado = detalleCarritoService.asociarDetalleExistenteACarrito(idDetalle, idCarrito);
            return ResponseEntity.ok(detalleActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado: " + e.getMessage());
        }
    }

}
