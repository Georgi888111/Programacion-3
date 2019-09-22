/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import java.time.LocalDate;

/**
 *
 * @author Georgi
 */
public class Principal {

    public static void main(String[] args) {

        int dia = 29, mes = 11, anio = 1988;
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        Alumno alumno = new Alumno(12345, "Georgina", "Crespo", fecha);
        Alumno alumno1 = new Alumno(12765, "Mariana", "Flores", fecha);
        Alumno alumno2 = new Alumno(1975, "Emilia", "Coria", fecha);
        Alumno alumno3 = new Alumno(16675, "Marta", "Sanchez", fecha);
        Escuela escuela = new Escuela(1200, "Dalmacio Velez Sarsfield");
        DivisionCurso division = new DivisionCurso(100, 2, 1);
        DivisionCurso division1 = new DivisionCurso(101, 2, 2);
        DivisionCurso division2 = new DivisionCurso(102, 1, 2);
        DivisionCurso division3 = new DivisionCurso(103, 1, 1);
        Catedra catedra = new Catedra(100, "Lengua");
        Catedra catedra1 = new Catedra(101, "Matematica");
        Catedra catedra2 = new Catedra(102, "Historia");
        Catedra catedra3 = new Catedra(103, "Ciencias Naturales");
        Nota nota = new Nota(10, fecha, false);
        Nota nota1 = new Nota(7, fecha, true);
        Nota nota2 = new Nota(8, fecha, false);
        Nota nota3 = new Nota(9, fecha, true);

        escuela.inicializaDivisiones();
        escuela.addDivision(division);
        escuela.addDivision(division1);
        escuela.addDivision(division2);
        escuela.addDivision(division3);
        division.setEscuela(escuela);
        division1.setEscuela(escuela);
        division2.setEscuela(escuela);
        division3.setEscuela(escuela);
        division.inicializaCatedra();
        division.addCatedra(catedra);
        division.addCatedra(catedra1);
        division1.inicializaCatedra();
        division1.addCatedra(catedra);
        division1.addCatedra(catedra1);
        division2.inicializaCatedra();
        division2.addCatedra(catedra2);
        division2.addCatedra(catedra3);
        division3.inicializaCatedra();
        division3.addCatedra(catedra2);
        division3.addCatedra(catedra3);
        catedra.inicializaAlumno();
        catedra.addAlumno(alumno);
        catedra.addAlumno(alumno1);
        catedra.inicializaNota();
        catedra.addNota(nota);
        catedra.addNota(nota1);
        catedra1.inicializaAlumno();
        catedra1.addAlumno(alumno);
        catedra1.addAlumno(alumno1);
        catedra1.inicializaNota();
        catedra1.addNota(nota);
        catedra1.addNota(nota1);
        catedra2.inicializaAlumno();
        catedra2.addAlumno(alumno2);
        catedra2.addAlumno(alumno3);
        catedra2.inicializaNota();
        catedra2.addNota(nota2);
        catedra2.addNota(nota3);
        catedra3.inicializaAlumno();
        catedra3.addAlumno(alumno2);
        catedra3.addAlumno(alumno3);
        catedra3.inicializaNota();
        catedra3.addNota(nota2);
        catedra3.addNota(nota3);
        alumno.setCatedra(catedra);
        alumno.inicializaNotas();
        alumno.agregaNota(nota);
        alumno.agregaNota(nota1);
        alumno1.setCatedra(catedra1);
        alumno1.inicializaNotas();
        alumno1.agregaNota(nota);
        alumno1.agregaNota(nota1);
        alumno2.setCatedra(catedra2);
        alumno2.inicializaNotas();
        alumno2.agregaNota(nota2);
        alumno2.agregaNota(nota3);
        alumno3.setCatedra(catedra3);
        alumno3.inicializaNotas();
        alumno3.agregaNota(nota2);
        alumno3.agregaNota(nota3);
        nota.setAlumno(alumno);
        nota.setCatedra(catedra);
        nota1.setAlumno(alumno);
        nota1.setCatedra(catedra1);

        Nota notaPrueba = alumno.mejorNota(null);
        System.out.println("Nota: " + notaPrueba.getValor() + "Alumno: " + notaPrueba.getAlumno().getNombre() + "Catedra: " + notaPrueba.getCatedra().getDenominacion());
        System.out.println("Promedio del alumno: " + alumno.promedioNotas(null));
        Alumno alumnoPrueba = catedra.mejorAlumnoCatedra();
        System.out.println("Alumno: " +alumnoPrueba.getApellido());
    }

}
