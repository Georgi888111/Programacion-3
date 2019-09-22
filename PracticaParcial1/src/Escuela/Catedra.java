/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Catedra {

    private int codigo;
    private String denominacion;
    private DivisionCurso divisionCurso;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Nota> notas;

    public Catedra(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public void addAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public void addNota(Nota nota) {
        this.notas.add(nota);
    }

    public void inicializaAlumno() {
        this.alumnos = new ArrayList();
    }

    public void inicializaNota() {
        notas = new ArrayList();
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
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

    public DivisionCurso getDivisionCurso() {
        return divisionCurso;
    }

    public void setDivisionCurso(DivisionCurso divisionCurso) {
        this.divisionCurso = divisionCurso;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
public Alumno mejorAlumnoCatedra(){
Alumno alumno = new Alumno();
alumno.setNotas(notas);
double mejorProme=0;
    for (Alumno alu : alumnos) {
     if(alu.promedioNotas(this.codigo)>alumno.promedioNotas(this.codigo))  {
      mejorProme = alu.promedioNotas(codigo);
      alumno=alu;
     } 
    }
    return alumno;
}
}