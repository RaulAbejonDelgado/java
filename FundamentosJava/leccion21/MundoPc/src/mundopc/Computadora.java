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
public class Computadora {
    private static int idComputadora;
    private String nombreComputadora;
    private Monitor monitorSerie;
    private Teclado tecladoSerie;
    private Raton ratonSerie;

    public Computadora() {
        this.idComputadora = idComputadora++;
    }
    
    
    public Computadora(String nombreComputadora, Monitor monitorSerie, Teclado tecladoSerie, Raton ratonSerie) {
        this.nombreComputadora = nombreComputadora;
        this.monitorSerie = monitorSerie;
        this.tecladoSerie = tecladoSerie;
        this.ratonSerie = ratonSerie;
    }

    public String getNombreComputadora() {
        return nombreComputadora;
    }

    public void setNombreComputadora(String nombreComputadora) {
        this.nombreComputadora = nombreComputadora;
    }

    public Monitor getMonitorSerie() {
        return monitorSerie;
    }

    public void setMonitorSerie(Monitor monitorSerie) {
        this.monitorSerie = monitorSerie;
    }

    public Teclado getTecladoSerie() {
        return tecladoSerie;
    }

    public void setTecladoSerie(Teclado tecladoSerie) {
        this.tecladoSerie = tecladoSerie;
    }

    public Raton getRatonSerie() {
        return ratonSerie;
    }

    public void setRatonSerie(Raton ratonSerie) {
        this.ratonSerie = ratonSerie;
    }

    @Override
    public String toString() {
        return "Computadora{" + "nombreComputadora=" + nombreComputadora + ", monitorSerie=" + monitorSerie + ", tecladoSerie=" + tecladoSerie + ", ratonSerie=" + ratonSerie + '}';
    }
    
    
}
