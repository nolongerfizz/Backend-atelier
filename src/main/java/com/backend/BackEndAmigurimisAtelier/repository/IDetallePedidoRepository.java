package com.backend.BackEndAmigurimisAtelier.repository;

import com.backend.BackEndAmigurimisAtelier.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}
