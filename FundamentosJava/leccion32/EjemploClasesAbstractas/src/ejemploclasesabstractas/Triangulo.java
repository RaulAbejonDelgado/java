/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploclasesabstractas;

/**
 *
 * @author drohne
 */
public class Triangulo extends FiguraGeometrica{
    /**
     * Al heredar de una clase abstracta nos obliga a usar los metodos abstractos
     * @param tipoFigura
     */
    
   
   public Triangulo(String tipoFigura) {
        super(tipoFigura);
    }

    public void dibujar() {
        //Comportamiento de la subclase
        System.out.println("Aquí debería dibujar un:" + this.getClass().getSimpleName());
    }
}
