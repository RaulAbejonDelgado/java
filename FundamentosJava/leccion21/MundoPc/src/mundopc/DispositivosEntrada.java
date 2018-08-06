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
public class DispositivosEntrada {
       private String tipoEs;
       private String marca;

    
    public DispositivosEntrada() {
    }
    public DispositivosEntrada(String entrada, String marca) {
        this.tipoEs = entrada;
        this.marca = marca;
    }

   
    public String getEntrada() {
        return tipoEs;
    }
    public void setEntrada(String entrada) {
        this.tipoEs = entrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String toString() {
        return "DispositivosEntrada{" + "Tipo de entrada=" + tipoEs + ", marca=" + marca + '}';
    }
   
    
   
}
