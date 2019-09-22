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
public class Expediente {

    private String letra;
    private int numero;
    private String descripcion;
    private String tipo;
    private String ambito;
    private ArrayList<Control> controles = new ArrayList();
    private ArrayList<EstadoControl> estadosControles = new ArrayList();
    private Expediente expediente;
    private ArrayList<Expediente> expedientes = new ArrayList();

    public void addExpediente(Expediente expediente) {
        expedientes.add(expediente);
    }

    public void addEstadoControl(EstadoControl estadoCon) {
        estadosControles.add(estadoCon);
    }

    public void addControl(Control control) {
        controles.add(control);
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getCaratulaExpediente() {

        String caratula = " " + this.numero + "-" + this.letra + "-" + this.descripcion;
        return caratula;

    }

    public Expediente getExpediente() {
        return expediente;
    }

    public ArrayList<Expediente> getExpedientes() {
        return expedientes;
    }

    public String getControlesObligatorios() {
        String cadena = "";
        for (int i = 0; i < controles.size(); i++) {
            if (controles.get(i).isEsObligatorio()) {
                cadena += controles.get(i).getDenominacion() + ",";
            }
        }
        return cadena;
    }

    public boolean getEstadoControles() {

        for (int i = 0; i < controles.size(); i++) {
            if (controles.get(i).isEsObligatorio()) {
                if (!controles.get(i).getEstadosControl().get(i).isAprobado()) {
                    return false;

                }

            }

        }
        return true;
    }

    public ArrayList<Expediente> listaExpedientes() {
        ArrayList<Expediente> expedientesNuevos = new ArrayList();
        if (this.expedientes != null) {
            return this.verificaHijos(this, expedientesNuevos);
        } else {
            System.out.println("El expediente esta vacio");

            return null;
        }
    }

    private ArrayList<Expediente> verificaHijos(Expediente expediente, ArrayList<Expediente> expedientesNuevos) {

        expedientesNuevos.add(expediente);
        if (expediente.getExpedientes() != null) {
            for (Expediente exp : expediente.getExpedientes()) {

                verificaHijos(exp, expedientesNuevos);
            }
        }
        return expedientesNuevos;
    }

    /*  private void recorreExpedientes(Expediente e) {

        if (e.getExpedientes() != null) {
            for (Expediente exp : e.getExpedientes()) {
                this.expedientes.add(e);
                recorreExpedientes(exp);
            }
        }
    }*/
}
