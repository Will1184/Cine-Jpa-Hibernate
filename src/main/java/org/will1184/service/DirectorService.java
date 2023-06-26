package org.will1184.service;

import org.will1184.entity.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    List<Director> listar();
    Optional<Director> porId(Integer id);
    void guardar(Director director);
    void editar(Integer id);
    void eliminar(Integer id);
}
