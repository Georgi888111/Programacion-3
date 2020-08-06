/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name = "Control")
public class Control implements Serializable{
    
 private int id;
 private String denominacion;
 private boolean esObligatorio;
 private ArrayList<Expediente> expedientes =  new ArrayList();
 private ArrayList<EstadoControl>estadosControles = new ArrayList();

 
    @ManyToMany(mappedBy = "controles", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public ArrayList<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ArrayList<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    @OneToMany(mappedBy = "control", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public ArrayList<EstadoControl> getEstadosControles() {
        return estadosControles;
    }

    public void setEstadosControles(ArrayList<EstadoControl> estadosControles) {
        this.estadosControles = estadosControles;
    }
 

 
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY) 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public boolean isEsObligatorio() {
        return esObligatorio;
    }

    public void setEsObligatorio(boolean esObligatorio) {
        this.esObligatorio = esObligatorio;
    }
 
 
 
}
