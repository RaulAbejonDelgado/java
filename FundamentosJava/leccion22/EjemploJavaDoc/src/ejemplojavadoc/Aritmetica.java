/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojavadoc;

/**
 * Esta clase permite realizar operaciones de aritmetica como sumar, restar, etc
 *
 * @author: Raul Abejon
 * @version: 1.0
 */
public class Aritmetica {

    /**
     * Primer Operando
     */
    int operandoA;

    /**
     * Segundo operando
     */
    int operandoB;

    /**
     * Constructor de la clase
     * @param a Recibe el valor para el operando A
     * @param b Reciboe el valor para el operando B
     */
    public Aritmetica(int a, int b) {
        this.operandoA = a;
        this.operandoB = b;
    }
    
    /**
     * Este metodo realiza la suma de dos operandos enteros
     * @return int resultado de la suma 
     */
    public int sumar(){
        return operandoA + operandoB;
    }

}
