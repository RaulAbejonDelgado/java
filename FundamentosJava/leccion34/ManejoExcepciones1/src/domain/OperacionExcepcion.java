package domain;


public class OperacionExcepcion extends Exception {

    public OperacionExcepcion(String mensaje) {
        //Inicializamos el mensaje de error de la clase padre
        super(mensaje);
    }
}