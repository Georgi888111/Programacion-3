package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "DatosAfip")
public class DatosAfip implements Serializable{
    
 private String codigoCae;
 private long fechaVencimientoCae;
 private ComprobanteCompra comprobante;

    public DatosAfip() {
    }
 
 
 
@Id
    public String getCodigoCae() {
        return codigoCae;
    }

    public void setCodigoCae(String codigoCae) {
        this.codigoCae = codigoCae;
    }

    public long getFechaVencimientoCae() {
        return fechaVencimientoCae;
    }

    public void setFechaVencimientoCae(long fechaVencimientoCae) {
        this.fechaVencimientoCae = fechaVencimientoCae;
    }

     @OneToOne(mappedBy = "datosAfip")
    public ComprobanteCompra getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteCompra comprobante) {
        this.comprobante = comprobante;
    }
 
 
 
}
