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
public class Provincia {

    private int id;
    private String nombre;
    private Conexion conexion;

    public Provincia() {
        this.conexion = new Conexion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Provincia> mostrarTodos(int idPais) {
        conexion.estableceConexion("localhost", "3306", "root", "", "ubicacion");
        return this.conexion.muestraTodos(idPais);
    }
}
