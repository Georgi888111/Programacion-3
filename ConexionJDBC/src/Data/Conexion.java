/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.ModeloPersona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Georgi
 */
public class Conexion {

    protected Connection conn;
    protected PreparedStatement consulta;

    protected ResultSet datos;
    private ArrayList<ModeloPersona> model = new ArrayList();
    private ModeloPersona modelo;

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

    public void agregar(String query) {

        try {

            this.consulta = this.conn.prepareStatement(query);
            this.consulta.execute();

            JOptionPane.showMessageDialog(null, "Persona agregada con exito");

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido agregar la persona");

        }
    }

    public void borrar(String query) {
        try {

            this.consulta = this.conn.prepareStatement(query);
            this.consulta.executeUpdate();

            JOptionPane.showMessageDialog(null, "Persona eliminada con exito");

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar la persona");

        }
    }

    public void modificar(String query) {
        try {

            this.consulta = this.conn.prepareStatement(query);
            this.consulta.executeUpdate();

            JOptionPane.showMessageDialog(null, "Persona modificada con exito");

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se ha podido modificar la persona");

        }
    }

    public ArrayList<ModeloPersona> traerTodos(String query) {

        try {

            this.consulta = this.conn.prepareStatement(query);
            ResultSet hojadeResultados = consulta.executeQuery();

            while (hojadeResultados.next()) {
                modelo = new ModeloPersona(this);
                modelo.setNombre(hojadeResultados.getString(1));
                modelo.setApellido(hojadeResultados.getString(2));
                modelo.setEdad(hojadeResultados.getInt(3));
                modelo.setFecha(hojadeResultados.getDate(4));
                model.add(modelo);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }

}
