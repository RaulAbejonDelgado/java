package datos;

import excepciones.*;

public class ImplementacionMySql implements AccesoDatos{

    private boolean simularError;

    @Override
    public void insertar() throws AccesoDatosEx {
        /**
         * Al tener 2 subclases de AccesoDatosEx podemos invocar metodos de clases hijas
         * throw new subclaseAccesoDatosEx("Error de escritura de datos");
         */
         if (simularError) {
            throw new EscrituraDatosEx("Error de escritura de datos");
        } else {
             System.out.println("Insertar desde MySql");
        }
    }

    @Override
    public void listar() throws AccesoDatosEx {
        if (simularError) {
            throw new LecturaDatosEx("Error de lectura de datos");
        } else {
            System.out.println("Listar desde MySql");
        }
    }

    public boolean isSimularError() {
        return simularError;
    }

  
    @Override
    public void simularError(boolean simularError) {
        this.simularError = simularError;
    }

}