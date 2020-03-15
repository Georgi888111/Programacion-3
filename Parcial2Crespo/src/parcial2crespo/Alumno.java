/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2crespo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Georgi
 */
@Entity
@Table(name = "Alumno")
public class Alumno  implements Serializable {
    private int id;
    private String codigo;
    private String apellido;
    private int dni;
     private List<Catedra>catedras = new ArrayList();
     private LegajoEscolar legajo;
     private Colegio colegio;

   @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @ManyToMany(fetch=FetchType.LAZY,
    targetEntity= Alumno.class,
    cascade=CascadeType.ALL)
    @JoinTable(
    name="Alumno_Catedra",
    joinColumns=@JoinColumn(name="id"),
    inverseJoinColumns=@JoinColumn(name="id"))
    public List<Catedra> getCatedras() {
        return catedras;
    }

    public void setCatedras(List<Catedra> catedras) {
        this.catedras = catedras;
    }

       @OneToOne(mappedBy = "alumno")
    public LegajoEscolar getLegajo() {
        return legajo;
    }

    public void setLegajo(LegajoEscolar legajo) {
        this.legajo = legajo;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }
     
     
     
     
   
    
}
