/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1crespo;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Insumo {
    private String denominacion;
    private double precioCosto;
    private int stockActual;
    private String unidadMedida;
    private ArrayList<ProductoManufacturadoDetalle>detalles=new ArrayList();

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public ArrayList<ProductoManufacturadoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<ProductoManufacturadoDetalle> detalles) {
        this.detalles = detalles;
    }
    
    
}
