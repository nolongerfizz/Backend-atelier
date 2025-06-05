package com.backend.BackEndAmigurimisAtelier.controller;

import com.backend.BackEndAmigurimisAtelier.model.MetodoPago;
import com.backend.BackEndAmigurimisAtelier.model.Pedido;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IMetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metodoPago")
@CrossOrigin(origins = "*")
public class MetodoPagoController {

    @Autowired
    private IMetodoPagoService metodoPagoService;

    @GetMapping
    public List<MetodoPago> listar() {
        return metodoPagoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<MetodoPago> buscarPorId(@PathVariable Long id) {
        return metodoPagoService.buscarPorId(id);
    }

    @PostMapping
    public MetodoPago guardar(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.guardar(metodoPago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        metodoPagoService.eliminar(id);
    }

    @PutMapping("/{idPedido}/asignar/{idMetodoPago}")
    public Pedido asignarMetodoPago(@PathVariable Long idPedido, @PathVariable Long idMetodoPago) {
        return metodoPagoService.asignarMetodoPagoAPedido(idPedido, idMetodoPago);
    }

    @PutMapping("/{idPedido}/cambiar/{idMetodoPago}")
    public Pedido cambiarMetodoPago(@PathVariable Long idPedido, @PathVariable Long idMetodoPago) {
        return metodoPagoService.cambiarMetodoPagoDePedido(idPedido, idMetodoPago);
    }

}


