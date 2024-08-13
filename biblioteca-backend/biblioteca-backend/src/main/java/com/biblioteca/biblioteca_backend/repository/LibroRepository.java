package com.biblioteca.backend.repository;

import com.biblioteca.backend.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
