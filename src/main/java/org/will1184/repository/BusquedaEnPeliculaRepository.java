package org.will1184.repository;

import org.will1184.entity.Pelicula;

import java.util.List;

public interface BusquedaEnPeliculaRepository extends BusquedaDistribuidoraRepository, BusquedaRecaudacionRepository {

     List<Object[]> peliculaPorNacion();

    List<Object[]> peliculaPorNacion(String nacionalidad);

    List<Object[]> peliculaConcatenandoAnyo();
    List<Object[]> peliculaConcatenandoAnyo(String nacion);
}
