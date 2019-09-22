/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expediente;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Control {

    private String denominacion;
    private boolean esObligatorio;
    private ArrayList<Expediente> expedientes= new ArrayList();
    private ArrayList<EstadoControl> estados= new ArrayList();

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

    public ArrayList<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ArrayList<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    public ArrayList<EstadoControl> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<EstadoControl> estados) {
        this.estados = estados;
    }
    
    public void agregaExpediente(Expediente expediente){
        this.expedientes.add(expediente);
    }
    
    public void addEstadoControl(EstadoControl estado){
        this.estados.add(estado);
    }

}
