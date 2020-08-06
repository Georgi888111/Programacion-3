/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Georgi
 */
public class Alumno {

    private long legajo;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Catedra catedra;
    private ArrayList<Nota> notas = new ArrayList();

    public Alumno(long legajo, String nombre, String apellido, Date fechaNacimiento, Catedra catedra) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.catedra = catedra;
    }

    public Alumno() {
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Catedra getCatedra() {
        return catedra;
    }

    public void setCatedra(Catedra catedra) {
        this.catedra = catedra;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public Nota mejorNota(Integer codigoCatedra) {
        Nota mayor = new Nota();
        if (codigoCatedra != null) {
            for (Nota nota : notas) {
                if ((nota.getCatedra().getCodigo() == codigoCatedra) && (!nota.isEsRecuperatorio())) {
                    if (mayor.getValor() < nota.getValor()) {
                        mayor = nota;
                    }
                }
            }
  } else {
            for (Nota nota2 : notas) {
                if (mayor.getValor() < nota2.getValor()) {
                    mayor = nota2;
                }

            }

        }
        return mayor;
    }

   public double promedioNotas(Integer codigoCatedra){
      double promedio=0;
      double suma=0;
      int contador=0;
       if(codigoCatedra!=null){
           for (Nota nota : notas) {
             if(nota.getCatedra().getCodigo()==codigoCatedra)  {
                 suma=suma+nota.getValor();
                 contador++;
             }
           }
           promedio = suma/contador;
       }else{
           for (Nota nota : notas) {
               suma=suma+nota.getValor();
               
           }
           promedio = suma/notas.size();
       }
       return promedio;
   } 
   
   public boolean notasSinRecuperar(){
       boolean recupera = false;
       for (Nota nota : notas) {
        if(nota.isEsRecuperatorio()){
            recupera =  true;
          break;
        } else{
            recupera = false;
        }  
       }
       return recupera;
   }
   
}
