/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaA;

import java.util.ArrayList;

public class DiagramaA {

    public static void main(String[] args) {

        EstadoControl estado = new EstadoControl();
        Control control = new Control();
        control.setDenominacion("Caratulado como urgente");
        control.setEsObligatorio(true);

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
        expedientePadre.setAmbito("Fiscal");
        expedientePadre.setTipo("Urgente");
        expedientePadre.setExpediente(expedientePadre);
        //estado.setExpediente(expedientePadre);
        estado.setAprobado(true);
        expedientePadre.addControl(control);
        expedientePadre.addEstadoControl(estado);
        control.agregaExpedientes(expedientePadre);
        control.addEstadoCon(estado);

        Expediente expedienteHijo = new Expediente();
        expedienteHijo.setLetra("F");
        expedienteHijo.setDescripcion("Expedientes de auditorias");
        expedienteHijo.setNumero(12345);
        expedienteHijo.setAmbito("Fiscal");
        expedienteHijo.setTipo("Urgente");
        expedientePadre.addExpediente(expedienteHijo);
        expedienteHijo.setExpediente(expedienteHijo);
        estado.setExpediente(expedienteHijo);
        estado.setAprobado(false);
        expedienteHijo.addEstadoControl(estado);
        expedienteHijo.addControl(control);
        control.agregaExpedientes(expedienteHijo);
        control.addEstadoCon(estado);

        Expediente expedienteHijoDos = new Expediente();
        expedienteHijoDos.setLetra("F");
        expedienteHijoDos.setDescripcion("Expedientes de auditorias");
        expedienteHijoDos.setNumero(12345);
        expedienteHijoDos.setAmbito("Fiscal");
        expedienteHijoDos.setTipo("Urgente");
        expedientePadre.addExpediente(expedienteHijoDos);
        expedienteHijoDos.setExpediente(expedienteHijoDos);
        estado.setExpediente(expedienteHijoDos);
        estado.setAprobado(true);
        expedienteHijoDos.addControl(control);
        expedienteHijoDos.addEstadoControl(estado);
        control.agregaExpedientes(expedienteHijoDos);
        control.addEstadoCon(estado);

        Expediente expedienteHijoDel2 = new Expediente();
        expedienteHijoDel2.setLetra("F");
        expedienteHijoDel2.setDescripcion("Expedientes de auditorias");
        expedienteHijoDel2.setNumero(12345);
        expedienteHijoDel2.setAmbito("Fiscal");
        expedienteHijoDel2.setTipo("Urgente");
        expedienteHijoDos.addExpediente(expedienteHijoDel2);
        expedienteHijoDel2.setExpediente(expedienteHijoDel2);
        estado.setExpediente(expedienteHijoDel2);
        estado.setAprobado(true);
        expedienteHijoDel2.addEstadoControl(estado);
        expedienteHijoDel2.addControl(control);

        System.out.println("Caratula" + expedientePadre.getCaratulaExpediente());
        System.out.println("Controles obligatorios" + expedientePadre.getControlesObligatorios());
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
