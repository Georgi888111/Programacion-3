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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name="Especialidad")
public class Especialidad implements Serializable{
    
    
    private int idEspecialidad;
    private String denominacion;
    private List<Medico>medicos;

    public Especialidad() {
    }
    
    
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "EspecialidadMedico", joinColumns = {@JoinColumn(name="id_Especialidad")}, inverseJoinColumns = {@JoinColumn(name="id_medico")})
    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
    
    
    
    
}
