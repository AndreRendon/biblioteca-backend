package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.model.Libro;
import com.ejemplo.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> getLibroById(Long id) {
        return libroRepository.findById(id);
    }
}
