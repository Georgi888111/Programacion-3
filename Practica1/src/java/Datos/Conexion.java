/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Alumno;
import Modelo.Catedra;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
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
            String urlConexion = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "escuela_db";

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
    
    
    public ArrayList<Catedra> traeCatedras() {
        ArrayList<Catedra> catedras = new ArrayList();
        try {
            this.consulta = (PreparedStatement) this.conn.prepareStatement("SELECT * FROM catedra;");
            ResultSet hojadeResultados = (ResultSet) this.consulta.executeQuery();

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
    
    
    public ArrayList<Alumno> traeAlumnosCatedra(int codigoCatedra){
      ArrayList<Alumno>alumnos = new ArrayList();
        try {
            this.consulta = (PreparedStatement) this.conn.prepareStatement("select alumno.apellido, alumno.legajo,alumno.nombre from alumno inner join catedra_alumno on alumno.legajo = catedra_alumno.legajoAlumno inner join catedra on catedra_alumno.codigoCatedra = catedra.codigo where catedra.codigo =" +codigoCatedra);
            ResultSet hojadeResultados = (ResultSet) this.consulta.executeQuery();

            while (hojadeResultados.next()) {
             Alumno alumno = new Alumno();
              alumno.setApellido(hojadeResultados.getString(1));
                alumno.setLegajo(hojadeResultados.getInt(2));
                 alumno.setNombre(hojadeResultados.getString(3));

                alumnos.add(alumno);
            }
            }catch(Exception e){
                 Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
        return alumnos;
    }
    
    

}
