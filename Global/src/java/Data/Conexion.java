package Data;

import Modelo.Provincia;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    protected Provincia provincia;

    public Connection estableceConexion(String host, String puerto, String user, String password, String base) {
        if (conn != null) {
            return conn;
        }
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String urlConexion = "jdbc:mysql://" + host + ":" + puerto + "/" + base;

            conn = (Connection) DriverManager.getConnection(urlConexion, user, password);
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

    public ArrayList<Provincia> muestraTodos(int paisId) {
        ArrayList<Provincia> provincias = new ArrayList();
        String query = "SELECT*FROM provincia where idpais  ='" + paisId + "'";
        try {

            this.consulta = (PreparedStatement) this.conn.prepareStatement(query);
            ResultSet hojadeResultados = consulta.executeQuery();

            while (hojadeResultados.next()) {
                provincia = new Provincia();

                provincia.setId(hojadeResultados.getInt(1));
                provincia.setNombre(hojadeResultados.getString(2));

                provincias.add(provincia);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return provincias;
    }
}
