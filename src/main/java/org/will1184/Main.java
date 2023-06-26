package org.will1184;

import jakarta.persistence.EntityManager;
import org.will1184.entity.*;
import org.will1184.repository.PeliculaRepository;
import org.will1184.repository.TipoBusqueda;
import org.will1184.service.*;
import org.will1184.util.JpaUtil;

import javax.swing.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManager manager= JpaUtil.getEntityManager();
        DirectorService service = new DirectorServiceImpl(manager);

        Director director = new Director();
        director.setNombre("George");
        service.guardar(director);
        List<Director> directorList = service.listar();
        directorList.forEach(System.out::println);
//        Integer id= Integer.valueOf(JOptionPane.showInputDialog("Ingrese Id a buscar"));
//        service.porId(id);

        PeliculaService serviceP = new PeliculaServiceImpl(manager);


        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Star Wars: A new hope");
        pelicula.setAnyo("1977");
        pelicula.setGenero(genero(manager));
        pelicula.setDirector(director);
        serviceP.guardar(pelicula);

        pelicula = new Pelicula();
        pelicula.setTitulo("Star Wars: Revenge of the sith");
        pelicula.setAnyo("2003");
        pelicula.setGenero(genero(manager));
        pelicula.setDirector(director);
        serviceP.guardar(pelicula);

        List<Pelicula> list = serviceP.listar();
        list.forEach(System.out::println);

        ParticipaService servicePa = new ParticipaServiceImpl(manager);
        Participa participa = new Participa();

        ActorService serviceA = new ActorServiceImpl(manager);
        Actor actor = new Actor();
        actor.setNombre("Ben");
        serviceA.guardar(actor);
        participa.setActor(actor);
        participa.setPelicula(pelicula);
        servicePa.guardar(participa);


        actor= new Actor();
        actor.setNombre("Heyden");
        serviceA.guardar(actor);
        List<Actor> listA = serviceA.listar();
        listA.forEach(System.out::println);

        participa.setActor(actor);
        participa.setPelicula(pelicula);
        servicePa.guardar(participa);

        Pelicula peliculaa = new Pelicula();
        peliculaa.setTitulo("Jumper");
        peliculaa.setAnyo("2008");
        peliculaa.setGenero(genero(manager));
        peliculaa.setDirector(pelicula.getDirector());
        serviceP.guardar(peliculaa);
        participa.setActor(actor);
        participa.setPelicula(peliculaa);
        servicePa.guardar(participa);




        List<Participa> listPar=servicePa.listar();
        listPar.forEach(System.out::println);
        List<Participa> participaList = servicePa.porId(actor.getId(),TipoBusqueda.POR_ACTOR);
        participaList.forEach(System.out::println);

        participaList = servicePa.porId(pelicula.getId(), TipoBusqueda.POR_PELICULA);
        participaList.forEach(System.out::println);

        manager.close();

    }

    public static Genero genero (EntityManager manager){
        GeneroService service = new GeneroServiceImpl(manager);
        Genero genero = new Genero();
        genero.setGenero("Ciencia-Ficcion");
        service.guardar(genero);
        return genero;
    }

}