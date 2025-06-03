package com.backend.BackEndAmigurimisAtelier.repository;

import com.backend.BackEndAmigurimisAtelier.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
