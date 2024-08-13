package com.ejemplo.biblioteca.controller;

import com.ejemplo.biblioteca.model.Usuario;
import com.ejemplo.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{documentoIdentidad}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable String documentoIdentidad) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(documentoIdentidad);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{documentoIdentidad}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String documentoIdentidad, @RequestBody Usuario usuario) {
        if (!usuarioService.getUsuarioById(documentoIdentidad).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuario.setDocumentoIdentidad(documentoIdentidad);
        Usuario updatedUsuario = usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{documentoIdentidad}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String documentoIdentidad) {
        if (!usuarioService.getUsuarioById(documentoIdentidad).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteUsuario(documentoIdentidad);
        return ResponseEntity.noContent().build();
    }
}
