/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicahiber;

import Controlador.ControladorBonoSueldo;
import Controlador.ControladorEmpleado;
import Controlador.ControladorGrupoFamiliar;
import Controlador.ControladorItemBono;
import Modelo.BonoSueldo;
import Modelo.Empleado;
import Modelo.GrupoFamiliar;
import Modelo.ItemBono;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Georgi
 */
public class PracticaHiber {

    public static void main(String[] args) {
//        try {

            Date fecha = Date.from(Instant.now());
            Empleado empleado = new Empleado();
            empleado.setFechaIngreso(fecha);

            empleado.setNombreCompleto("Marcela Pascal");
            GrupoFamiliar grupo = new GrupoFamiliar();
            grupo.setCantidadHijos(2);
            grupo.setEsCasado(false);

            grupo.setEmpleado(empleado);
            empleado.setGrupoFamiliar(grupo);
            BonoSueldo bono1 = new BonoSueldo();
            bono1.setAnio(2021);
            bono1.setMes(1);

    
            bono1.setEmpleado(empleado);
       
            
            ItemBono item1 = new ItemBono();

            item1.setDenominacion("jubilacion");
            item1.setMontoItem(15300);
            item1.setDescuento(false);
            ItemBono item2 = new ItemBono();
              item1.setDenominacion("Obra Scial");
            item1.setMontoItem(1000);
            item1.setDescuento(true);
            List<BonoSueldo> bonos = new ArrayList<>();
            bonos.add(bono1);
            List<ItemBono> items = new ArrayList<>();
            items.add(item1);
            items.add(item2);
            item1.setBonos(bonos);
              item2.setBonos(bonos);
            bono1.setItems(items);
            empleado.setBonos(bonos);

            

            
//            ControladorEmpleado ce = new ControladorEmpleado();
//            ce.guardar(empleado);
//
//      
//            ControladorGrupoFamiliar cgf = new ControladorGrupoFamiliar();
//            cgf.guardar(grupo);
//
//       
//            ControladorBonoSueldo cbs = new ControladorBonoSueldo();
//            cbs.guardar(bono1);
//            cbs.guardarLista(items);
//   
//     
//            ControladorItemBono cib = new ControladorItemBono();
//            cib.guardar(item1);
//            cib.guardarLista(bonos);
//
//     
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

    }
}
