/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclos;

import java.util.Scanner;

/**
 *
 * @author drohne
 */
public class CicloDoWhilev2 {
    public static void main(String[] args) {
        System.out.println("Por favor introduce el número de elementos a iterar:");
        int maxElementos;
        //Creacion de objeto Scanner para leer datos
        Scanner entradaEscaner = new Scanner(System.in); 
        //Leemos el valor proporcionado por el usuario
        maxElementos = entradaEscaner.nextInt(); 
        int contador = 0;
        do{
            System.out.println("contador = " + contador);
            contador++;
        }
        while (contador < maxElementos);
    }
}
