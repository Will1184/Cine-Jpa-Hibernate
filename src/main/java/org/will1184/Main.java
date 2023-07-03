package org.will1184;

import jakarta.persistence.EntityManager;
import org.will1184.entity.*;
import org.will1184.repository.Pais;
import org.will1184.repository.PeliculaRepository;
import org.will1184.repository.TipoBusqueda;
import org.will1184.repository.TipoMoneda;
import org.will1184.service.*;
import org.will1184.util.JpaUtil;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        EntityManager manager= JpaUtil.getEntityManager();

        ActorService actorService = new ActorServiceImpl(manager);
        Actor actor = new Actor();
        actor=actor();
        actorService.guardar(actor);
        List<Actor> actorList=actorService.listar();
        actorList.forEach(System.out::println);

        PeliculaService peliculaService= new PeliculaServiceImpl(manager);
        List<Pelicula> peliculaList = peliculaService.listar();
        peliculaList.forEach(System.out::println);
        Integer id=6;
        Pelicula pelicula= peliculaService.porId(id);

        ParticipaService participaService= new ParticipaServiceImpl(manager);
        Participa participa= new Participa();
        participa.setActor(actor);
        participa.setPelicula(pelicula);
        participaService.guardar(participa);
        List<Participa> participaList=new ArrayList<>();
        participaList=participaService.listarPorId(6,TipoBusqueda.POR_PELICULA);
        participaList.forEach(System.out::println);

        peliculaService.cambiarMonedaPorPais(Pais.EEUU, TipoMoneda.EURO);
        peliculaList = peliculaService.listar();
        peliculaList.forEach(System.out::println);
        System.out.println("Distribuidora de casablanca es: "+peliculaService.distribuidora("Casablanca"));

        actorList= actorService.actorListDeadPorNacion("Suecia");
        actorList.forEach(actor1 ->System.out.println("Nombre: "+actor1.getNombre()
                +" Nacionalidad: "+actor1.getNacionalidad()
                +" Fecha de muerte: "+actor1.getFechaMuerte())
        );

        List<Object[]> resultados =peliculaService.recaudacionPeliculasNacion("España");
        resultados.forEach(objects -> {
            String nacionalidad = (String) objects[0];
            double recaudacion = (double) objects[1];
            System.out.println("Nacionalidad: " + nacionalidad + ", Recaudacion: " + BigDecimal.valueOf(recaudacion));
        });

        participaList=participaService.listarPorId(10,TipoBusqueda.POR_PELICULA);
        participaList.forEach(participa1 ->
                System.out.println("Nombre: "+participa1.getActor().getNombre()
                        +" Lugar de nacimiento: "+participa1.getActor().getLugarNacimiento())
        );

//        resultados = peliculaService.peliculaPorNacion("España");
//        for (Object[] resultado : resultados) {
//            String nacionalidad = (String) resultado[0];
//            Long cantidadPeliculas = (Long) resultado[1];
//            System.out.println("Nacionalidad: " + nacionalidad + ", Cantidad de películas: " + cantidadPeliculas);
//        }
        resultados = peliculaService.peliculaPorNacion();
        resultados.forEach(objects -> {
            String nacionalidad = (String) objects[0];
            Long cantidadPeliculas = (Long) objects[1];
            System.out.println("Nacionalidad: " + nacionalidad + ", Cantidad de películas: " + cantidadPeliculas);
        });

        resultados=peliculaService.peliculaConcatenandoAnyo("España");
        resultados.forEach(objects -> {
            String titulo = (String) objects[0];
            String anyo = (String) objects[1];
            String tituloConcat = (String) objects[2];
            String nacionalidad = (String) objects[3];
            System.out.println("Titulo: " + titulo + " Anyo: " + anyo+" Titulo Concatenado: "+tituloConcat+" Nacionalidad: "+nacionalidad);
        });

        resultados=participaService.actorMayorParticipacion();
        resultados.forEach(objects -> {
            Actor actor1 = (Actor) objects[0];
            Long cantidad = (Long) objects[1];
            System.out.println("Actor: " + actor1.getNombre()+" nacionalidad: " +actor1.getNacionalidad()+ " Cantidad: " + cantidad);
        });

        DirectorService directorService= new DirectorServiceImpl(manager);
        Long dir=2L;
        resultados=directorService.directorParticipaciones(dir);
        resultados.forEach(objects -> {
            Director director = (Director) objects[0];
            Long cantidad = (Long) objects[1];
            System.out.println("Id: "+director.getId()+" Director: " + director.getNombre()+" nacionalidad: " +director.getNacionalidad()+ " Cantidad: " + cantidad);
        });

        List<Director> directores= directorService.directorSinParticipaciones();
        directores.forEach(director -> {
            System.out.println("Nombre: "+director.getNombre()+" Nacionalidad: "+director.getNacionalidad());
        });



        manager.close();

    }
    public static Actor actor(){

        Actor actor= new Actor();
        actor.setNombre("Brandon");
        actor.setNacionalidad("Salvadorenia");
        LocalDate.of(2003,1,17);
        actor.setFechaNacimiento(LocalDateTime.of(LocalDate.of(2003,1,17), LocalTime.MIDNIGHT));
        actor.setLugarNacimiento("San salvador, el salvador");

        return actor;
    }
}