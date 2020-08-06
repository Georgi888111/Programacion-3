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
public class Catedra {
    private int codigo;
    private String denominacion;
    private DivisionCurso division;
    private ArrayList<Alumno> alumnos = new ArrayList();

    public Catedra() {
    }

    public Catedra(int codigo, String denominacion, DivisionCurso division) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.division = division;
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

    public DivisionCurso getDivision() {
        return division;
    }

    public void setDivision(DivisionCurso division) {
        this.division = division;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public Alumno mejorAlumnoCatedra(){
       
        Alumno mejorPromedio = new Alumno();
        for (Alumno alumno : alumnos) {
        if(mejorPromedio!=null || mejorPromedio.promedioNotas(this.codigo)<alumno.promedioNotas(this.codigo)){
            mejorPromedio = alumno;
         }
       
    }
     return mejorPromedio;
    
            
}
}
