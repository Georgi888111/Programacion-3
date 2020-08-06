/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Escuela {
    private int numero;
    private String denominacion;
    private ArrayList<DivisionCurso>divisiones = new ArrayList();

    public Escuela(int numero, String denominacion) {
        this.numero = numero;
        this.denominacion = denominacion;
    }

    public Escuela() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public ArrayList<DivisionCurso> getDivisiones() {
        return divisiones;
    }

    public void setDivisiones(ArrayList<DivisionCurso> divisiones) {
        this.divisiones = divisiones;
    }
    
    
    
}
