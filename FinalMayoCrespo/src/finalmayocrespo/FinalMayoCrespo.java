/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmayocrespo;

import java.util.Scanner;

/**
 *
 * @author Georgi
 */
public class FinalMayoCrespo {

//Punto A
    public static void main(String[] args) {
     int n = 0;
        while (true) {
            System.out.println("Ingrese un numero entre 1 y 100");
            Scanner s = new Scanner(System.in);
            n = s.nextInt();
            if (n >= 1 && n <= 100)
                break;
            else
                System.out.println("El número es inferior a 1 o mayor a 100. Reintente.");
        }
        tablaRecursiva(n, 1);

    }

    private static void tablaRecursiva(int n, int contador) {
        if (contador < 11) {
            System.out.println(n * contador);
            tablaRecursiva(n, ++contador);
        }
    }
    }
    

