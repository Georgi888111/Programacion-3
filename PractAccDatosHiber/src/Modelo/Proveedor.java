package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "Proveedor")
public class Proveedor implements Serializable {
    private String razonSocial;
    private long cuit;
    private String categoria;
    private List<Producto>productos = new ArrayList();
    private List<ComprobanteCompra>comprobantes = new ArrayList();

    public Proveedor() {
    }
    
    
    

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
   @Id
    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

     @ManyToMany(fetch=FetchType.LAZY,
    targetEntity=Modelo.Producto.class,
    cascade=CascadeType.ALL)
    @JoinTable(
    name="PROVEEDOR_PRODUCTO",
    joinColumns=@JoinColumn(name="cuit"),
    inverseJoinColumns=@JoinColumn(name="codigoBarras"))
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

   @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    public List<ComprobanteCompra> getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(List<ComprobanteCompra> comprobantes) {
        this.comprobantes = comprobantes;
    }
    
    
    
    
    
}
