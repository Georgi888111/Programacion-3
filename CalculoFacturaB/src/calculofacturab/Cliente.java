/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculofacturab;
import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Cliente {
    private int numero;
    private String razonSocial;
    private long cuit;
    private ArrayList <Factura>facturas = new ArrayList(); 

    public Cliente() {
        
    }

    public Cliente(int numero, String razonSocial, long cuit) {
        this.numero = numero;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
  public void addFactura(Factura facturaCliente) {
       facturas.add(facturaCliente);
    }
    
    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

  public double totalComprasCliente(){
    double totalCliente=0;
      if (this.getFacturas() != null && !this.getFacturas().isEmpty()) {
            for (Factura fac : this.getFacturas()) {
                fac.calcularTotalItems();
                totalCliente += fac.getTotalFinal();

            }
        }
      return totalCliente;
  }
    
    
    
    
    
}
