package org.will1184.service;

import org.will1184.entity.Participa;
import org.will1184.entity.Pelicula;
import org.will1184.repository.TipoBusqueda;

import javax.swing.text.html.Option;
import java.util.List;

public interface ParticipaService {
    List<Participa> listar();
    List<Participa> porId(Integer id, TipoBusqueda busqueda);
    void guardar(Participa participa);
    void editar(Integer id);
    void eliminar(Integer id);
}
