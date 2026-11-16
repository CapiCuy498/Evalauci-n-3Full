package com.Space_Movie.Movie.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="Valoracion")
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message = "La puntuacion no puede estar vacia")
    @Min(value = 0 ,message = "La valoracion no puede tener valor negativos" )
    @Max (value = 10,message = "La valoracion no puede superar un valor por encima de 10")  
    @Column(name = "Puntuacion_Valoracio" ,nullable = false)
    private int Puntuacion_Valoracio; 

    @OneToOne(mappedBy = "valoracion")
    private Reseña resena;
}
