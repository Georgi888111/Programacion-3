/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
//@Entity
//@Table(name = "HistoriaClinicaDetalle")
public class Sintomas {
    private String denominacion;
    private int codigo;
    private boolean altoRiesgo;
    private ArrayList<HistoriaClinicaDetalle>detalles = new ArrayList();

    public Sintomas(String denominacion, int codigo, boolean altoRiesgo) {
        this.denominacion = denominacion;
        this.codigo = codigo;
        this.altoRiesgo = altoRiesgo;
    }

    public Sintomas() {
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
  // @Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isAltoRiesgo() {
        return altoRiesgo;
    }

    public void setAltoRiesgo(boolean altoRiesgo) {
        this.altoRiesgo = altoRiesgo;
    }
  //@ManyToMany(mappedBy = "sintomas", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public ArrayList<HistoriaClinicaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<HistoriaClinicaDetalle> detalles) {
        this.detalles = detalles;
    }
    
    
    
    
}
