/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Georgi
 */
public class Nota {
    private int id;
    private double valor;
    private Date fechaExamen;
    private boolean esRecuperatorio;
    private Alumno alumno;
    private Catedra catedra;

    public Nota(int id, double valor, Date fechaExamen, boolean esRecuperatorio, Alumno alumno, Catedra catedra) {
        this.id = id;
        this.valor = valor;
        this.fechaExamen = fechaExamen;
        this.esRecuperatorio = esRecuperatorio;
        this.alumno = alumno;
        this.catedra = catedra;
    }

    public Nota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public boolean isEsRecuperatorio() {
        return esRecuperatorio;
    }

    public void setEsRecuperatorio(boolean esRecuperatorio) {
        this.esRecuperatorio = esRecuperatorio;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Catedra getCatedra() {
        return catedra;
    }

    public void setCatedra(Catedra catedra) {
        this.catedra = catedra;
    }
    
    
}