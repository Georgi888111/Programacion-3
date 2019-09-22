/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuela;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author Georgi
 */
public class Alumno {
   private long legajo;
   private String nombre;
   private String apellido;
   private LocalDate fechaNacimiento;
   private Catedra catedra;
   private ArrayList<Nota>notas;

    public Alumno(long legajo, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Alumno() {
    }
   
   
   
   

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

   
   
   
   public void inicializaNotas(){
       notas = new ArrayList();
   }

   public void agregaNota(Nota nota){
       this.notas.add(nota);
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
        Nota notaAux = new Nota();
        if (codigoCatedra != null) {
            for (int i = 0; i < this.notas.size(); i++) {
                if ((this.notas.get(i).getCatedra().getCodigo() == codigoCatedra) && (!notas.get(i).isEsRecuperatorio())) {
                    if (this.notas.get(i).getValor() > notaAux.getValor()) {
                        notaAux = this.notas.get(i);

                    }

                } else {
                    if (this.notas.get(i).getValor() > notaAux.getValor()) {
                        notaAux = this.notas.get(i);
                    }
                }

            }
        } else {
            for (int i = 0; i < notas.size(); i++) {
                if (this.notas.get(i).getValor() > notaAux.getValor()) {
                    notaAux = this.notas.get(i);
                }
            }

        }
        return notaAux;
    }

    public double promedioNotas(Integer codigoCatedra) {

        double suma = 0, promedio = 0;
        int cantidad = 0;
        if (codigoCatedra != null) {
            for (int i = 0; i < this.notas.size(); i++) {
                if (notas.get(i).getCatedra().getCodigo() == codigoCatedra) {
                    cantidad++;
                    suma = suma + notas.get(i).getValor();

                } else {
                    cantidad++;
                    suma = suma + notas.get(i).getValor();

                }

            }

            promedio = suma / cantidad;

        } else {
            for (int i = 0; i < notas.size(); i++) {
                cantidad++;
                suma = suma + notas.get(i).getValor();
            }
            promedio = suma / cantidad;
        }
        return promedio;

    }
}
