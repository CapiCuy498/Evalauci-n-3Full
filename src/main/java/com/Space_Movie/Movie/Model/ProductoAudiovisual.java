package com.Space_Movie.Movie.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="Producto_Audiovisual")
public class ProductoAudiovisual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Poster", nullable = false)
    private String Poster;
    @Column(name = "Titulo", nullable = false)
    private String titulo;
    @Column(name = "Sinopsis", nullable = false)
    private String sinopsis;
    @Column(name = "Año", nullable = false)
    private int Año;
    @Column(name = "Valoracion", nullable = false)
    private String Valoracion;

    //esto es por ahora despues lo cambio 
    //@Column(name = "Equipo_Produccion", nullable = false)
    //@Column(name = "Equipo_Reparto", nullable = false)
    //@Column(name = "categoria", nullable = false)
    


}
