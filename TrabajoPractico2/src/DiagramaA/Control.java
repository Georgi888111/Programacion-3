/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaA;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Control {
    
private String denominacion;
private boolean esObligatorio;
private ArrayList<Expediente>expedientes = new ArrayList();
private ArrayList<EstadoControl>estadosControl = new ArrayList();


public void agregaExpedientes(Expediente expediente){
    expedientes.add(expediente);
}

public void addEstadoCon(EstadoControl estado){
    estadosControl.add(estado);
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

    public ArrayList<EstadoControl> getEstadosControl() {
        return estadosControl;
    }




}
