package com.Space_Movie.Movie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Producto_Audiovisual")
public class ProductoAudiovisual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El poster no debe de quedar vacio")
    @Column(name = "poster", nullable = false)
    private String poster;

    @NotBlank(message = "El titulo no debe de quedar vacio")
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @NotBlank(message = "La sinopsis no debe de quedar vacia")
    @Column(name = "sinopsis", nullable = false)
    private String sinopsis;

    @NotNull(message = "el año no debe quedar vacio")
    @Min(value = 1960 , message = "El año no debe de quedar por debajo de 1960") 
    @Column(name = "anio", nullable = false)
    private Integer anio;

    @Column(name = "valoracion", nullable = false)
    private String valoracion;

    @ManyToOne
    @JoinColumn(name = "equipo_direccion_id", nullable = false)
    private EquipoDireccion equipoDireccion;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}