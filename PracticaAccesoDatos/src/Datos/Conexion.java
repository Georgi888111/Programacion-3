/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.DetalleHistoriaClinica;
import Modelo.HistoriaClinica;
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
    
    public void agregaHistoriaClinica(HistoriaClinica historia) throws SQLException{

        if(busquedaLegajo(historia)){
           JOptionPane.showMessageDialog(null, "Esta historia ya existe, deberia verificar el lejago o ingresar la opcion de modificar nuevamente");    
        }else{
           String query ="INSERT INTO historiaclinica (legajoPaciente,fechaNacimiento,nombrePaciente, sexo) values (?,?,?,?)";
          
          String sexo = "";
          if(historia.isSexo()==true){
              sexo = "F";
          }else{
              sexo ="M";
          }
        
         this.consulta = this.conn.prepareStatement(query);
         consulta.setInt(1, historia.getLegajo());
         consulta.setString(2, historia.getFechaNacimiento());
    
         consulta.setString(3, historia.getNombrePaciente());
         consulta.setString(4, sexo);
          
    
         this.consulta.execute();
        JOptionPane.showMessageDialog(null, "Historia agregada con exito");
        
        String query2 ="INSERT INTO detallehistoriaclinica (iddetalleHC, fechaAtencion, sintomas, diagnostico,tratamiento, legajoPaciente) values(?,?,?, ?,?, ?)";
           

        for (int i = 0; i < historia.getDetalles().size(); i++) {
        this.consulta = this.conn.prepareStatement(query2);  
           consulta.setInt(1, historia.getDetalles().get(i).getIdDetalleHC());
            consulta.setString(2, historia.getDetalles().get(i).getFechaAtencion());
              consulta.setString(3, historia.getDetalles().get(i).getSintomas());
                  consulta.setString(4, historia.getDetalles().get(i).getDiagnostico());
                          consulta.setString(5, historia.getDetalles().get(i).getTratamiento());
                          consulta.setInt(6, historia.getLegajo());
                                   this.consulta.execute();
                                    JOptionPane.showMessageDialog(null, "Historia " + i+1 +" agregada con exito");
        }
    }
                
    }
    
    public void modificar(DetalleHistoriaClinica deta) throws SQLException{
  
     
      String query ="INSERT INTO detallehistoriaclinica (iddetalleHC, fechaAtencion, sintomas, diagnostico,tratamiento, legajoPaciente) values(?,?,?, ?,?, ?)";
       this.consulta = this.conn.prepareStatement(query);  
           consulta.setInt(1, deta.getIdDetalleHC());
            consulta.setString(2, deta.getFechaAtencion());
              consulta.setString(3, deta.getSintomas());
                  consulta.setString(4, deta.getDiagnostico());
                          consulta.setString(5, deta.getTratamiento());
                          consulta.setInt(6, deta.getHistoria().getLegajo());
                                   this.consulta.execute();
    }
    public boolean busquedaLegajo(HistoriaClinica historia) throws SQLException{
        boolean busqueda = false;
     String query = "SELECT * FROM historiaclinica WHERE legajoPaciente =  " + historia.getLegajo();   
       this.consulta = this.conn.prepareStatement(query);  
       if(this.consulta.execute()){
         busqueda=true;
    }else{
           busqueda = false;
       }
       
       return busqueda;
    }
    
    public HistoriaClinica busquedaModifica(int legajo) throws SQLException{
        HistoriaClinica hist = new HistoriaClinica();
          String query = "SELECT * FROM historiaclinica WHERE legajoPaciente =  " + legajo;   
                 this.consulta = this.conn.prepareStatement(query);
      ResultSet hojadeResultados = consulta.executeQuery();
          while (hojadeResultados.next()) {
                   hist.setLegajo(hojadeResultados.getInt(1));
                   hist.setFechaNacimiento(hojadeResultados.getString(2));
                       hist.setNombrePaciente(hojadeResultados.getString(3));
                          hist.setSexo(hojadeResultados.getBoolean(4));
          }
       return hist;
    }
}

