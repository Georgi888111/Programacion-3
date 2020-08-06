/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Pais;
import Modelo.Provincia;
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

   
    
    
    

    public Connection estableceConexion() {
        if (conn != null) {
            return conn;
        }
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String urlConexion = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "ubicacion";

            conn = DriverManager.getConnection(urlConexion, "root", "");
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
    
    public ArrayList<Pais> traePaises(){
 
        ArrayList<Pais> paises = new ArrayList();
            try {
                this.consulta = this.conn.prepareStatement("SELECT * FROM pais;");
                ResultSet hojadeResultados = this.consulta.executeQuery();

            while (hojadeResultados.next()) {
                Pais pais  = new Pais();
                pais.setId(hojadeResultados.getInt(1));
                pais.setNombre(hojadeResultados.getString(2));
               
                paises.add(pais);
            }
            }catch (SQLException e) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }            
        return paises;
    }
    
    
    public ArrayList<Provincia>traeProvincias(String nombrePais){
    int id =Integer.parseInt(nombrePais);
     ArrayList<Provincia>provincias = new ArrayList();
                 try {
                this.consulta = this.conn.prepareStatement("SELECT * FROM provincia WHERE idPais =" + id);
                ResultSet hojadeResultados = this.consulta.executeQuery();

            while (hojadeResultados.next()) {
                Provincia provincia  = new Provincia();
                provincia.setId(hojadeResultados.getInt(1));
                provincia.setNombre(hojadeResultados.getString(2));
               
                provincias.add(provincia);
            }
            }catch (SQLException e) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }            
        return provincias;
        
    }
    
    public int buscaPaisXnombre(String nombrePais){
        int id=0;
           try {
                this.consulta = this.conn.prepareStatement("SELECT id FROM pais WHERE nombre = '" + nombrePais + "'");
                ResultSet hojadeResultados = this.consulta.executeQuery();

          
               id=hojadeResultados.getInt("id");
            
            }catch (SQLException e) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }            
        return id;
    }
     
    }


