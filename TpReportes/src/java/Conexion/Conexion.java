/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Modelo.City;
import Modelo.Country;
import Modelo.CountryLanguage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Georgi
 */
public class Conexion {
    
 protected Connection conn;
 protected PreparedStatement consulta; 
 protected ResultSet datos;
 protected Country country; 
 protected City city;
 protected CountryLanguage language;

 
     public Connection estableceConexion(String host, String puerto, String user, String password, String base) {
        if (conn != null) {
            return conn;
        }
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String urlConexion = "jdbc:mysql://" + host + ":" + puerto + "/" + base;

            conn = DriverManager.getConnection(urlConexion, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void cierraConexion() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Country traePaisXcod(String code){
 
       String query="select*from country where Code ='" + code + "'";    
         try {

            this.consulta = this.conn.prepareStatement(query);
            ResultSet hojadeResultados = consulta.executeQuery();
            hojadeResultados.next();
           country = new Country();    
           country.setName(hojadeResultados.getString("Name"));
           country.setSurfaceArea(hojadeResultados.getFloat("SurfaceArea"));
           country.setPopulation(hojadeResultados.getLong("Population"));
 
               
                

            

        } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }



    return country;
    }
    
    public ArrayList<City>traeCiudadesXcod(String code){
        
    ArrayList<City>cities= new ArrayList();
    String query = "SELECT * FROM city WHERE CountryCode ='" + code + "'";
      try {

            this.consulta = this.conn.prepareStatement(query);
            ResultSet hojadeResultados = consulta.executeQuery();
             while (hojadeResultados.next()) {
              city = new City();
              city.setName(hojadeResultados.getString("Name"));
              city.setDistrict(hojadeResultados.getString("District"));
              city.setPopulation((int) hojadeResultados.getLong("Population"));
              cities.add(city);
              }
    }catch (SQLException ex) {
                 System.out.println(ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return cities;
}
    
     public ArrayList<CountryLanguage>traeLenguajesXcod(String code){
        
    ArrayList<CountryLanguage>languages= new ArrayList();
    String query = "SELECT * FROM countrylanguage WHERE CountryCode ='" + code + "'";
      try {

            this.consulta = this.conn.prepareStatement(query);
            ResultSet hojadeResultados = consulta.executeQuery();
             while (hojadeResultados.next()) {
              language = new CountryLanguage();
             language.setLanguage(hojadeResultados.getString("Language"));
                language.setPercentage(hojadeResultados.getFloat("Percentage"));
                languages.add(language);
         
              }
    }catch (SQLException ex) {
                 System.out.println(ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return languages;
}
}