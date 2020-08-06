/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Georgi
 */
//@Entity
//@Table(name = "HistoriaClinicaDetalle")
public class HistoriaClinicaDetalle {
    private long id;
 private String observacion;
 private LocalDate fechaAtencion;
 private ArrayList<Sintomas>sintomas = new ArrayList();
 private HistoriaClinica historia;

    public HistoriaClinicaDetalle(long id, String observacion, LocalDate fechaAtencion, HistoriaClinica historia) {
        this.id = id;
        this.observacion = observacion;
        this.fechaAtencion = fechaAtencion;
        this.historia = historia;
    }

    public HistoriaClinicaDetalle() {
    }
 // @Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
 //@Temporal(TemporalType.DATE)

    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(LocalDate fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
    

     //@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.LAZY)
    //@JoinTable(name = "HistoriaSintomas", joinColumns = {@JoinColumn(name="id_historia")}, inverseJoinColumns = {@JoinColumn(name="id_sintomas")})
    public ArrayList<Sintomas> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<Sintomas> sintomas) {
        this.sintomas = sintomas;
    }
 //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_Historia")
    public HistoriaClinica getHistoria() {
        return historia;
    }

    public void setHistoria(HistoriaClinica historia) {
        this.historia = historia;
    }
 
 
 
 
 
}
