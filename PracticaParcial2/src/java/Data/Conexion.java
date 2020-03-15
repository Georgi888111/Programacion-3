/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Persona;
import Modelo.Usuario;
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
    
    
    
     public void agregar(Usuario usuario) throws SQLException{ 
        
        String query ="INSERT INTO usuarios (nombre,apellido,idUsuario,password,usuario) VALUES (?,?,?,?,?)";
        
         this.consulta = this.conn.prepareStatement(query);
    
         consulta.setString(1, usuario.getNombre());
        consulta.setString(2, usuario.getApellido());
          consulta.setInt(3, usuario.getIdUsuario());
           consulta.setString(4, usuario.getPassword());
     consulta.setString(5, usuario.getUsuario());
     
         this.consulta.execute();
        JOptionPane.showMessageDialog(null, "Persona agregada con exito");
    }
}