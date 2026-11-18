package com.Space_Movie.Movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Space_Movie.Movie.DTO.CategoriaDTO;
import com.Space_Movie.Movie.Model.Categoria;
import com.Space_Movie.Movie.Repository.CategoriaRepository;

import lombok.extern.slf4j.Slf4j;

@Service 
@Transactional 
@Slf4j 

public class CategoriaService {

    @Autowired
    private  CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> obtenerCategoria() {
        log.info("Obteniendo todas las categorías");
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(this::convertirADTO).toList();
    }

    public CategoriaDTO obtenerCategoriaPorId(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con la ID: " + id));
        return convertirADTO(categoria);
    }

    public CategoriaDTO guardarCategoria(Categoria categoria) {
        Categoria nuevaCategoria = categoriaRepository.save(categoria);
        log.info("Nueva Categoría guardada exitosamente con ID: {}", nuevaCategoria.getId());
        return convertirADTO(nuevaCategoria); // <-- Retorna DTO
    }

    public CategoriaDTO actualizarCategoria(Integer id, Categoria categoriaDetalles) {
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con la ID: " + id));
        categoriaExistente.setNombre(categoriaDetalles.getNombre());

        Categoria categoriaActualizada = categoriaRepository.save(categoriaExistente);
        log.info("Categoría con ID: {} actualizada", id);
        return convertirADTO(categoriaActualizada);
    }

    public void eliminarCategoria(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede eliminar la Categoría, porque no existe"));
        
        categoriaRepository.delete(categoria);
        log.info("Categoría con ID: {} ha sido eliminada exitosamente", id);
    }

    private CategoriaDTO convertirADTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setCategoria(categoria.getNombre());
        return dto;
    }
}