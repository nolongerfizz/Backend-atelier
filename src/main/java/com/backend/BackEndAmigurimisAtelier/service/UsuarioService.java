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
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);

    }

    @Override
    public void eliminarUsuario(Long Id) {
        usuarioRepository.deleteById(Id);

    }

    @Override
    public void editarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if(usuario != null){
            // Actualiza los campos con los valores nuevos
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setContraseña(usuarioActualizado.getContraseña());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setTelefono(usuarioActualizado.getTelefono());

            usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException(("No existe el usuario con id: " + id));
        }
    }
}


