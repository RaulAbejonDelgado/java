package ejemploherencia;

public class EjemploHerencia {

    public static void main(String[] args) {
        Empleado e1 = new Empleado("Raul", 12000);
        System.out.println("Imprimimos el objeto Empleado1");
        System.out.println(e1);
        
        Empleado e2 = new Empleado("Borja", 24000);
        e2.setEdad(28);
        e2.setGenero('M');
        e2.setDireccion("Romo, Bizkaia");
        System.out.println("\nImprimimos el objeto Empleado2");
        System.out.println(e2);
        
        //Al crear un nuevo objeto de java.util.Date nos regresa la fecha actual
        Cliente c1 = new Cliente(new java.util.Date(), false);
        System.out.println("\nImprimimos el objeto Cliente1");
        System.out.println(c1);
        //Completamos el objeto persona asociado a este objeto cliente
        c1.setNombre("Alas");
        c1.setEdad(22);
        c1.setGenero('F');
        c1.setDireccion("Leioa, Bizkaia");
        System.out.println("\nVolvemos a imprimir el objeto cliente1");
        System.out.println(c1);
    }
}