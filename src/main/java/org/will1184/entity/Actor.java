package org.will1184.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actores")

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodActor")
    private Integer id;

    @Column(nullable = false,name = "Nombre")
    private String nombre;

    @Column(name = "FNacimiento")
    private LocalDateTime fechaNacimiento;
    @Column(name = "LNacimiento")
    private String lugarNacimiento;

    @Column(name = "Nacionalidad")
    private String nacionalidad;

    @Column(name = "FMuerte")
    private LocalDateTime fechaMuerte;
    @Column(name = "LMuerte")
    private String lugarMuerte;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Participas",
            joinColumns = @JoinColumn(name = "CodActor"),
            inverseJoinColumns = @JoinColumn(name = "CodPelicula"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"CodPelicula", "CodActor"})
    )
    private  Pelicula pelicula;

}
