package com.backend.BackEndAmigurimisAtelier.service;

import com.backend.BackEndAmigurimisAtelier.model.MetodoPago;
import com.backend.BackEndAmigurimisAtelier.repository.IMetodoPagoRepository;
import com.backend.BackEndAmigurimisAtelier.serviceInterface.IMetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoService implements IMetodoPagoService {

    @Autowired
    private IMetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPago> listar() {
        try {
            return metodoPagoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar métodos de pago", e);
        }
    }

    @Override
    public MetodoPago guardar(MetodoPago metodoPago) {
        try {
            return metodoPagoRepository.save(metodoPago);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el método de pago", e);
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            metodoPagoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el método de pago con ID " + id, e);
        }
    }

    @Override
    public Optional<MetodoPago> buscarPorId(Long id) {
        try {
            return metodoPagoRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar método de pago con ID " + id, e);
        }
    }
}


