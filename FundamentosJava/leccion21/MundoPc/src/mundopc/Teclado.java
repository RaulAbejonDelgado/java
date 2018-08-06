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
public class Teclado extends DispositivosEntrada{
    private int idTeclado;
    private static int contadorTeclados;
    private final String tipoEs= "Entrada";

    public Teclado() {
        this.idTeclado = contadorTeclados++;
    }

    public Teclado( String entrada, String marca) {
        super(entrada, marca);
        this.idTeclado = idTeclado;
    }

    @Override
    public String toString() {
        return "Teclado{" + "idTeclado=" + idTeclado + '}';
    }

    
    
}
