package manejoexcepciones1;

import domain.*;

public class ManejoExcepciones1 {

    public static void main(String[] args) {

        try {
            Division division = new Division(10, 0);
            division.visualizarOperacion();
        } catch (OperacionExcepcion oe) {
            System.out.println("Ocurrió un error!!!");
            oe.printStackTrace();
        }

    }

}