package org.will1184.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "peliculas")

public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodPelicula")
    private Integer id;

    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String anyo;

    private String nacionalidad;
    private Float duracion;
    private LocalDateTime fechaEstreno;
    @OneToOne
    @JoinColumn(name = "genero")
    private Genero genero;

    private Double taquilla;
    private String productora;
    private String Distribuidora;

    @OneToOne
    @JoinColumn(name = "director")
    private  Director director;
}
