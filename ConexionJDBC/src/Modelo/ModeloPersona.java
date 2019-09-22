/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Data.Conexion;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class ModeloPersona {

    private String nombre;
    private String apellido;
    private int edad;
    private Date fecha;
    private Conexion conexion;

    public ModeloPersona(Conexion conexion) {
        this.conexion = conexion;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void insertarPersona(String query) {
        this.conexion.agregar(query);
    }

    public void borrarPersona(String query) {
        this.conexion.borrar(query);
    }

    public void modificarPersona(String query) {
        this.conexion.modificar(query);
    }

    public ArrayList<ModeloPersona> traerPersonas(String query) {
        ArrayList<ModeloPersona> aux = new ArrayList();

        aux = this.conexion.traerTodos(query);
        return aux;

    }
}
