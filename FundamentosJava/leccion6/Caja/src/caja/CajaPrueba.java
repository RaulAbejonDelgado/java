/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caja;



/**
 *
 * @author drohne
 */
public class CajaPrueba {
    

     public static void main(String args[]){
         Caja cajaPrueba = new Caja(5,3,4);
         System.out.println("El volumen de la caja es : " + cajaPrueba.calcularVolumen());
    }

}