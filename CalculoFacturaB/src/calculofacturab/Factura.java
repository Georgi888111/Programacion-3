/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculofacturab;

import calculofacturab.DetalleFactura;
import calculofacturab.Cliente;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Georgi
 */
public class Factura {
    private String letra;
    private int numero;
    private double recargo;
    private String tipoPago;
    private double totalItems;
    private double totalFinal;
    private String date;
    private ArrayList <DetalleFactura> detalles = new ArrayList();
    private Cliente cliente;

    public Factura() {
        
    }


   public ArrayList<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
     public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(double totalItems) {
        this.totalItems = totalItems;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
     public void addDetalle(DetalleFactura detallesFact) {
       detalles.add(detallesFact);
    }
    
    public void calcularTotalItems(){
   
       
    if (this.getDetalles() != null && !this.getDetalles().isEmpty()) {
            for (DetalleFactura df : this.getDetalles()) {
                df.calcularSubtotal();
                this.totalItems += df.calcularSubtotal();

            }
    }
      
      

        }
    
    public void calcularConRecargo(){
   
        if(this.tipoPago.equalsIgnoreCase("TD")){
           this.recargo = this.totalItems*0.05;
        }else if (this.tipoPago.equalsIgnoreCase("TC")){
            this.recargo = this.totalItems*0.1;
        }else{
            this.recargo = 0;
        }
        
        this.totalFinal = this.totalItems+this.recargo;
     
    }
    
    public boolean validaTipoPago(String tipo){
        boolean tipoPago = false;
        if((tipo.equalsIgnoreCase("C"))||(tipo.equalsIgnoreCase("TD"))||(tipo.equalsIgnoreCase("TC"))){
            tipoPago=true;
        }else{
            System.out.println("El tipo de pago no es válido");
            tipoPago=false;
        }
        return tipoPago;
    }
    public boolean validaLetra(String letra){
     boolean letraValida= false;
     if((letra.equalsIgnoreCase("A"))||(letra.equalsIgnoreCase("C"))||(letra.equalsIgnoreCase("B"))){
         letraValida= true;
     }else{
         System.out.println("La letra ingresada no corresponde a un tipo de factura");
         letraValida = false;
     }
     return letraValida;
    }

    
}



  