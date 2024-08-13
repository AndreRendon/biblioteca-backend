package com.ejemplo.biblioteca.controller;

import com.ejemplo.biblioteca.model.Libro;
import com.ejemplo.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        Libro savedLibro = libroService.saveLibro(libro);
        return new ResponseEntity<>(savedLibro, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.getAllLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = libroService.getLibroById(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        if (!libroService.getLibroById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        libro.setId(id);
        Libro updatedLibro = libroService.saveLibro(libro);
        return new ResponseEntity<>(updatedLibro, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        if (!libroService.getLibroById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }
}
