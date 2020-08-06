/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Alumno;
import Modelo.Catedra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            String urlConexion = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "escuela_db";

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

    public ArrayList<Catedra> traeCatedras() {
        ArrayList<Catedra> catedras = new ArrayList();
        try {
            this.consulta = this.conn.prepareStatement("SELECT * FROM catedra;");
            ResultSet hojadeResultados = this.consulta.executeQuery();

            while (hojadeResultados.next()) {
                Catedra catedra = new Catedra();
                catedra.setCodigo(hojadeResultados.getInt(1));
                catedra.setDenominacion(hojadeResultados.getString(2));

                catedras.add(catedra);
            }

        } catch (Exception e) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);

        }
        return catedras;
    }
    
    
    
    public ArrayList traeAlumnos(int idCatedra){
      ArrayList<Alumno> alumnos = new ArrayList();
        try {
            this.consulta = this.conn.prepareStatement("SELECT alumno.legajo, alumno.nombre, alumno.apellido From Alumno INNER JOIN catedra_alumno ON alumno.legajo=catedra_alumno.legajoAlumno INNER JOIN catedra ON catedra_alumno.codigoCatedra=catedra.codigo WHERE catedra.codigo = " + idCatedra);
            ResultSet hojadeResultados = this.consulta.executeQuery();

            while (hojadeResultados.next()) {
                Alumno alumno = new Alumno();
                alumno.setLegajo(hojadeResultados.getInt(1));
                alumno.setNombre(hojadeResultados.getString(2));
                 alumno.setApellido(hojadeResultados.getString(3));

                alumnos.add(alumno);
            }

        } catch (Exception e) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);

        }
        return alumnos;   
    }
}
