/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaC;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class TipoActividad {

    private int codigo;
    private String denominacion;
    private double puntosAsignados;
    private ArrayList<Actividad> actividades;

    
    
    
    public TipoActividad(int codigo, String denominacion, double puntosAsignados) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.puntosAsignados = puntosAsignados;
    }

   public void inicializaActividades() {
        actividades = new ArrayList();
    }

    public void addActividad(Actividad actividad) {
        this.actividades.add(actividad);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPuntosAsignados() {
        return puntosAsignados;
    }

    public void setPuntosAsignados(double puntosAsignados) {
        this.puntosAsignados = puntosAsignados;
    }

  
}
