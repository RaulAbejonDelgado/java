package ejemplosobreescritura;

public class EjemploSobreescritura {

    public static void main(String[] args) {
        Empleado empleado = new Empleado("Rafa",1000);
        System.out.println( empleado.obtenerDetalles() );
        
        Gerente gerente = new Gerente("Karla",2000,"Diseño");
        System.out.println( gerente.obtenerDetalles() );
    }
}