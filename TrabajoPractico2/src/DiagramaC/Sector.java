/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaC;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Sector {

    private int numero;
    private String denominacion;
    private String tipo;
    private ArrayList<Persona> personas;
    private Sector sector;
    private ArrayList<Sector> sectores;

    public Sector(int numero, String denominacion, String tipo) {
        this.numero = numero;
        this.denominacion = denominacion;
        this.tipo = tipo;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public void inicializaPersona() {
        personas = new ArrayList();
    }

    public void inicializaSector() {
        sectores = new ArrayList();
    }

    public void addSector(Sector sector) {
        this.sectores.add(sector);
    }

    public void addPersona(Persona persona) {
        this.personas.add(persona);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    public ArrayList<Sector> obtenerTotalSubsectores() {
        ArrayList<Sector> nuevosSectores = new ArrayList();
        if (this.sectores != null) {
            return this.verificaSubSector(this, nuevosSectores);
        } else {
            System.out.println("El sector esta vacio");

            return null;
        }
    }

    private ArrayList<Sector> verificaSubSector(Sector sector, ArrayList<Sector> nuevosSectores) {

        nuevosSectores.add(sector);

        if (sector.getSectores() != null) {
            for (Sector sec : sector.getSectores()) {
                verificaSubSector(sec, nuevosSectores);
            }
        }
        return nuevosSectores;
    }
}
