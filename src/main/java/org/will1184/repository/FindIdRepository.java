package org.will1184.repository;

import org.will1184.entity.Participa;

import java.util.List;

public interface FindIdRepository <T>{
    List<T> listarId(Integer id,TipoBusqueda tipo);

}
