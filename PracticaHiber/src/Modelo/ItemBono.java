package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Georgi
 * 
 */
@Entity
@Table(name="ItemBono")
public class ItemBono implements Serializable{
    
    private int codigo;
    private String denominacion;
    private double montoItem;
    private  boolean descuento;
    private List<BonoSueldo>bonos =  new ArrayList<>();

 

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY) 
  
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getMontoItem() {
        return montoItem;
    }

    public void setMontoItem(double montoItem) {
        this.montoItem = montoItem;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }
    
    
    
     @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "BonosItems", joinColumns = {@JoinColumn(name="id_bono")}, inverseJoinColumns = {@JoinColumn(name="id_item")})
       public List<BonoSueldo> getBonos() {
        return bonos;
    }

    public void setBonos(List<BonoSueldo> bonos) {
        this.bonos = bonos;
    }
}
