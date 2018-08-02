package ciclos;

import java.util.Scanner;

public class CicloWhileV2 {

    public static void main(String[] args) {
        System.out.println("Por favor introduce el número de elementos a iterar:");
        int maxElementos;
        //Creacion de objeto Scanner para leer datos
        Scanner entradaEscaner = new Scanner(System.in); 
        //Leemos el valor proporcionado por el usuario
        maxElementos = entradaEscaner.nextInt(); 
        int contador = 0;
        while (contador < maxElementos) {
            System.out.println("contador = " + contador);
            contador++;
        }
    }
}