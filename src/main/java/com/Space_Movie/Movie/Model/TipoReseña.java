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
@Table(name="TipoReseña")
public class TipoReseña {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Tipo_Reseña", nullable = false) 
    private String Tiporeseña;

    @ManyToOne 
    @JoinColumn(name ="Reseña" , nullable = false)
    private Reseña reseña;

    

}