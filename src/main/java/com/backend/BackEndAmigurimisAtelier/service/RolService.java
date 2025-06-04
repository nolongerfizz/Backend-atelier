package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.Rol;
import com.backend.BackEndAmigurimisAtelier.repository.IRolRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService {

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<Rol> listar() {
        try {
            return rolRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los roles", e);
        }
    }

    @Override
    public Rol guardar(Rol rol) {
        try {
            return rolRepository.save(rol);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el rol", e);
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            rolRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el rol con ID: " + id, e);
        }
    }

    @Override
    public Optional<Rol> buscarPorId(Long id) {
        try {
            Optional<Rol> rol = rolRepository.findById(id);
            if (rol.isPresent()) {
                return rol;
            } else {
                throw new RuntimeException("Rol no encontrado con ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar el rol con ID: " + id, e);
        }
    }
}
