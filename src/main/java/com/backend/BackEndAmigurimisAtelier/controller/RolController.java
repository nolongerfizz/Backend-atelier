package com.backend.BackEndAmigurimisAtelier.controller;

import com.backend.BackEndAmigurimisAtelier.model.Rol;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping
    public List<Rol> listarRoles() {
        return rolService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Rol> obtenerRolPorId(@PathVariable Long id) {
        return rolService.buscarPorId(id);
    }

    @PostMapping
    public Rol crearRol(@RequestBody Rol rol) {
        return rolService.guardar(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable Long id) {
        rolService.eliminar(id);
    }
}
