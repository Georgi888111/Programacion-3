/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;

import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name="Empleado")

public class Empleado extends Persona implements Serializable{
 private int idEmpleado;
 private int nroLegajo;
 private double sueldo;

    public Empleado() {
    }

 
 
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
 
 
 
}
