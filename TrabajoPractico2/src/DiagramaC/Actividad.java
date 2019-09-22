/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaC;

import java.time.LocalDate;

/**
 *
 * @author Georgi
 */
public class Actividad {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String nombre;
    private String descripcion;
    private TipoActividad tipoActividad;
    private Persona persona;

    public Actividad(LocalDate fechaInicio, LocalDate fechaFin, String nombre, String descripcion) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
