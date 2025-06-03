package com.backend.BackEndAmigurimisAtelier.repository;

import com.backend.BackEndAmigurimisAtelier.model.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleCarritoRepository extends JpaRepository<DetalleCarrito, Long> {
}
