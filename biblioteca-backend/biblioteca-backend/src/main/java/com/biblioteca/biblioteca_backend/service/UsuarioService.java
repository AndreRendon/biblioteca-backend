package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario saveUsuario(Usuario usuario);
    void deleteUsuario(String documentoIdentidad);
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioById(String documentoIdentidad);
}
