package com.backend.BackEndAmigurimisAtelier.repository;

import com.backend.BackEndAmigurimisAtelier.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarritoRepository extends JpaRepository<Carrito, Long> {
}
