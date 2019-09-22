/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Georgi
 */
public class Nota {
    private double valor;
    private LocalDate fechaExamen;
    private boolean esRecuperatorio;
    private Alumno alumno;
    private Catedra catedra;

    public Nota(double valor, LocalDate fechaExamen, boolean esRecuperatorio) {
        this.valor = valor;
        this.fechaExamen = fechaExamen;
        this.esRecuperatorio = esRecuperatorio;
    }

    public Nota() {
    }

    
    
    
    public LocalDate getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(LocalDate fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

   
    
    
    
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
