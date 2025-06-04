package com.backend.BackEndAmigurimisAtelier.controller;

import com.backend.BackEndAmigurimisAtelier.model.DetallePedido;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-pedido")
public class DetallePedidoController {

    @Autowired
    private IDetallePedidoService detallePedidoService;

    @GetMapping
    public ResponseEntity<List<DetallePedido>> obtenerTodosLosDetalles() {
        try {
            List<DetallePedido> detalles = detallePedidoService.obtenerTodosLosDetallesPedido();
            return ResponseEntity.ok(detalles);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> obtenerDetallePorId(@PathVariable Long id) {
        try {
            DetallePedido detalle = detallePedidoService.obtenerDetallePedidoPorId(id);
            return detalle != null ? ResponseEntity.ok(detalle) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<DetallePedido> crearDetalle(@RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido nuevoDetalle = detallePedidoService.crearDetallePedido(detallePedido);
            return ResponseEntity.ok(nuevoDetalle);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> actualizarDetalle(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido actualizado = detallePedidoService.actualizarDetallePedido(id, detallePedido);
            return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long id) {
        try {
            detallePedidoService.eliminarDetallePedido(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
