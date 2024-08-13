package com.biblioteca.backend.repository;

import com.biblioteca.backend.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByUsuario_DocumentoIdentidad(String documentoIdentidad);

}
