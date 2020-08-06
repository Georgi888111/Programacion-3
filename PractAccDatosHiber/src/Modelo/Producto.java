package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "Producto")
public class Producto  implements Serializable{
   private String codigoBarras;
   private Double precio;
   private String nombre;
   private List<Proveedor>proveedores = new ArrayList();
   private List<Detalle>detalles = new ArrayList();

    public Producto() {
    }
   
   
   
 @Id
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ManyToMany(
    cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    mappedBy = "productos",
    targetEntity = Modelo.Proveedor.class)
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

      @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
   
   
   
}
