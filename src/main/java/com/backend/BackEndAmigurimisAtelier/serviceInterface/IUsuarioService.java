package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> listar();
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
    Optional<Usuario> buscarPorId(Long id);
}
