package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.model.Prestamo;
import com.ejemplo.biblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public void deletePrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public List<Prestamo> getPrestamosByUsuario(String documentoIdentidad) {
        // Aquí puedes implementar un método personalizado en el repositorio
        return prestamoRepository.findByUsuario_DocumentoIdentidad(documentoIdentidad);
    }

    @Override
    public Optional<Prestamo> getPrestamoById(Long id) {
        return prestamoRepository.findById(id);
    }
}
