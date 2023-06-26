package org.will1184.repository;


import jakarta.persistence.EntityManager;
import org.will1184.entity.Director;
import org.will1184.entity.Pelicula;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PeliculaRepository implements CrudRepository<Pelicula>{

    private final EntityManager manager;

    public PeliculaRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Pelicula> listar() {
        return manager.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
    }

    @Override
    public Pelicula porId(Integer id) {
        return manager.find(Pelicula.class,id);
    }

    @Override
    public void guardar(Pelicula pelicula) {
        if (pelicula.getId()!=null && pelicula.getId()>0){
            manager.merge(pelicula);
        }else {
            manager.persist(pelicula);
        }
    }

    @Override
    public void editar(Integer id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Pelicula pelicula = porId(id);
        if (pelicula.getId() != null && pelicula.getId() > 0) {
            pelicula.setDistribuidora(JOptionPane.showInputDialog("Ingrese la distribuidora: ", pelicula.getDistribuidora()));
            pelicula.setNacionalidad(JOptionPane.showInputDialog("Ingrese la nacionalidad: ", pelicula.getNacionalidad()));
            String fechaDeEstrenoInput = JOptionPane.showInputDialog("Ingrese la fecha de estreno (yyyy/MM/dd):", pelicula.getFechaEstreno());
            if (!fechaDeEstrenoInput.isEmpty()) {
                LocalDate fechaDeEstreno = LocalDate.parse(fechaDeEstrenoInput, formatter);
                pelicula.setFechaEstreno(fechaDeEstreno.atStartOfDay());
            }
            pelicula.setAnyo(JOptionPane.showInputDialog("Ingrese la nacionalidad: ", pelicula.getAnyo()));
            pelicula.setDuracion(Float.valueOf(JOptionPane.showInputDialog("Ingrese la nacionalidad: ", pelicula.getDuracion())));
            pelicula.setTaquilla(Double.valueOf(JOptionPane.showInputDialog("Ingrese la nacionalidad: ", pelicula.getTaquilla())));
            pelicula.setProductora(JOptionPane.showInputDialog("Ingrese la nacionalidad: ", pelicula.getProductora()));
            pelicula.setDistribuidora(JOptionPane.showInputDialog("Ingrese la nacionalidad: ", pelicula.getDistribuidora()));

            manager.merge(pelicula);
        }
    }

    @Override
    public void eliminar(Integer id) {
        Pelicula pelicula = porId(id);
        manager.remove(pelicula);
    }
}
