package ejemploconversionobjetos;

public enum TipoEscritura {

    CLASICO("Escritura a Mano"),
    MODERNO("Escritura digital");

    private final String descripcion;

    private TipoEscritura(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    //no añadimos el metodo set ya que descripcion lo hemos definido como una constante final

}