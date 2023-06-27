package org.will1184.service;

import org.will1184.entity.Participa;
import org.will1184.entity.Pelicula;
import org.will1184.repository.TipoBusqueda;

import javax.swing.text.html.Option;
import java.util.List;

public interface ParticipaService {
    List<Participa> listar();
    List listarPorId(Integer id, TipoBusqueda busqueda);
    void porId(Integer id, TipoBusqueda busqueda);
    void guardar(Participa participa);
    void editar(Integer id,TipoBusqueda tipoBusqueda);
    void eliminar(Integer id);
    void eliminarUnique(Integer id1,Integer id2);
}
