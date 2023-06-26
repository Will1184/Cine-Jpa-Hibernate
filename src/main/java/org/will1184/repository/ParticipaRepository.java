package org.will1184.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.will1184.entity.Participa;


import java.util.List;

public class ParticipaRepository implements CrudRepository<Participa>, FindIdRepository<Participa> {

    private final EntityManager manager;

    public ParticipaRepository(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public List<Participa> listar() {
        return manager.createQuery("SELECT p FROM Participa p", Participa.class).getResultList();
    }

    @Override
    public Participa porId(Integer id) {
        return manager.find(Participa.class,id);
    }


    @Override
    public void guardar(Participa participa) {
        if (participa.getPelicula()!=null && participa.getActor()!=null){
            manager.merge(participa);
        }else {
            manager.persist(participa);
        }
    }

    @Override
    public void editar(Integer id) {

    }

    @Override
    public void eliminar(Integer id) {
        Participa participa = porId(id);
        manager.remove(participa);
    }


    @Override
    public List<Participa> listarId(Integer id,TipoBusqueda busqueda) {
        TypedQuery query;
        if (busqueda == TipoBusqueda.POR_ACTOR) {
            System.out.println("=====BUSQUEDA DE PARTICIPA POR ID ACTOR====");
            query = manager.createQuery(
                    "SELECT pa FROM Participa pa INNER JOIN" +
                            " pa.pelicula p WHERE pa.actor.id = :id",
                    Participa.class
            );
        } else if (busqueda == TipoBusqueda.POR_PELICULA) {
            System.out.println("=====BUSQUEDA DE PARTICIPA POR ID PELICULA====");
            query = manager.createQuery(
                    "SELECT pa FROM Participa pa INNER JOIN" +
                            " pa.actor p WHERE pa.pelicula.id = :id",
                    Participa.class
            );
        } else {
            throw new IllegalArgumentException("Tipo de búsqueda no válido");
        }
        query.setParameter("id",id);
        return query.getResultList();
    }
}
