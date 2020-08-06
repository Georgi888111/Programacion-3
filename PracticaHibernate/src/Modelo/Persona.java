/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@MappedSuperclass
@Table(name = "Personas")
public abstract class Persona implements Serializable{
    private int dni;
    private String domicilio;
    private String nombre;
    private String Date;
    private int id;

   

    public Persona() {
    }
    
    
    

    public Persona(int dni, String domicilio, String nombre, String Date) {
        this.dni = dni;
        this.domicilio = domicilio;
        this.nombre = nombre;
        this.Date = Date;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, insertable = false, updatable = false)
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    
    
}
