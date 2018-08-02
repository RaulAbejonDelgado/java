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
public class Caja {
    
    int alto, ancho, profundo;
    
    public Caja() {
        this.alto = 0;
        this.ancho = 0 ;
        this.profundo = 0;
    }

    public Caja(int alto, int ancho, int profundo) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
    }
    
    public int calcularVolumen(){
        return alto * ancho * profundo;
    }
    
    
    
    
}
