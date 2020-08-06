/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Data.Conexion;
import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Alumno {
    
    private int legajo;
    private String nombre;
    private String apellido;
    private Conexion conexion;

    public Alumno() {
        this.conexion = new Conexion();
    }
    
    
    

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public ArrayList<Alumno> traeAlumnos(int idCatedra){
        ArrayList<Alumno> alumnos = new ArrayList();   
        alumnos = conexion.traeAlumnos(idCatedra);
        return alumnos;
    }
    
}
