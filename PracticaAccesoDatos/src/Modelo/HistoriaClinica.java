/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Georgi
 */
public class HistoriaClinica {
    private int legajo;
    private String fechaNacimiento;
    private String nombrePaciente;
    private boolean sexo;
    private ArrayList<DetalleHistoriaClinica>detalles = new ArrayList();

    public HistoriaClinica() {
    }

    public ArrayList<DetalleHistoriaClinica> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleHistoriaClinica> detalles) {
        this.detalles = detalles;
    }

    
    
    
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

   
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

   
    
    
}
