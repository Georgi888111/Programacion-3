/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2crespo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Georgi
 */
//@Entity
//@Table(name = "Catedra")
public class Catedra implements Serializable{
   private int id;
   private String denominacion;
   private long codigo;
   private List<Alumno>alumnos = new ArrayList();

    public Catedra() {
    }
   
   
   
//   @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
 
//    @ManyToMany(
//    cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//    mappedBy = "catedras",
//    targetEntity = Alumno.class)
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
   
   
   
}
