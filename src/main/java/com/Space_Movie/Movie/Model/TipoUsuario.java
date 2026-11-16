package com.Space_Movie.Movie.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor 
@AllArgsConstructor 
@Entity
@Data
@Table(name="Tipo_Usuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El tipo de cuenta no debe quedar vacia")
    @Column(name = "Tipo_Cuenta", nullable = false)
    private String Tipo_Cuenta;

    @OneToOne(mappedBy = "Tipo_Usuario")
    private Usuario usuario;

}