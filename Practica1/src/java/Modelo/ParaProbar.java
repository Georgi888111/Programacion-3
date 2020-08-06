/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Georgi
 */
public class ParaProbar {
   public static void main(String[]args){
       Escuela escuela = new Escuela();
       escuela.setDenominacion("Ramponi");
       escuela.setNumero(9001);
      
       DivisionCurso division = new DivisionCurso();
       division.setCodigo(1);
       division.setEscuela(escuela);
       division.setAnio(1);
       division.setDivision(1);
       
       DivisionCurso division2 = new DivisionCurso();
       division2.setCodigo(2);
       division2.setEscuela(escuela);
       division2.setAnio(2);
       division2.setDivision(2);
       
       DivisionCurso division3 = new DivisionCurso();
       division3.setCodigo(3);
       division3.setEscuela(escuela);
       division3.setAnio(3);
       division3.setDivision(3);
       
       ArrayList<DivisionCurso>divisiones = new ArrayList();
       divisiones.add(division);
        divisiones.add(division2);
        divisiones.add(division3);
        escuela.setDivisiones(divisiones);
        
       Catedra catedra = new Catedra();
       catedra.setDivision(division);
       catedra.setCodigo(1);
       catedra.setDenominacion("Lengua");
       
       Catedra catedra2 = new Catedra();
       catedra2.setDivision(division);
       catedra2.setCodigo(2);
       catedra2.setDenominacion("Matematica");
       
        Catedra catedra3= new Catedra();
       catedra3.setDivision(division);
       catedra3.setCodigo(3);
       catedra3.setDenominacion("Fisica");
       
       ArrayList <Catedra>catedras = new ArrayList();
       catedras.add(catedra);
        catedras.add(catedra2);
        catedras.add(catedra3);
         division.setCatedras(catedras);
         division2.setCatedras(catedras);
         
         
      
         Date fecha = new Date(88,10,29,10,10,15);
         
         Alumno alumno = new Alumno();
         alumno.setApellido("Crespo");
         alumno.setFechaNacimiento(fecha);
         alumno.setLegajo(123);
         alumno.setCatedra(catedra);
         
         Alumno alumno2 = new Alumno();
         alumno2.setApellido("Martinez");
         alumno2.setFechaNacimiento(fecha);
         alumno2.setLegajo(1234);
         alumno2.setCatedra(catedra);
         
           Alumno alumno3 = new Alumno();
         alumno3.setApellido("Campora");
         alumno3.setFechaNacimiento(fecha);
         alumno3.setLegajo(12345);
         alumno3.setCatedra(catedra);
         
         
         ArrayList<Alumno>alumnos = new ArrayList();
         alumnos.add(alumno);
         alumnos.add(alumno2);
         alumnos.add(alumno3);
         
         catedra.setAlumnos(alumnos);
         
         Nota nota = new Nota();
         nota.setCatedra(catedra);
         nota.setFechaExamen(fecha);
         nota.setId(1);
         nota.setValor(8);
         nota.setAlumno(alumno);
         nota.setEsRecuperatorio(false);
         
           Nota nota4 = new Nota();
         nota4.setCatedra(catedra);
         nota4.setFechaExamen(fecha);
         nota4.setId(1);
         nota4.setValor(10);
         nota4.setAlumno(alumno);
         nota4.setEsRecuperatorio(false);
         
         Nota nota2 = new Nota();
         nota2.setCatedra(catedra2);
         nota2.setFechaExamen(fecha);
         nota2.setId(1);
         nota2.setValor(9);
         nota2.setAlumno(alumno);
         nota2.setEsRecuperatorio(false);
         
          Nota nota5 = new Nota();
         nota5.setCatedra(catedra2);
         nota5.setFechaExamen(fecha);
         nota5.setId(1);
         nota5.setValor(11);
         nota5.setAlumno(alumno);
         nota5.setEsRecuperatorio(false);
         
         Nota nota3 = new Nota();
         nota3.setCatedra(catedra3);
         nota3.setFechaExamen(fecha);
         nota3.setId(1);
         nota3.setValor(9);
         nota3.setAlumno(alumno);
         nota3.setEsRecuperatorio(false);
         
          Nota nota1 = new Nota();
         nota1.setCatedra(catedra);
         nota1.setFechaExamen(fecha);
         nota1.setId(1);
         nota1.setValor(9);
         nota1.setAlumno(alumno2);
         nota1.setEsRecuperatorio(false);
         
       ArrayList<Nota>notas = new ArrayList();
       notas.add(nota);
       notas.add(nota2);
       notas.add(nota3);
       notas.add(nota4);
       notas.add(nota5);
       
          ArrayList<Nota>notas2 = new ArrayList();
          notas2.add(nota1);
          
          alumno.setNotas(notas);
          alumno2.setNotas(notas2);
          
          
          System.out.println("La mejor nota de: " + alumno.getApellido() + " es " + alumno.mejorNota(null).getValor());
          System.out.println("La mejor nota de Lengua es: " + alumno.getApellido() + " es " + alumno.mejorNota(catedra.getCodigo()).getValor());
          System.out.println("El promedio del alumno es:" + alumno.promedioNotas(catedra.getCodigo())); 
          
          System.out.println("El mejor alumno en la catedra de Lengua es: " + catedra.mejorAlumnoCatedra().getApellido());
          System.out.println("El mejor alumno de la division es: " + division.mejorAlumnoDivisionCurso().getNombre());
          
   }
}
