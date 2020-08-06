package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "ComprobanteCompra")
public class ComprobanteCompra  implements Serializable {
   private String fecha;
   private long numero;
   private Proveedor proveedor;
   private List<Detalle>detalles = new ArrayList();

    public ComprobanteCompra() {
    }
   
   
   

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
 @Id
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

 @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuit")
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

     @OneToMany(mappedBy = "comprobante", cascade = CascadeType.ALL)
    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "comprobante")
    public DatosAfip getDatosAfip() {
        return datosAfip;
    }

    public void setDatosAfip(DatosAfip datosAfip) {
        this.datosAfip = datosAfip;
    }
   private DatosAfip datosAfip;
       
       
       
   
}
