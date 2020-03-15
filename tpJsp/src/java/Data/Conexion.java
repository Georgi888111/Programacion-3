package Data;

import Modelo.Persona;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
      
      public ArrayList<Persona> muestraTodos(){
          
          String query = "SELECT*FROM persona";
             try {

            this.consulta = this.conn.prepareStatement(query);
            ResultSet hojadeResultados = consulta.executeQuery();

            while (hojadeResultados.next()) {
               persona = new Persona();
            
                persona.setDni(hojadeResultados.getInt(1));
                persona.setNombre(hojadeResultados.getString(2));
                persona.setDomicilio(hojadeResultados.getString(3));
               
                personas.add(persona);

            }
        } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personas;
    }
      }
    



