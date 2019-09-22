/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaB;

import java.time.LocalDate;


/**
 *
 * @author Georgi
 */
public class Asistencia {

    private long id;
    private String tipo;
    private LocalDate fecha;
    private int hora;
    private int minuto;
    private Empleado empleado;

    public Asistencia() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public boolean validaTipo(String tipoAsistencia) {
        boolean verificado = false;
        if ((tipoAsistencia.equalsIgnoreCase("E")) || (tipoAsistencia.equalsIgnoreCase("S"))) {
            verificado = true;
        }
        return verificado;
    }

    public boolean validaHora(int hora) {
        boolean verifica = false;
        if ((hora >= 0) && (hora <= 60)) {
            verifica = true;
        }
        return verifica;
    }

    public boolean validaMinuto(int minuto) {
        boolean verifica = false;
        if ((minuto >= 0) && (minuto <= 60)) {
            verifica = true;
        }
        return verifica;
    }

}
