package org.will1184.service;

import jakarta.persistence.EntityManager;
import org.will1184.entity.Pelicula;
import org.will1184.repository.*;

import java.util.List;

public class PeliculaServiceImpl implements PeliculaService{
    private final EntityManager manager;
    private CrudRepository<Pelicula> repository;
    private CambioMonedaRepository monedaRepository;
    private BusquedaEnPeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(EntityManager manager) {
        this.manager = manager;
        this.repository= new PeliculaRepository(manager);
        this.monedaRepository= new PeliculaRepository(manager);
        this.peliculaRepository= new PeliculaRepository(manager);
    }

    @Override
    public List<Pelicula> listar() {
        System.out.println("=====lISTAR PELICULA====");
        return repository.listar();
    }

    @Override
    public Pelicula porId(Integer id) {
        System.out.println("=====BUSQUEDA DE PELICULA POR ID====");
        return repository.porId(id);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        try {
            System.out.println("=====GUARDAR PELICULA====");
            manager.getTransaction().begin();
            repository.guardar(pelicula);
            manager.getTransaction().commit();
//            System.out.println("=====PELICULA GUARDADO====");
        }catch (Exception e){
//            System.out.println("=====PELICULA NO GUARDADO====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Integer id) {
        try {
            System.out.println("=====EDITAR PELICULA====");
            manager.getTransaction().begin();
            repository.editar(id);
            manager.getTransaction().commit();
//            System.out.println("=====PELICULA EDITADA====");
        }catch (Exception e){
//            System.out.println("=====PELICULA NO EDITADA====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            System.out.println("=====ELIMINAR PELICULA====");
            manager.getTransaction().begin();
            repository.eliminar(id);
            manager.getTransaction().commit();
//            System.out.println("=====PELICULA ELIMINADA====");
        }catch (Exception e){
//            System.out.println("=====PELICULA NO ELIMINADA====");
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarMonedaPorPais(Pais pais, TipoMoneda moneda) {
        try {
            System.out.println("=====CAMBIO MONEDA====");
            manager.getTransaction().begin();
            monedaRepository.cambiarMonedaPorPais(pais,moneda);
            manager.getTransaction().commit();
        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public String distribuidora(String pelicula) {
      return peliculaRepository.distribuidora(pelicula);
    }

    @Override
    public List<Object[]> peliculaPorNacion() {
        return peliculaRepository.peliculaPorNacion();
    }
    @Override
    public List<Object[]> peliculaPorNacion(String nacion) {
        return peliculaRepository.peliculaPorNacion(nacion);
    }

    @Override
    public List<Object[]> recaudacionPeliculasNacion(String nacion) {
        return peliculaRepository.recaudacionPeliculasNacion(nacion);
    }

    @Override
    public List<Object[]> peliculaConcatenandoAnyo() {
        return peliculaRepository.peliculaConcatenandoAnyo();
    }
}
