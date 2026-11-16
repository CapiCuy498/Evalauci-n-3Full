package com.Space_Movie.Movie.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="Valoracion")
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "Puntuacion_Valoracio" ,nullable = false)
    private String Puntuacion_Valoracio; 

    @OneToOne(mappedBy = "valoracion")
private Reseña resena;
}
