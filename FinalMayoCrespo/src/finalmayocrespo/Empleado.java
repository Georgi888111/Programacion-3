/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmayocrespo;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
 //@Entity
//@Table(name = "Empleado")
public class Empleado {


    private int legajo;
    private String nombreCompleto;
    private String domicilio;
    private Sector sector;
    private ArrayList<BonoSueldo>bonos = new ArrayList();

    public Empleado(int legajo, String nombreCompleto, String domicilio, Sector sector) {
        this.legajo = legajo;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.sector = sector;
    }

    public Empleado() {
    }

     //@Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_sector")
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

     //@OneToMany(mappedBy = "empleado", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public ArrayList<BonoSueldo> getBonos() {
        return bonos;
    }

    public void setBonos(ArrayList<BonoSueldo> bonos) {
        this.bonos = bonos;
    }
    
    public double getTotalBonoSueldoXPeriodo(int mes, int año){
       double totalPeriodo = 0;
        for (BonoSueldo bono : bonos) {
            if((bono.getAnio()==año)&&(bono.getMes()==mes) ){
                totalPeriodo = bono.getTotal();
            }
                
        }
        return totalPeriodo;
    }

    public double getTotalCobradoXAnio(int anio){
        double suma = 0;
        for (BonoSueldo bono : bonos) {
           if(bono.getAnio()==anio){
               suma=suma+bono.getTotal();
           } 
        }
        return suma;
    }
    
}
