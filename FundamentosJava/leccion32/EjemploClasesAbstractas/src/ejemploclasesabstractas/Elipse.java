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
public class Elipse extends Circulo{

    public Elipse(String tipoFigura) {
        super(tipoFigura);
    }
   /**
    * Si heredamos de una clase superior heredada de una clase abstracta en este nivel
    * no nos obliga a implementar el metodo abstracto superior
    */
    public void dibujarDesdeClaseSegundoNivel(){
        System.out.println("dibujar Elipse");
    }
}
