package org.will1184.repository;

import jakarta.persistence.EntityManager;
import org.will1184.entity.Director;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DirectorRepository implements CrudRepository<Director>{
    private final EntityManager manager;

    public DirectorRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Director> listar() {
        return manager.createQuery("SELECT d FROM Director d",Director.class).getResultList();
    }

    @Override
    public Director porId(Integer id) {
        return manager.find(Director.class,id);
    }

    @Override
    public void guardar(Director director) {
        if (director.getId()!=null && director.getId()>0){
            manager.merge(director);
        }else {
            manager.persist(director);
        }
    }


    @Override
    public void editar(Integer id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Director director= porId(id);
        if(director.getId()!=null && director.getId()>0){
                director.setNombre(JOptionPane.showInputDialog("Ingrese el nombre: ",director.getNombre()));
                director.setNacionalidad(JOptionPane.showInputDialog("Ingrese la nacionalidad: ",director.getNacionalidad()));
                String fechaDeNacimientoInput = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (yyyy/MM/dd):",director.getFechaNacimiento());
                director.setLugarNacimiento(JOptionPane.showInputDialog("Ingrese el lugar de nacimiento: ",director.getLugarNacimiento()));
                String fechaDefuncionInput = JOptionPane.showInputDialog("Ingrese la fecha de defuncion (yyyy/MM/dd):",director.getFechaMuerte());
                if (!fechaDefuncionInput.isEmpty()){
                    LocalDate fechaDefuncion = LocalDate.parse(fechaDefuncionInput, formatter);
                    director.setFechaMuerte(fechaDefuncion.atStartOfDay());
                }
                if (!fechaDeNacimientoInput.isEmpty()){
                    LocalDate fechaDeNacimiento = LocalDate.parse(fechaDeNacimientoInput, formatter);
                    director.setFechaNacimiento(fechaDeNacimiento.atStartOfDay());
                }
                director.setLugarMuerte(JOptionPane.showInputDialog("Ingrese el lugar de fallecimiento: ",director.getLugarMuerte()));
                manager.merge(director);
        }
    }

    @Override
    public void eliminar(Integer id) {
        Director director = porId(id);
        manager.remove(director);
    }
}
