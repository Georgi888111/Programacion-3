/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expediente;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class DiagramaA {
    
    
      public static void main(String[] args) {
     EstadoControl estado = new EstadoControl();
        Control control = new Control();
        control.setDenominacion("Caratulado como urgente");
        control.setEsObligatorio(true);
        Control control1 = new Control();
        control1.setDenominacion("Caratulado como urgente2");
        control1.setEsObligatorio(true);

        Expediente expedienteDiferente = new Expediente();
        expedienteDiferente.setLetra("C");
        expedienteDiferente.setDescripcion("Expedientes de cuentas");
        expedienteDiferente.setNumero(12);
        expedienteDiferente.setAmbito("Contable");
        expedienteDiferente.setTipo("Urgente");
        expedienteDiferente.setExpediente(expedienteDiferente);
        

        Expediente expedientePadre = new Expediente();
        expedientePadre.setLetra("F");
        expedientePadre.setDescripcion("Expedientes de auditorias");
        expedientePadre.setNumero(1234);
        expedientePadre.setAmbito("Fiscal1");
        expedientePadre.setTipo("Urgente");
        expedientePadre.setExpediente(expedientePadre);
        //estado.setExpediente(expedientePadre);
        estado.setAprobado(true);
        expedientePadre.addControl(control);
         expedientePadre.addControl(control1);
        expedientePadre.addEstadoControl(estado);
        control.agregaExpediente(expedientePadre);
        control.addEstadoControl(estado);

        Expediente expedienteHijo = new Expediente();
        expedienteHijo.setLetra("F");
        expedienteHijo.setDescripcion("Expedientes de auditorias");
        expedienteHijo.setNumero(12345);
        expedienteHijo.setAmbito("Fiscal2");
        expedienteHijo.setTipo("Urgente");
        expedientePadre.addExpediente(expedienteHijo);
        expedienteHijo.setExpediente(expedienteHijo);
        estado.setExpediente(expedienteHijo);
        estado.setAprobado(false);
        expedienteHijo.addEstadoControl(estado);
        expedienteHijo.addControl(control);
        control.agregaExpediente(expedienteHijo);
        control.addEstadoControl(estado);

        Expediente expedienteHijoDos = new Expediente();
        expedienteHijoDos.setLetra("F");
        expedienteHijoDos.setDescripcion("Expedientes de auditorias");
        expedienteHijoDos.setNumero(12345);
        expedienteHijoDos.setAmbito("Fiscal3");
        expedienteHijoDos.setTipo("Urgente");
        expedientePadre.addExpediente(expedienteHijoDos);
        expedienteHijoDos.setExpediente(expedienteHijoDos);
        estado.setExpediente(expedienteHijoDos);
        estado.setAprobado(true);
        expedienteHijoDos.addControl(control);
        expedienteHijoDos.addEstadoControl(estado);
        control.agregaExpediente(expedienteHijoDos);
        control.addEstadoControl(estado);

        Expediente expedienteHijoDel2 = new Expediente();
        expedienteHijoDel2.setLetra("F");
        expedienteHijoDel2.setDescripcion("Expedientes de auditorias");
        expedienteHijoDel2.setNumero(12345);
        expedienteHijoDel2.setAmbito("Fiscal4");
        expedienteHijoDel2.setTipo("Urgente");
        expedienteHijoDos.addExpediente(expedienteHijoDel2);
        expedienteHijoDel2.setExpediente(expedienteHijoDel2);
        estado.setExpediente(expedienteHijoDel2);
        estado.setAprobado(true);
        expedienteHijoDel2.addEstadoControl(estado);
        expedienteHijoDel2.addControl(control);

        System.out.println("Caratula " + expedientePadre.getCaratulaExpediente(1234));
        System.out.println("Controles obligatorios " + expedientePadre.getControlesObligatorios());
        if (expedientePadre.getEstadoControles()) {
            System.out.println("Todos aprobados");
        } else {
            System.out.println("Hay algunos sin aprobar todavia");
        }

        ArrayList<Expediente> expedientesRelacionados = new ArrayList();
        expedientesRelacionados = expedientePadre.listaExpedientes();
        for (int i = 0; i < expedientesRelacionados.size(); i++) {
            System.out.println(expedientesRelacionados.get(i).getAmbito());
        }
    }
    
}
