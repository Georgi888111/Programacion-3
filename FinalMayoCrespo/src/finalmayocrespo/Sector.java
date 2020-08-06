/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmayocrespo;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
 //@Entity
//@Table(name = "Sector")
public class Sector {
    private int codigo;
    private String denominacion;
    
    private ArrayList<Empleado>empleados = new ArrayList();

    public Sector(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public Sector() {
    }
   //@Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

  //@OneToMany(mappedBy = "sector", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
public Empleado getMejorSueldo(int mes, int anio) {
        Empleado mejorSueldo = this.empleados.get(0);
        for (Empleado empleado : empleados) {
            if (mejorSueldo.getTotalBonoSueldoXPeriodo(mes, anio) < empleado.getTotalBonoSueldoXPeriodo(mes, anio)) {
                mejorSueldo = empleado;
            }
        }
        return mejorSueldo;
    }


}