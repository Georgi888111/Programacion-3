/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Conexion;
import java.sql.SQLException;

/**
 *
 * @author Georgi
 */
public class Persona {
    private int dni;
    private String nombre;
    private String domicilio;
    private Conexion conexion = new Conexion();
    

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
      public void conectaPersona(){
          
        conexion.estableceConexion("localhost", "3306", "root", "", "tpjsp");
      
    }
      public void agregaPersona(Persona persona) throws SQLException{
       conexion.agregar(persona);   
      }
}
