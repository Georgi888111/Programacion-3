/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.ConfigHibernate;

/**
 *
 * @author Georgi
 */
public class ControladorEmpleado extends Controlador {
     public ControladorEmpleado() {
        sesion = ConfigHibernate.openSession();
    }
}
