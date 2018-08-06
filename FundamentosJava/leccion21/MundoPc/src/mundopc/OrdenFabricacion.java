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
public class OrdenFabricacion {
    private static int contadorFabricacion;
    private int numeroFabricacion;
    private Computadora [] computadoras;
    private int contadorComputadoras;
    private int maxComputadoras = 10;

    public OrdenFabricacion() {
        this.numeroFabricacion = contadorFabricacion++;
         computadoras = new Computadora[maxComputadoras];
    }

    public OrdenFabricacion(Computadora[] computadoras) {
        this.computadoras = computadoras;
    }
    
    public void agregarComputadora(Computadora compu){
        if (contadorComputadoras < maxComputadoras){
            computadoras[contadorComputadoras] = compu;
            contadorComputadoras++;
        }
    }
     public void mostrarOrden() {
        System.out.println("Orden #:" + numeroFabricacion);
        //System.out.println("Total de la orden #"+ numeroFabricacion + ": €" + calcularTotal());
        System.out.println("Productos de la orden #" + numeroFabricacion + ":");
        for (int i = 0; i < contadorComputadoras; i++) {
            System.out.println(computadoras[i]);
        }
    }
    
    
    
    
}
