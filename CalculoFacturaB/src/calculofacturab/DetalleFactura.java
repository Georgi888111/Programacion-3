package calculofacturab;

import calculofacturab.Articulo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Georgi
 */
public class DetalleFactura {
    private double cantidad;
    private double subtotal;
    private Articulo articulo;


    public DetalleFactura() {
        
    }
    
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

   

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public double calcularSubtotal(){
        this.subtotal = this.cantidad * this.getArticulo().getPrecio();
        return subtotal;
    }
}
