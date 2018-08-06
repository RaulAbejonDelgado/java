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
public class Monitor extends DispositivosEntrada{
    private final String tipoEs= "Salida";
    private int idMonitor;
    private double tamanoMonitor;
    private static int contadorMonitor;

    public Monitor() {
        this.idMonitor = contadorMonitor++;
    }

    public Monitor(double tamanoMonitor, String entrada, String marca) {
        super(entrada, marca);
        this.tamanoMonitor = tamanoMonitor;
    }
    
    
}
