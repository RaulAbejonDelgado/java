/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundopc;

/**
 *
 * @author drohne
 */
public class MundoPc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creamos los perifericos
        Raton rat1 = new Raton("Entrada","Raton-Logitech");
        Teclado tecl1 = new Teclado("Entrada","Teclado G-Move");
        Monitor mon1 = new Monitor(17.3,"Salida","Monitor Acer");
        
        //creamos la computadora
        Computadora comp1 = new Computadora("Pc-Prototipo 1",mon1,tecl1,rat1);
        
        //creamos la orden de fabricacion
        OrdenFabricacion ord1 = new OrdenFabricacion();
        
        //agregamos un ordenador a la orden
        ord1.agregarComputadora(comp1);
        ord1.mostrarOrden();
    }
    
}
