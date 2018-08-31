package introduccionjdbc;
//Importamos para poder hacer operaciones con bases de datos
import java.sql.*;

public class IntroduccionJDBC {
    public static void main(String[] args) {
       //cadena de conexion de MySql, el parametro useSSL es opcional
       String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        try {
            //se carga en memoria la clase del driver mysql
            Class.forName("com.mysql.jdbc.Driver");
            //creamos el objeto de conexion
            Connection conexion = (Connection) DriverManager.getConnection(url,"root","admin");
            //creamos un objeto Statement para ejecutar secuencias apoyandonos del objeto conexion
            Statement instruccion = conexion.createStatement();
            //creamos la query en un String
            String slqQuery = "SELECT id_persona, nombre, apellido FROM personas";
            //ejecutamos el query y guardamos el retorno en una objeto tipo ResultSet apoyandonos en el objeto instruccion
            ResultSet resultado = instruccion.executeQuery(slqQuery);
            //procesamos el retorno
            //este proceso ira registro por registro con next() hasta que no haya mas registros
            while(resultado.next()){
                //por cada registro queremos obtener acceso a los campos de cada registro
                //por lo que con getInt(numeroDeColmunna)/getString(numeroDeColmunna) iremos obteniendo los dichos campos
                System.out.print("id: ->" +resultado.getInt(1));
                System.out.print("; Nombre: ->" +resultado.getString(2));
                System.out.print("; Apellido: ->" +resultado.getString(3));
                System.out.println("");
            }
             //cerramos los objetos
             resultado.close();
             instruccion.close();
             conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
}
