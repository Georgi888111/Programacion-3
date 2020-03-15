/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Conexion;

/**
 *
 * @author Georgi
 */
public class Country {
    
   private String name;
    private Float surfaceArea;
    private Long population;
    private Conexion conexion;
    
    public Country() {
   this.conexion = new Conexion();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    
    public Country traePais(String code){
    conexion.estableceConexion("localhost", "3306", "root", "", "databaseworld");   
    return this.conexion.traePaisXcod(code);
    }
}
