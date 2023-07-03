package org.will1184.service;

import org.will1184.entity.Pelicula;
import org.will1184.repository.Pais;
import org.will1184.repository.TipoMoneda;

import java.util.List;

public interface PeliculaService {
    List<Pelicula> listar();
    Pelicula porId(Integer id);
    void guardar(Pelicula pelicula);
    void editar(Integer id);
    void eliminar(Integer id);
    void cambiarMonedaPorPais(Pais pais, TipoMoneda moneda);
     String distribuidora(String pelicula);
    List<Object[]> peliculaPorNacion(String nacion);
    List<Object[]> recaudacionPeliculasNacion(String nacion);
    List<Object[]> peliculaPorNacion();

    List<Object[]> peliculaConcatenandoAnyo();
    List<Object[]> peliculaConcatenandoAnyo(String pelicula);
}
