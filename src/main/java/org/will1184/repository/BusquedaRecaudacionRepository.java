package org.will1184.repository;

import org.will1184.entity.Pelicula;

import java.util.List;

public interface BusquedaRecaudacionRepository {
     List<Object[]> recaudacionPeliculasNacion(String nacion);

}
