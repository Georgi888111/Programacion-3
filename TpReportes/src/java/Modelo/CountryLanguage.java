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
public class CountryLanguage {
  
    private String language;
    private Float percentage;
    private Conexion conexion;

    public CountryLanguage() {
        this.conexion = new Conexion();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
public ArrayList<CountryLanguage>traeLenguajes(String code){
  conexion.estableceConexion("localhost", "3306", "root", "", "databaseworld");      
  return this.conexion.traeLenguajesXcod(code);  
}
}

    
    

