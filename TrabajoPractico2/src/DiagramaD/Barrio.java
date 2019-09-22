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
public class Barrio {

    private long id;
    private String nombre;
    private String empresaConstructora;
    private ArrayList<Vivienda> viviendas;

    public void agregaVivienda(Vivienda vivienda) {
        this.viviendas.add(vivienda);
    }

    public void inicializaVivienda() {
        this.viviendas = new ArrayList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresaConstructora() {
        return empresaConstructora;
    }

    public void setEmpresaConstructora(String empresaConstructora) {
        this.empresaConstructora = empresaConstructora;
    }

    public double getSuperficieTotalTerreno() {

        double totalSuperficie = 0;
        for (int i = 0; i < this.viviendas.size(); i++) {
            totalSuperficie = totalSuperficie + this.viviendas.get(i).getSuperficieTerreno();
        }

        return totalSuperficie;
    }

    public double getSuperficieTotalCubierta() {
        double supTotalCubierta = 0;
        for (int i = 0; i < this.viviendas.size(); i++) {

            supTotalCubierta = supTotalCubierta + this.viviendas.get(i).getMetrosCuadradosCubiertos();
        }
        return supTotalCubierta;
    }
}
 

