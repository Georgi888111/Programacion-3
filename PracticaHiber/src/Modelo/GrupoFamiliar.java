package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Georgi
 */
@Entity
@Table(name="GrupoFamiliar")
public class GrupoFamiliar implements Serializable{
   private int id;
   private boolean esCasado;
   private int cantidadHijos;
   private Empleado empleado;

   
     @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY) 
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEsCasado() {
        return esCasado;
    }

 

    public void setEsCasado(boolean esCasado) {
        this.esCasado = esCasado;
    }

    public int getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }
   @OneToOne(mappedBy = "grupoFamiliar")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
   
   
}
