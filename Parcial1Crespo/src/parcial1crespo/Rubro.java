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
public class Rubro {
    private String denominacion;
    private ArrayList<ProductoManufacturado>productos=new ArrayList();
    private ArrayList<Rubro>rubros=new ArrayList();
    private Rubro rubro;

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public ArrayList<ProductoManufacturado> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoManufacturado> productos) {
        this.productos = productos;
    }

    public ArrayList<Rubro> getRubros() {
        return rubros;
    }

    public void setRubros(ArrayList<Rubro> rubros) {
        this.rubros = rubros;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    
//punto e
public ArrayList< ProductoManufacturado> getProductosXRubro(){
        ArrayList<ProductoManufacturado> productosAux = new ArrayList();
        recorreRubros(this,productosAux);
        
        return productosAux;
    }
    
    private void recorreRubros(Rubro rubro, ArrayList<ProductoManufacturado> productosRubro) {
       if(rubro.getProductos()!=null && !this.getProductos().isEmpty()){
            for(ProductoManufacturado productos : rubro.getProductos()){
                productosRubro.add(productos);
            }
        }
       if(rubro.getRubros()!=null){
           for(Rubro r : rubro.getRubros()){
               recorreRubros(r,productosRubro);
               
           }
       }
       
    }
 

   
  //punto f
    
  public ProductoManufacturado getProductoMayorPrecio(){
        ProductoManufacturado productoMayor = new ProductoManufacturado();
        double precioMayor=0;
        ArrayList<ProductoManufacturado> productos = this.getProductosXRubro();
        for(ProductoManufacturado prod : productos){
            prod.getPrecioVentaCalculado();
            if(prod.getPrecioVenta()>precioMayor){
                precioMayor=prod.getPrecioVenta();
                productoMayor = prod;
            }
        }
        return productoMayor;
    }
}
