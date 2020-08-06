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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name = "Profesor")
public class Profesor extends Persona implements Serializable{
    
    private String titulo;
    private List<Materia> materias = new ArrayList<>();
    private int id;

    public Profesor() {
    }
    
    
    

    public Profesor(String titulo, int dni, String domicilio, String nombre, String Date) {
        super(dni, domicilio, nombre, Date);
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @OneToMany(mappedBy = "profesor",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    
    
}
