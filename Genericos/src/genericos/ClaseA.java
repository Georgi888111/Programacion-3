/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericos;

import java.util.ArrayList;

/**
 *
 * @author Georgi
 */
public class ClaseA<T,T1> {

    private T atributo;
    private T1 atributo2;

    public void setAtributo(T atr) {
        atributo = atr;
    }

    public T getAtributo() {
        return atributo;
    }

    public T1 getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(T1 atributo2) {
        this.atributo2 = atributo2;
    }

//    public <T> int cuentaPares(ArrayList<T> coleccion){
//        int contador =0;
//        for (T t : coleccion) {
//        if((t%2)==0){
//           contador++; 
//        }    
//        }
//        return contador;
//    }
    
    public void intercambiaLugares(ArrayList<T1>coleccion, int posicion1, int posicion2){
           coleccion.set(posicion1, coleccion.get(posicion2));
          coleccion.set(posicion2, coleccion.get(posicion1));
           
           
    }
}