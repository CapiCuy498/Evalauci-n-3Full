package com.Space_Movie.Movie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @ManyToOne 
    @JoinColumn(name = "Usuario", nullable=false)
    private Usuario usuario; 

    @OneToOne
    @JoinColumn(name = "valoracion_id", nullable = false)
    private Valoracion valoracion;
}
