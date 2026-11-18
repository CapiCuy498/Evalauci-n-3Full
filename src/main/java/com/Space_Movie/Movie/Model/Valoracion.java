package com.Space_Movie.Movie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "Valoracion")
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "La puntuación no puede estar vacía")
    @Min(value = 1, message = "La valoración mínima es 1")
    @Max(value = 10, message = "La valoración máxima es 10")
    @Column(name = "puntuacion", nullable = false)
    private Integer puntuacion;
}