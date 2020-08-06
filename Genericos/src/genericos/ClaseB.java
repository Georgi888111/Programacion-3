/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericos;

/**
 *
 * @author Georgi
 */
public class ClaseB<T> {
    
       private T atributo;
       private T atributo2;

    public void setAtributo(T atr) {
        atributo = atr;
    }

    public T getAtributo() {
        return atributo;
    } 

    public T getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(T atributo2) {
        this.atributo2 = atributo2;
    }
    
    
    
}
