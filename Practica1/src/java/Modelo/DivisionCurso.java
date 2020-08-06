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
public class DivisionCurso {
    private int codigo;
    private int anio;
    private int division;
    private Escuela escuela;
    private ArrayList<Catedra>catedras = new ArrayList();

    public DivisionCurso() {
    }

    
    
    public DivisionCurso(int codigo, int anio, int division, Escuela escuela) {
        this.codigo = codigo;
        this.anio = anio;
        this.division = division;
        this.escuela = escuela;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public ArrayList<Catedra> getCatedras() {
        return catedras;
    }

    public void setCatedras(ArrayList<Catedra> catedras) {
        this.catedras = catedras;
    }

    public Alumno mejorAlumnoDivisionCurso() {
        Alumno mejorAlumno = new Alumno();
        for (Catedra catedra : catedras) {
            for (Alumno alumno : catedra.getAlumnos()) {
                if (alumno.getNotas().size() >= 5 && alumno.notasSinRecuperar()) {

                    if (mejorAlumno.promedioNotas(null) < alumno.promedioNotas(null)) {
                        mejorAlumno = alumno;
                    }

                }
            }

        }

        return mejorAlumno;
    }

}
