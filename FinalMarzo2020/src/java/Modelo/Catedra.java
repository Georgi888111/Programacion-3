/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Data.Conexion;
import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class Catedra {

    private int codigo;
    private String denominacion;
    private Conexion conexion;

    public Catedra() {
        this.conexion = new Conexion();
    }

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

    public ArrayList<Catedra> traeCatedras() {

        ArrayList<Catedra> catedras = new ArrayList();

        catedras = this.conexion.traeCatedras();
        return catedras;

    }

}
