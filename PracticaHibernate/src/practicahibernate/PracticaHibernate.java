/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicahibernate;

import Controlador.ControladorAlumno;
import Controlador.ControladorCarrera;
import Controlador.ControladorMateria;
import Controlador.ControladorProfesor;
import Modelo.Alumno;
import Modelo.Carrera;
import Modelo.Materia;
import Modelo.Profesor;
import java.util.ArrayList;
import java.util.List;


public class PracticaHibernate {

 
    public static void main(String[] args) {
       try{
      
        List<Materia>materias = new ArrayList<>();
        Materia materia  = new Materia();
      
        materia.setNombre("Lengua");
        materias.add(materia);
  
        Profesor profesor = new Profesor();
        profesor.setDni(33212122);
        profesor.setDomicilio("lalalal");
        profesor.setNombre("Carlos");
        profesor.setTitulo("Ingeniero");
        profesor.setDate("11/11/2001");
     
        profesor.setMaterias(materias);
      
    
        materia.setProfesor(profesor);
    
        Alumno alumno = new Alumno();
        alumno.setDni(34234234);
        alumno.setDomicilio("Calle Falsa");
        alumno.setNombre("Mariano");
        alumno.setDate("23/11/1989");
        alumno.setLegajo(123123);
        alumno.setMaterias(materias);
        materia.setAlumno(alumno);
      
        
        List<Carrera>carreras = new ArrayList<>();
        Carrera carrera = new Carrera();
        carrera.setDuracion(2);
        carrera.setNombre("Tec");
        carreras.add(carrera);
        
        Carrera carrera1 = new Carrera();
        carrera1.setDuracion(3);
        carrera1.setNombre("Enologia");
        carreras.add(carrera1);

        carrera.setAlumno(alumno);
        alumno.setCarreras(carreras);
        
        ControladorMateria cm = new ControladorMateria();
        cm.guardar(materia);
        cm.getSesion().close();
        
        ControladorCarrera carr = new ControladorCarrera();
        carr.guardarLista(carreras);
             carr.getSesion().close();
        ControladorAlumno ca = new ControladorAlumno();
        ca.guardar(alumno);
             ca.getSesion().close();
     
        ControladorProfesor cp = new ControladorProfesor();
        cp.guardar(profesor);   
             cp.getSesion().close();
       
          
      

           
        
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    
}
}
