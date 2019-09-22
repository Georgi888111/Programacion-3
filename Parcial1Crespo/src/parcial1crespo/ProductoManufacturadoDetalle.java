/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1crespo;

/**
 *
 * @author Georgi
 */
public class ProductoManufacturadoDetalle {
   private int cantidad;
   private ProductoManufacturado productoManuf;
   private Insumo insumo;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoManufacturado getProductoManuf() {
        return productoManuf;
    }

    public void setProductoManuf(ProductoManufacturado productoManuf) {
        this.productoManuf = productoManuf;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
   
   
}
