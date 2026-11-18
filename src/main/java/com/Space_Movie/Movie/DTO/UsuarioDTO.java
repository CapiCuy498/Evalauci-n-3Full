package com.Space_Movie.Movie.DTO;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer id;
    private String nombre;
    private String correo;
    // Solo se usa al crear/actualizar; nunca se devuelve en las respuestas
    private String password;
    private Integer tipoUsuarioId;
}
