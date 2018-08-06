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
public class Raton extends DispositivosEntrada{
    private int idRaton;
    private static int contadorRatones;
    private final String tipoEs= "Entrada";

    public Raton() {
        this.idRaton = contadorRatones++;
    }

    public Raton(String entrada, String marca) {
        super(entrada, marca);
        this.idRaton = idRaton;
    }

    @Override
    public String toString() {
        return "Raton{" + "idRaton=" + idRaton + '}';
    }
    
}
