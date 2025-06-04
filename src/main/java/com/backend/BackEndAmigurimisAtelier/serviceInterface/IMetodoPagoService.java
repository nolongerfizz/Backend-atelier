package com.backend.BackEndAmigurimisAtelier.serviceInterface;

import com.backend.BackEndAmigurimisAtelier.model.MetodoPago;

import java.util.List;
import java.util.Optional;

public interface IMetodoPagoService {
    List<MetodoPago> listar();
    MetodoPago guardar(MetodoPago metodoPago);
    void eliminar(Long id);
    Optional<MetodoPago> buscarPorId(Long id);
}
