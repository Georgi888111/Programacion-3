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
public class Genericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ClaseA<String,Integer>claseA;
        claseA = new ClaseA<String,Integer>();
        claseA.setAtributo("Vamos a la playa");
        claseA.setAtributo2(1);
        ArrayList<Integer> numeros = new ArrayList();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));     
        }
        
        claseA.intercambiaLugares(numeros, 1, 3);
       for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros);     
        }
    }
    
}
