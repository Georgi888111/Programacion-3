/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name = "Alumnos")
public class Alumno extends Persona implements Serializable{
    
    private int legajo;
    private List<Materia>materias = new ArrayList<>();
    private List<Carrera>carreras = new ArrayList<>();
    private int id;

    public Alumno(int legajo, int dni, String domicilio, String nombre, String Date) {
        super(dni, domicilio, nombre, Date);
        this.legajo = legajo;
    }

    public Alumno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

  @OneToMany(mappedBy = "alumno",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
 @OneToMany(mappedBy = "alumno",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    
    
    
    
    
}
