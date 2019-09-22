/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.ConfigHibernate;
import org.hibernate.SessionFactory;

/**
 *
 * @author Georgi
 */
public class ControladorMedico extends Controlador {

    public ControladorMedico() {
       
     sesion = ConfigHibernate.openSession();
     
    }
    
   
    
            }
