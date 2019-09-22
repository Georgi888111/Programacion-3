/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaD;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Vivienda {

    private long id;
    private String calle;
    private int numeroCalle;
    private double superficieTerreno;
    private Barrio barrio;
    private ArrayList<Habitacion> habitaciones;

    public void agregaHabitacion(Habitacion habitacion) {
        this.habitaciones.add(habitacion);
    }

    public void inicializaHab() {
        this.habitaciones = new ArrayList();
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public double getSuperficieTerreno() {
        return superficieTerreno;
    }

    public void setSuperficieTerreno(double superficieTerreno) {
        this.superficieTerreno = superficieTerreno;
    }

    public double getMetrosCuadradosCubiertos() {
        double totalMtrsTerreno = 0;
        for (int i = 0; i < habitaciones.size(); i++) {
            totalMtrsTerreno = totalMtrsTerreno + habitaciones.get(i).getMetrosCuadrados();
        }
        if (totalMtrsTerreno > this.superficieTerreno) {
            System.out.println("La superficie cubierta no puede ser mayor a la superficie del terreno");
        }
        return totalMtrsTerreno;
    }
}
