/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaaccesodatos;

import Controlador.Controlador;
import Modelo.DetalleHistoriaClinica;
import Modelo.HistoriaClinica;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Georgi
 */
public class PracticaAccesoDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Controlador controlador = new Controlador(); 
         ArrayList<DetalleHistoriaClinica>detalles = new ArrayList();
          HistoriaClinica historia = new HistoriaClinica();
         String opcion="";
        System.out.println("Desea insertar o modificar una historia clinica?");
        opcion = new Scanner(System.in).next();
        if(opcion.equalsIgnoreCase("insertar")){
       
        historia.setLegajo(1001);
        historia.setNombrePaciente("Miguel Estrada");
        historia.setSexo(false);
        historia.setFechaNacimiento("1966-1-29");
        
       
        DetalleHistoriaClinica detalle = new DetalleHistoriaClinica();
        detalle.setFechaAtencion("2019-3-12");
        detalle.setIdDetalleHC(13);
        detalle.setSintomas("Fiebre");
        detalle.setDiagnostico("Infeccion");
        detalle.setTratamiento("Reposo");
        detalle.setHistoria(historia);
        detalles.add(detalle); 
        DetalleHistoriaClinica detalle1 = new DetalleHistoriaClinica();
        detalle1.setFechaAtencion("2019-3-12");
        detalle1.setIdDetalleHC(8);
        detalle1.setSintomas("Dolor de cabeza");
        detalle1.setDiagnostico("Migraña");
        detalle1.setTratamiento("Reposo");
        detalle1.setHistoria(historia);
        detalles.add(detalle1);
        historia.setDetalles(detalles);
       
        controlador.ingresaHistoriaClinica(historia);
        }else{
            if(opcion.equalsIgnoreCase("modificar")){
          System.out.println("Solo puede agregar un detalle a la historia clinica que seleccione");
                System.out.println("Ingrese el numero de legajo del paciente");
                int legajo = new Scanner(System.in).nextInt();
                HistoriaClinica historiaM = controlador.busquedaModificar(legajo);
         DetalleHistoriaClinica detalle2 = new DetalleHistoriaClinica();
        detalle2.setFechaAtencion("2019-3-12");
        detalle2.setIdDetalleHC(115);
        detalle2.setSintomas("Fiebre");
        detalle2.setDiagnostico("Infeccion");
        detalle2.setTratamiento("Reposo");
        detalle2.setHistoria(historiaM);
        detalles.add(detalle2); 
        controlador.modificarHistoriaClinica(detalle2);
            }else{
                System.out.println("Lo que ingreso no es correcto");
            }
        }
        
        
 
    }
    
}
