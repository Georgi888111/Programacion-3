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
//@Table(name = "Colegio")
public class Colegio  implements Serializable {
    private int id;
    private long numero;
    private String nombre;
    private String direccion;
     private List<Alumno>alumnos = new ArrayList();
//     
//   @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

//    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
     
     
     
   
}
