/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1crespo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Georgi
 */
public class SucursalEmpresa {
  private String razonSocial;
private String cuit;  
private long telefono;
private String email;
private ArrayList<ProductoManufacturado> productos=new ArrayList();

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<ProductoManufacturado> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoManufacturado> productos) {
        this.productos = productos;
    }
//punto    a
    public ArrayList<ProductoManufacturado>getProductosXTiempoFabricacion(int tiempoMaximo){
        ArrayList<ProductoManufacturado>auxiliar = new ArrayList();
        for (ProductoManufacturado prodManu : this.productos) {
         if(prodManu.getMinutoTiempoFabricacion()<=tiempoMaximo){
             auxiliar.add(prodManu);
         }   
        }
        
        return auxiliar;
    }
    
    //punto b
    public String getSumaTotalTiempoFabricacion(ArrayList<String>codigos){
        int suma=0;
        for (ProductoManufacturado prodManu : this.productos) {
            for (int i = 0; i < codigos.size(); i++) {
              if(prodManu.getCodigo().equals(codigos.get(i))){
                  suma=suma+ prodManu.getMinutoTiempoFabricacion();
              }  
            }
        }
        
       String resultado = cambioDeFormato(suma);
       return resultado;
    }
    
    
    public String cambioDeFormato(int resultado) {
        String formato = "%02d:%02d";
        long horasReales = TimeUnit.MINUTES.toHours(resultado);
        long minutosReales = TimeUnit.MINUTES.toMinutes(resultado) - TimeUnit.HOURS.toMinutes(TimeUnit.MINUTES.toHours(resultado));
        return String.format(formato, horasReales, minutosReales);

    }

}
