package org.will1184.service;

import org.will1184.entity.GanaPremio;

import java.util.List;
import java.util.Optional;

public interface GanaPremioService {
    List<GanaPremio> listar();
    Optional<GanaPremio> porId(Integer id);
    void guardar(GanaPremio premio);
    void editar(Integer id);
    void eliminar(Integer id);
}
