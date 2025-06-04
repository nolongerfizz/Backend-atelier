package com.backend.BackEndAmigurimisAtelier.serviceInterface;
import com.backend.BackEndAmigurimisAtelier.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    // Metodo para devolver todos los usuarios
    List<Usuario> obtenerTodosUsuarios();

    // Metodo para encontrar usuario por su id
    Usuario obtenerUsuarioId(Long id);

    // Metodo para guardar nuevo usuario a la lista de usuarios
    void guardarUsuario(Usuario usuario);

    // Metodo para eliminar usuario de la lista
    void eliminarUsuario(Long Id);

    // Metodo para editar usuario de la lista (PUT)
    void editarUsuario(Long id, Usuario usuarioActualizado);
}
