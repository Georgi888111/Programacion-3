/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Pais;
import Modelo.Provincia;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
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

    public Conexion() {
        
        this.estableceConexion();
    }
    
   public Connection estableceConexion() {
        if (conn != null) {
            return conn;
        }
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String urlConexion = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "ubicacion";

            conn = (Connection) DriverManager.getConnection(urlConexion, "root", "");
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
    
    public ArrayList<Pais> traePaises() {
        ArrayList<Pais> paises= new ArrayList();
        try {
            this.consulta = (PreparedStatement) this.conn.prepareStatement("SELECT * FROM pais;");
            ResultSet hojadeResultados = (ResultSet) this.consulta.executeQuery();

            while (hojadeResultados.next()) {
                Pais pais= new Pais();
                pais.setId(hojadeResultados.getInt(1));
                pais.setNombre(hojadeResultados.getString(2));

                paises.add(pais);
            }

        } catch (Exception e) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);

        }
        return paises;
    }
    
      public ArrayList<Provincia> traeProvincias(int idPais) {
        ArrayList<Provincia> provincias= new ArrayList();
        try {
            this.consulta = (PreparedStatement) this.conn.prepareStatement("SELECT * FROM provincia where idPais = " + idPais);
            ResultSet hojadeResultados = (ResultSet) this.consulta.executeQuery();

            while (hojadeResultados.next()) {
                Provincia provincia= new Provincia();
                provincia.setId(hojadeResultados.getInt(1));
                provincia.setNombre(hojadeResultados.getString(2));
                provincia.setIdPais(hojadeResultados.getInt(3));

                provincias.add(provincia);
            }

        } catch (Exception e) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);

        }
        return provincias;    
}
}
