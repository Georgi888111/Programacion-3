/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Georgi
 */
public class Provincia {
    private String nombre;
    private int id;
    private int idPais;

    public Provincia(String nombre, int id, int idPais) {
        this.nombre = nombre;
        this.id = id;
        this.idPais = idPais;
    }

    public Provincia() {
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    
    
    
    
}
