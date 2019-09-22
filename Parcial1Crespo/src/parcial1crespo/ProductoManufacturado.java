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
public class ProductoManufacturado {
   private int minutoTiempoFabricacion;
   private String denominacion;
   private double precioVenta;
   private double margenGanancia;
   private String codigo;
   private ArrayList<ProductoManufacturadoDetalle>detalles=new ArrayList();
   private Rubro rubro;
   private ArrayList<SucursalEmpresa>sucursales=new ArrayList();

    public int getMinutoTiempoFabricacion() {
        return minutoTiempoFabricacion;
    }

    public void setMinutoTiempoFabricacion(int minutoTiempoFabricacion) {
        this.minutoTiempoFabricacion = minutoTiempoFabricacion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

   

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public ArrayList<ProductoManufacturadoDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<ProductoManufacturadoDetalle> detalles) {
        this.detalles = detalles;
    }

    public ArrayList<SucursalEmpresa> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList<SucursalEmpresa> sucursales) {
        this.sucursales = sucursales;
    }
//punto c
  public double getPrecioCostoProducto(){

      double precioCosto=0;
      for (ProductoManufacturadoDetalle detalle : this.detalles) {
      precioCosto=precioCosto+detalle.getInsumo().getPrecioCosto()*detalle.getCantidad();
      }
    
     return precioCosto;
  }
  //punto d
 public void getPrecioVentaCalculado(){
        double ganancia;
        ganancia = getPrecioCostoProducto()*this.margenGanancia;
        this.precioVenta = getPrecioCostoProducto()+ganancia;
        
    }
   
  
}
