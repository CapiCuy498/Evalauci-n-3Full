package com.Space_Movie.Movie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor 
@Entity
@Data
@Table(name="Reseña")
public class Reseña {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "Nombre", nullable = false)
    private String Nombre;

    @Column(name = "Contenido_Reseña")
    private String ContenidoReseña; 
}
