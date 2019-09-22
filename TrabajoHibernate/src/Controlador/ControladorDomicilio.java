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
//Todos los controladores heredan de controlador, por lo tanto tienen acceso a ConfighHibernate para abrir la sesion
public class ControladorDomicilio extends Controlador {
    public ControladorDomicilio() {
        sesion = ConfigHibernate.openSession();
    }
}
