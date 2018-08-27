package ejemploinsteceof;

public class EjemploInstanceOf {

    public static void main(String[] args) {

        FiguraGeometrica figura;

        figura = new Rectangulo();
        //Determina solo un tipo el que corresponda con la jerarquia
        
        determinaTipo(figura);
        //Determina todos los tipos posibles
        
        System.out.println("\nTodos sus tipos:");
        determinaTodosLosTipos(figura);
        
        //Mas ejemplos

        figura = new Triangulo();
        determinaTipo(figura);

        figura = new Rectangulo();
        determinaTipo(figura);

        figura = new Circulo();
        determinaTipo(figura);
    }

    private static void determinaTodosLosTipos(FiguraGeometrica figura) {
        if (figura instanceof Elipse) {
            //Procesa algo particular de la Elipse
            System.out.println("Es una Elipse");
        } 
        if (figura instanceof Circulo) {
            //Procesa algo particular del Circulo
            System.out.println("Es un Circulo");
        } 
        if (figura instanceof Triangulo) {
            //Procesa algo particular del Circulo
            System.out.println("Es un Triangulo");
        } 
        if (figura instanceof Rectangulo) {
            //Procesa algo particular del Circulo
            System.out.println("Es un Rectangulo");
        } 
        if (figura instanceof FiguraGeometrica) {
            //Procesa algo particular de la Figura Geometrica
            System.out.println("Es una Figura Geometrica");
        } 
        if (figura instanceof Object) {
            //Procesa algo particular de la clase Object
            System.out.println("Es un Object");
        } else {
            System.out.println("No se encontró el tipo");
        }
    }

        private static void determinaTipo(FiguraGeometrica figura) {
        if (figura instanceof Elipse) {
            //Procesa algo particular de la Elipse
            System.out.println("Es una Elipse");
        } else if (figura instanceof Circulo) {
            //Procesa algo particular del Circulo
            System.out.println("Es un Circulo");
        } 
        if (figura instanceof Triangulo) {
            //Procesa algo particular del triangulo
            System.out.println("Es un Triangulo");
        }
        if (figura instanceof Rectangulo) {
            //Procesa algo particular del rectangulo
            System.out.println("Es un Rectangulo");
        }
        if (figura instanceof FiguraGeometrica) {
            //Procesa algo particular de la clase Object
            System.out.println("Es una Figura Geometrica");
        }
        if (figura instanceof Object) {
            //Procesa algo particular de la clase Object
            System.out.println("Es un Object");
        } else {
            System.out.println("No se encontró el tipo");
        }
    }
}