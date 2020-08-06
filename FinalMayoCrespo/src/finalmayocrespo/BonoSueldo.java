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
//@Table(name = "BonoSueldo")
public class BonoSueldo {

    private int numero;
    private int mes;
    private int anio;
    private double total;
    private Empleado empleado;
    private ArrayList<ItemBono>items = new ArrayList();

    public BonoSueldo(int numero, int mes, int anio, double total, Empleado empleado) {
        this.numero = numero;
        this.mes = mes;
        this.anio = anio;
        this.total = total;
        this.empleado = empleado;
    }

    public BonoSueldo() {
    }

    
     //@Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

      //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_empleado")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

     //@OneToMany(mappedBy = "bono", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public ArrayList<ItemBono> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemBono> items) {
        this.items = items;
    }
    
    public double calcularTotalHaber(){
        double suma =0;
        for (ItemBono item : items) {
            if(item.isEsRemunerativo()){
                suma = suma + item.getMonto();
            }
        }
        return suma;
    }
    
    public double calcularTotalDebe(){
        double suma=0;
        for (ItemBono item : items) {
            if(!item.isEsRemunerativo()){
                suma = suma + item.getMonto();
            }
        }
        return suma;
    }
    
    public double calcularTotalBono(){
        this.total = calcularTotalHaber()-calcularTotalDebe();
        return total;
    }
    
    
    
}
