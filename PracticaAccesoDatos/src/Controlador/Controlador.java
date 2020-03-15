/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.Conexion;
import Modelo.DetalleHistoriaClinica;
import Modelo.HistoriaClinica;
import java.sql.SQLException;

/**
 *
 * @author Georgi
 */
public class Controlador {
      Conexion conexion;
      
      
    public Controlador() {
   conexion = new Conexion();
   conexion.estableceConexion("localhost", "3306", "root", "", "clinica");
    }
    
    public void ingresaHistoriaClinica(HistoriaClinica historia) throws SQLException{
     conexion.agregaHistoriaClinica(historia);
    }
    
    public void modificarHistoriaClinica(DetalleHistoriaClinica det) throws SQLException{
       conexion.modificar(det); 
    }
    
    public HistoriaClinica busquedaModificar(int legajo) throws SQLException{
     return conexion.busquedaModifica(legajo);   
    }
}
