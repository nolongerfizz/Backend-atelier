package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.Usuario;
import com.backend.BackEndAmigurimisAtelier.repository.IUsuarioRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los usuarios", e);
        }
    }

    @Override
    public Usuario obtenerUsuarioId(Long id) {
        try {
            return usuarioRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar usuario", e);
        }
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el usuario", e);
        }
    }

    @Override
    public void eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el usuario", e);
        }
    }

    @Override
    public void editarUsuario(Long id, Usuario usuarioActualizado) {
        try {
            Usuario usuario = usuarioRepository.findById(id).orElse(null);
            if (usuario != null) {
                // Actualiza los campos con los valores nuevos
                usuario.setNombre(usuarioActualizado.getNombre());
                usuario.setContraseña(usuarioActualizado.getContraseña());
                usuario.setCorreo(usuarioActualizado.getCorreo());
                usuario.setTelefono(usuarioActualizado.getTelefono());

                usuarioRepository.save(usuario);
            } else {
                throw new RuntimeException("No existe el usuario con id: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al editar el usuario", e);
        }
    }
}