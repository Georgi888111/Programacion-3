/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Practica {
    public static void main(String[] args) {
        Expediente expediente = new Expediente();
        expediente.setDescripcion("Pelea de perros");
        expediente.setNumero(3);
        expediente.setLetra("A");
        Control control = new Control();
        control.setDenominacion("Robo a mano armada");
        control.setEsObligatorio(true);
        Control control1 = new Control();
        control1.setDenominacion("Delito grave");
        control1.setEsObligatorio(true);
        Control control2 = new Control();
        control2.setDenominacion("Madre mia");
        control2.setEsObligatorio(false);
        ArrayList<Control>controles = new ArrayList();
        controles.add(control);
        controles.add(control1);
        controles.add(control2);
        expediente.setControles(controles);
        EstadoControl estado =  new EstadoControl();
        estado.setAprobado(false);
        EstadoControl estado1 = new EstadoControl();
        estado1.setAprobado(true);
        ArrayList<EstadoControl> estados = new ArrayList();
        estados.add(estado);
        estados.add(estado1);
        control.setEstadosControles(estados);
        
        
       // System.out.println(expediente.getCaratulaExpediente());
        //System.out.println(expediente.getControlesObligatorios());
        System.out.println(expediente.getEstadoControles());
    }
}
