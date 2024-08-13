package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.model.Libro;
import java.util.List;
import java.util.Optional;

public interface LibroService {
    Libro saveLibro(Libro libro);
    void deleteLibro(Long id);
    List<Libro> getAllLibros();
    Optional<Libro> getLibroById(Long id);
}
