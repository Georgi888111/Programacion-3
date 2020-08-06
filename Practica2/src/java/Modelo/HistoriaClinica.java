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
//@Table(name = "HistoriaClinica")
public class HistoriaClinica {
    private int legajoPaciente;
    private String nombrePaciente;
    private LocalDate fechaNacimiento;
    private char sexo;
    private ArrayList<HistoriaClinicaDetalle>detalles = new ArrayList();

    public HistoriaClinica(int legajoPaciente, String nombrePaciente, LocalDate fechaNacimiento, char sexo) {
        this.legajoPaciente = legajoPaciente;
        this.nombrePaciente = nombrePaciente;
        this.fechaNacimiento = fechaNacimiento;
       
        this.sexo = sexo;
    }

    public HistoriaClinica() {
    }

 // @Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLegajoPaciente() {
        return legajoPaciente;
    }

    public void setLegajoPaciente(int legajoPaciente) {
        this.legajoPaciente = legajoPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
  //@Temporal(TemporalType.DATE)

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
 

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

     //@OneToMany(mappedBy = "historia", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public ArrayList<HistoriaClinicaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<HistoriaClinicaDetalle> detalles) {
        this.detalles = detalles;
    }
    
    public boolean emitirAlarmaAtencion(){
        boolean alarma = false;
        LocalDate fechaActual = LocalDate.now();
        LocalDate ultimaAtencion=detalles.get(0).getFechaAtencion();
        if(fechaActual.getYear() - fechaNacimiento.getYear()>50){
            for (HistoriaClinicaDetalle detalle : detalles) {
                if(detalle.getFechaAtencion().isAfter(ultimaAtencion)){
                    ultimaAtencion = detalle.getFechaAtencion();
                }
            }
            
            if(Math.abs(fechaActual.getMonthValue()-ultimaAtencion.getMonthValue())>6){
                for (HistoriaClinicaDetalle detalle : detalles) {
                    for (Sintomas sintoma : detalle.getSintomas()) {
                      if(sintoma.isAltoRiesgo()){
                          alarma=  true;
                      }  
                    }
                } 
            }
            }else{
            alarma= false;
        }
            return alarma;
        }
    
    
    
}