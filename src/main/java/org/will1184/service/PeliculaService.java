package org.will1184.service;

import org.will1184.entity.Pelicula;
import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> listar();
    Optional<Pelicula> porId(Integer id);
    void guardar(Pelicula pelicula);
    void editar(Integer id);
    void eliminar(Integer id);
}
