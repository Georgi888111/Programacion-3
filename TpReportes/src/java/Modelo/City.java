/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class City {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;
    private Conexion conexion;

    public City() {
    this.conexion = new Conexion();
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    public ArrayList<City>traeCiudades(String code){
   conexion.estableceConexion("localhost", "3306", "root", "", "databaseworld");      
   return this.conexion.traeCiudadesXcod(code);
    }
}
