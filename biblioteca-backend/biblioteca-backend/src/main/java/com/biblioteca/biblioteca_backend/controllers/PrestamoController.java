package com.ejemplo.biblioteca.controller;

import com.ejemplo.biblioteca.model.Prestamo;
import com.ejemplo.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<Prestamo> createPrestamo(@RequestBody Prestamo prestamo) {
        Prestamo savedPrestamo = prestamoService.savePrestamo(prestamo);
        return new ResponseEntity<>(savedPrestamo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Prestamo>> getAllPrestamos() {
        List<Prestamo> prestamos = prestamoService.getAllPrestamos();
        return new ResponseEntity<>(prestamos, HttpStatus.OK);
    }

    @GetMapping("/usuario/{documentoIdentidad}")
    public ResponseEntity<List<Prestamo>> getPrestamosByUsuario(@PathVariable String documentoIdentidad) {
        List<Prestamo> prestamos = prestamoService.getPrestamosByUsuario(documentoIdentidad);
        return new ResponseEntity<>(prestamos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable Long id) {
        Optional<Prestamo> prestamo = prestamoService.getPrestamoById(id);
        return prestamo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        if (!prestamoService.getPrestamoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        prestamo.setId(id);
        Prestamo updatedPrestamo = prestamoService.savePrestamo(prestamo);
        return new ResponseEntity<>(updatedPrestamo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id) {
        if (!prestamoService.getPrestamoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        prestamoService.deletePrestamo(id);
        return ResponseEntity.noContent().build();
    }
}
