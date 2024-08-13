package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.model.Prestamo;
import java.util.List;
import java.util.Optional;

public interface PrestamoService {
    Prestamo savePrestamo(Prestamo prestamo);
    void deletePrestamo(Long id);
    List<Prestamo> getAllPrestamos();
    List<Prestamo> getPrestamosByUsuario(String documentoIdentidad);
    Optional<Prestamo> getPrestamoById(Long id);
}
