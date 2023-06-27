package org.will1184.service;

import jakarta.persistence.EntityManager;
import org.will1184.entity.Participa;
import org.will1184.exception.DataException;
import org.will1184.repository.CrudRepository;
import org.will1184.repository.FindIdRepository;
import org.will1184.repository.ParticipaRepository;
import org.will1184.repository.TipoBusqueda;

import java.util.List;

public class ParticipaServiceImpl implements ParticipaService{
    private final EntityManager manager;
    private CrudRepository<Participa> repository;
    private FindIdRepository idRepository;

    public ParticipaServiceImpl(EntityManager manager) {
        this.manager = manager;
        this.repository = new ParticipaRepository(manager);
        this.idRepository = new ParticipaRepository(manager);
    }

    @Override
    public List<Participa> listar() {
        System.out.println("=====lISTAR PARTICIPA====");
        return repository.listar();
    }

    @Override
    public List listarPorId(Integer id, TipoBusqueda busqueda) {
        try {
            return idRepository.listarPorId(id,busqueda);
        }catch (Exception e){
            e.printStackTrace();
            throw new DataException("Datos introducidos son invalidos");
        }
    }

    @Override
    public void porId(Integer id, TipoBusqueda busqueda){

    }


    @Override
    public void guardar(Participa participa) {

        try {
            System.out.println("=====GUARDAR PARTICIPA====");
            manager.getTransaction().begin();
            repository.guardar(participa);
            manager.getTransaction().commit();
//            System.out.println("=====PARTICIPA GUARDADO====");
        }catch (Exception e){
//            System.out.println("=====PARTICIPA NO GUARDADO====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id, TipoBusqueda tipoBusqueda) {

    }

    @Override
    public void eliminar(Integer id) {
        try {
            System.out.println("=====ELIMINAR PARTICIPA====");
            manager.getTransaction().begin();
            repository.eliminar(id);
            manager.getTransaction().commit();
//            System.out.println("=====PARTICIPA ELIMINADO====");
        }catch (Exception e){
//            System.out.println("=====PARTICIPA NO ELIMINADO====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarUnique(Integer id1, Integer id2) {
        try {
            System.out.println("=====ELIMINAR ACTOR EN PELICULA====");
            manager.getTransaction().begin();
            idRepository.eliminarUnique(id1,id2);
            manager.getTransaction().commit();
//            System.out.println("=====PARTICIPA ELIMINADO====");
        }catch (Exception e){
//            System.out.println("=====PARTICIPA NO ELIMINADO====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
