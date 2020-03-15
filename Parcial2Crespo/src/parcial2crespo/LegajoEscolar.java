/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2crespo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Georgi
 */
//@Entity
//@Table(name = "LegajoEscolar")
public class LegajoEscolar  implements Serializable{
    private int id;
    private double promedio;
    private Date fechaNacimiento;
    private String anioDivision;
    private Alumno alumno;

//    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getAnioDivision() {
        return anioDivision;
    }

    public void setAnioDivision(String anioDivision) {
        this.anioDivision = anioDivision;
    }

//      @OneToOne(cascade={CascadeType.ALL})
//    @JoinColumn(name = "legajoEscolar")
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    
    
    
}
