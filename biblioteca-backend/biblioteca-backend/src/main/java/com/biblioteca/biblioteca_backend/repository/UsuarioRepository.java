package com.biblioteca.backend.repository;

import com.biblioteca.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
