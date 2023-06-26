package org.will1184.service;

import org.will1184.entity.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {
    List<Actor> listar();
    Optional<Actor> porId(Integer id);
    void guardar(Actor actor);
    void editar(Integer id);
    void eliminar(Integer id);
}
