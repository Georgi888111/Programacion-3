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
public class Expediente {

    private String letra;
    private int numero;
    private String descripcion;
    private String tipo;
    private String ambito;
    private ArrayList<EstadoControl> estados= new ArrayList();
    private ArrayList<Control> controles= new ArrayList();
    private Expediente expediente;
    private ArrayList<Expediente> expedientes= new ArrayList();
    
    
  public void addControl(Control control){
      this.controles.add(control);
  }  
  
  public void addEstadoControl(EstadoControl estado){
      this.estados.add(estado);
  }
  
  public void addExpediente(Expediente expediente){
      this.expedientes.add(expediente);
  }

    public ArrayList<EstadoControl> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<EstadoControl> estados) {
        this.estados = estados;
    }

    public ArrayList<Control> getControles() {
        return controles;
    }

    public void setControles(ArrayList<Control> controles) {
        this.controles = controles;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public ArrayList<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ArrayList<Expediente> expedientes) {
        this.expedientes = expedientes;
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

    public String getCaratulaExpediente(int numero) {
        String caratula = "";
      
            if (numero == this.getNumero()) {
                caratula = "N° " + this.getNumero() + " - " + this.getLetra() + " - " + this.getDescripcion();
            }
        
        return caratula;
    }

    public String getControlesObligatorios() {
        String cadena = "";
        for (Control ctrl : this.controles) {
            if (ctrl.isEsObligatorio() == true) {
                cadena += ctrl.getDenominacion() + ",";

            }
        }
        return cadena;
    }

    public boolean getEstadoControles() {
        boolean verifica = false;
        for (EstadoControl estado : estados) {
            if (estado.isAprobado() == false) {
                verifica = false;
                break;
            }

        }
        verifica = true;
        return verifica;
    }

    public ArrayList<Expediente> listaExpedientes() {
        ArrayList<Expediente> exp = new ArrayList();
        if (exp == null) {
            System.out.println("El expediente esta vacio");
            return null;
        } else {
            return retornaExpediente(this, exp);
        }

    }

    private ArrayList<Expediente> retornaExpediente(Expediente expediente, ArrayList<Expediente> exp) {
        exp.add(expediente);
        if (expediente.getExpedientes() != null) {
            for (Expediente expediente1 : expediente.getExpedientes()) {
                retornaExpediente(expediente1, exp);
            }

        }
        return exp;
    }

}
