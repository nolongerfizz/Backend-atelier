package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {
    List<Rol> listar();
    Rol guardar(Rol rol);
    void eliminar(Long id);
    Optional<Rol> buscarPorId(Long id);
}
