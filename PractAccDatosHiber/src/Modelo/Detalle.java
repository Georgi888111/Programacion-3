package Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Georgi
 */
@Entity
@Table(name = "Detalle")
public class Detalle  implements Serializable{
  private long id;
private int cantidad;
private ComprobanteCompra comprobante;
private Producto producto;

    public Detalle() {
    }



@Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numero")
    public ComprobanteCompra getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteCompra comprobante) {
        this.comprobante = comprobante;
    }

      @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigoBarras")
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }






}
