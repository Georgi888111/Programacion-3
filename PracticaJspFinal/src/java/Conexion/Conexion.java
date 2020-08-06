/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Modelo.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Georgi
 */
public class Conexion {
    
   protected Connection conn;
   protected PreparedStatement consulta; 
   protected ResultSet datos;
   private ArrayList<Persona>personas = new ArrayList();
   private Persona persona;
 
 
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
    
      public void agregar(Persona persona) throws SQLException{ 
        
        String query ="INSERT INTO persona (dni,nombre,domicilio) VALUES (?,?,?)";
        
         this.consulta = this.conn.prepareStatement(query);
         consulta.setInt(1, persona.getDni());
         consulta.setString(2, persona.getNombre());
    
         consulta.setString(3, persona.getDomicilio());
          
    
         this.consulta.execute();
        JOptionPane.showMessageDialog(null, "Persona agregada con exito");
    }
      
}
