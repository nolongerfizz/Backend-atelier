package com.backend.BackEndAmigurimisAtelier.repository;

import com.backend.BackEndAmigurimisAtelier.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<ProductoModel, Long> {

}
