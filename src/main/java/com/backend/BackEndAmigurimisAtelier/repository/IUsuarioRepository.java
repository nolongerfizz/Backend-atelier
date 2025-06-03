package com.backend.BackEndAmigurimisAtelier.repository;

import com.backend.BackEndAmigurimisAtelier.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
