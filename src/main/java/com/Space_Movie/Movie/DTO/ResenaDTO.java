package com.Space_Movie.Movie.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResenaDTO {

    private Integer id;
    private String contenido;
    private LocalDateTime fechaCreacion;
    private Integer usuarioId;
    private Integer productoId;
    private Integer tipoResenaId;
    private Integer valoracionId;
}
