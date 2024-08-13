package com.ejemplo.biblioteca.service;

import com.ejemplo.biblioteca.model.Usuario;
import com.ejemplo.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(String documentoIdentidad) {
        usuarioRepository.deleteById(documentoIdentidad);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUsuarioById(String documentoIdentidad) {
        return usuarioRepository.findById(documentoIdentidad);
    }
}
