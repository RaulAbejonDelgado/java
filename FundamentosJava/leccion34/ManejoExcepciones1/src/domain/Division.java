package domain;

public class Division {

    //atributo de la clase
    private int numerador;
    //atributo de la clase
    private int denominador;

    /**
     * Construye el objeto División
     *
     * @param numerador int
     * @param denominador int
     * @throws domain.OperacionExcepcion
     */
    public Division(int numerador, int denominador) throws OperacionExcepcion {

        if (denominador == 0) {
            //throw new IllegalArgumentException("Denominador igual a cero");
            throw new OperacionExcepcion("Denominador igual a cero");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void visualizarOperacion() {
        System.out.println("El resultado de la división es: " + numerador / denominador);
    }
}