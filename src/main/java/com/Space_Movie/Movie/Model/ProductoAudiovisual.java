package com.Space_Movie.Movie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Producto_Audiovisual")
public class ProductoAudiovisual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "poster", nullable = false)
    private String poster;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "sinopsis", nullable = false)
    private String sinopsis;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "valoracion", nullable = false)
    private String valoracion;

    @ManyToOne
    @JoinColumn(name = "equipo_direccion_id", nullable = false)
    private Equipo_Direccion equipoDireccion;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}