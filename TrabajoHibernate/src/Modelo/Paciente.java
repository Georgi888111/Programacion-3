/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name="Paciente")

public class Paciente extends Persona {

    private int idPaciente;
    private int nroSocio;
    private HistoriaClinica historia;

    public Paciente() {
    }
    
    
    

    @OneToMany(mappedBy = "paciente", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
    private List<Turno> turnos;

    @OneToOne(mappedBy = "paciente")
    public HistoriaClinica getHistoria() {
        return historia;
    }

    public void setHistoria(HistoriaClinica historia) {
        this.historia = historia;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

}
