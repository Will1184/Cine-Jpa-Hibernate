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
@Table(name = "directores")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodDirector")
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "FNacimiento")
    private LocalDateTime fechaNacimiento;
    @Column(name = "LNacimiento")
    private String lugarNacimiento;

    private String nacionalidad;

    @Column(name = "FMuerte")
    private LocalDateTime fechaMuerte;
    @Column(name = "LMuerte")
    private String lugarMuerte;
}
