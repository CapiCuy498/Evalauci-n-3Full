package com.Space_Movie.Movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Space_Movie.Movie.DTO.UsuarioDTO;
import com.Space_Movie.Movie.Model.TipoUsuario;
import com.Space_Movie.Movie.Model.Usuario;
import com.Space_Movie.Movie.Repository.TipoUsuarioRepository;
import com.Space_Movie.Movie.Repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@Slf4j
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;


    public List<UsuarioDTO> obtenerUsuarios() {
        log.info("Obteniendo todos los usuarios");
        return usuarioRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public UsuarioDTO obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(this::convertirADTO)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con la ID: " + id));
    }

    @Transactional
    public UsuarioDTO guardarUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setCorreo(dto.getCorreo());
        usuario.setPassword(dto.getPassword()); // TODO: hashear antes de guardar
        usuario.setTipoUsuario(buscarTipoUsuario(dto.getTipoUsuarioId()));

        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        log.info("Nuevo usuario guardado exitosamente con ID: {}", nuevoUsuario.getId());
        return convertirADTO(nuevoUsuario);
    }

    @Transactional
    public UsuarioDTO actualizarUsuario(Integer id, UsuarioDTO dto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con la ID: " + id));

        usuarioExistente.setNombre(dto.getNombre());
        usuarioExistente.setCorreo(dto.getCorreo());
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuarioExistente.setPassword(dto.getPassword()); // TODO: hashear antes de guardar
        }
        usuarioExistente.setTipoUsuario(buscarTipoUsuario(dto.getTipoUsuarioId()));

        Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);
        log.info("Usuario con ID: {} actualizado", id);
        return convertirADTO(usuarioActualizado);
    }

    @Transactional
    public void eliminarUsuario(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con la ID: " + id);
        }
        usuarioRepository.deleteById(id);
        log.info("Usuario con ID: {} ha sido eliminado exitosamente", id);
    }

    private TipoUsuario buscarTipoUsuario(Integer id) {
        if (id == null) {
            throw new RuntimeException("El tipo de usuario es obligatorio");
        }
        return tipoUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de usuario no encontrado con la ID: " + id));
    }

    private UsuarioDTO convertirADTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setCorreo(usuario.getCorreo());
        // La contraseña nunca se expone en las respuestas
        dto.setTipoUsuarioId(usuario.getTipoUsuario() != null ? usuario.getTipoUsuario().getId() : null);
        return dto;
    }
}
