/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name = "Expediente")
public class Expediente implements Serializable{
    
    private int id;
    private String letra;
    private int numero;
    private String descripcion;
    private String tipo;
    private String ambito;
    private ArrayList<Control>controles = new ArrayList();
     private ArrayList<Expediente> expedientes =  new ArrayList();
     private Expediente expediente;
     private ArrayList<EstadoControl> estados = new ArrayList();    

     
     @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "ExpedienteControl", joinColumns = {@JoinColumn(name="id_control")}, inverseJoinColumns = {@JoinColumn(name="id_expediente")})
    public ArrayList<Control> getControles() {
        return controles;
    }

    public void setControles(ArrayList<Control> controles) {
        this.controles = controles;
    }

       @OneToMany(mappedBy = "expediente", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)

    public ArrayList<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ArrayList<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_expediente")
    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

         
   @OneToMany(mappedBy = "expediente", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public ArrayList<EstadoControl> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<EstadoControl> estados) {
        this.estados = estados;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getCaratulaExpediente() {
        String numeroCadena = String.valueOf(this.numero);
        return numeroCadena + "-" + this.letra + "-" + this.descripcion;
    }

    public String getControlesObligatorios() {
        String listaDenomi = "";
        for (Control controle : this.controles) {
            if (controle.isEsObligatorio()) {
                listaDenomi += controle.getDenominacion() + " ,";
            }
        }
        return listaDenomi;
    }

    public boolean getEstadoControles() {

        boolean estados = true;
        for (Control controle : controles) {
            if (controle.isEsObligatorio()) {
                for (EstadoControl estadosControle : controle.getEstadosControles()) {
                    if (!estadosControle.isAprobado()) {
                        estados = false;
                        break;
                    } else {
                        estados = true;
                    }
                }

            }

        }

        return estados;
    }
    
    //Se llama al metodo que retorna el array, si el objeto creado en el main no esta vacio de expedientes 
    //Se declara un array nuevo que sera el retornado al llamar al metodo recursivo, con el objeto utilizado y el array creado.
    public ArrayList<Expediente>listaExpedientes(){
        if(this.getExpedientes().isEmpty()||this.getExpedientes()==null){
            return null;
        }else{
            
         ArrayList<Expediente>listaExpedientes = new ArrayList(); 
           return this.auxiliarRecursivo(this,listaExpedientes);  
        }
    
       
    }

    //Se recorren los expedientes que tiene el array de expedientes del objeto enviado por parametro.
    //y se agregan los expedientes al array enviado por parametro
    //se llama al algoritmo resursivo nuevamente mandando el primer objeto que aparezca dentro del array del objeto que se envio en primer instancia.
    //Luego de recorrer todo se retorna ese array cargado
   public ArrayList<Expediente>auxiliarRecursivo(Expediente expediente, ArrayList<Expediente> expedientes){
   
        expedientes.add(expediente);
       for (Expediente exp : expediente.getExpedientes()) {
          
            auxiliarRecursivo(exp, expedientes);
       }
           return expedientes;
       }
   }

  