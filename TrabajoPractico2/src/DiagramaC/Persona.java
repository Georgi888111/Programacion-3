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
public class Persona {

    private String nombre;
    private String tipoDocumento;
    private long nroDocumento;
    private int telefono;
    private String email;
    private String celular;
    private ArrayList<Actividad> actividades;
    private Sector sector;

    public Persona(String nombre, String tipoDocumento, long nroDocumento, int telefono, String email, String celular) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.telefono = telefono;
        this.email = email;
        this.celular = celular;
    }
    
    
    

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public void addActividad(Actividad actividad) {
        this.actividades.add(actividad);
    }

    public void inicializaArrayAct() {
        this.actividades = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(long nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public double totalPuntosAsignados() {
        double totalPuntos = 0;
        for (int i = 0; i < this.actividades.size(); i++) {
            totalPuntos = totalPuntos + this.actividades.get(i).getTipoActividad().getPuntosAsignados();
        }
        return totalPuntos;
    }

    public double totalPuntosAsignados(int codigo) {
        double totalFiltrado = 0;
        for (int i = 0; i < this.actividades.size(); i++) {
            if (this.actividades.get(i).getTipoActividad().getCodigo() == codigo) {
                totalFiltrado = totalFiltrado + this.actividades.get(i).getTipoActividad().getPuntosAsignados();
            }
        }
        return totalFiltrado;
    }

    public double totalPuntosAsignados(int codigo, int anio) {

        double totalPorTiempo = 0;
        for (int i = 0; i < this.actividades.size(); i++) {
            if ((this.actividades.get(i).getFechaInicio().getYear() == anio) && (this.actividades.get(i).getTipoActividad().getCodigo() == codigo)) {
                totalPorTiempo = totalPorTiempo + this.actividades.get(i).getTipoActividad().getPuntosAsignados();

            }

        }
        return totalPorTiempo;
    }
}
