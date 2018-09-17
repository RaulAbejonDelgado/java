
package datos;
import pojo.Persona;
import java.sql.*;
import java.util.*;
/**
 *Clase encargada de hacer las operaciones de insert select update o select
 * @author drohne
 */
public class PersonasJDBC {
    private final String SQL_INSERT = "INSERT INTO personas(nombre,apellido) VALUES(?,?)";
    private final String SQL_UPDATE ="UPDATE personas SET nombre=?,apellido=? WHERE id_persona=?";
    private final String SQL_SELECT ="SELECT * FROM personas ORDER BY id_persona";
    private final String SQL_DELETE ="DELETE from personas WHERE id_persona=?";
    
    //leccion 4
    private java.sql.Connection userConn;
    //leccuib 4
    public PersonasJDBC(Connection conn){
        this.userConn = conn;
    }

    public PersonasJDBC() {
       
    }
    
    //funcion INSERT
    
    public int insertar(String nombre, String apellido) throws SQLException{
        //Creamos los objetos de conexion, statement para ejecutar las querys
        //y resulset para el retorno
        Connection conexion = null;
        //PreparedStatement estamento = null;
        PreparedStatement estamento = null;  
        ResultSet resultado = null;
        //donde guardaremos el numero de registros afectados
        int rows = 0 ;
        try {
            conexion = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            estamento = conexion.prepareStatement(SQL_INSERT);
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            int index = 1;
            estamento.setString(index++, nombre);//parametro 1
            estamento.setString(index++, apellido);//parametro 2
            System.out.println("INSERTANDO ");
            //nos devuelve un entero representado el numero de registros afectados por la query
            rows = estamento.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        }finally{
            //leccion 4
            //Para mantener activa la conexion
            if (this.userConn == null){
                Conexion.close(conexion);
            }
        }
        return rows;
    }
    
    public int actualizar(int idPersona, String nombre, String apellido) throws SQLException{
        //Creamos los objetos de conexion, statement para ejecutar las querys
        //y resulset para el retorno
        Connection conexion = null;
        //PreparedStatement estamento = null;
        PreparedStatement estamento = null;  
        ResultSet resultado = null;
        //donde guardaremos el numero de registros afectados
        int rows = 0;
        if(idPersona > 0){
            try {
            conexion = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            estamento = conexion.prepareStatement(SQL_UPDATE);
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            int index = 1;
           
            estamento.setInt(index++, idPersona);//parametro 1
            estamento.setString(index++, nombre);//parametro 2
            estamento.setString(index++, apellido);//parametro 3
            System.out.println("ACTUALIZANDO");
            rows = estamento.executeUpdate();
                
            } finally{
                //Para mantener viva la conexion a la bd
                if(this.userConn == null) {
                    this.userConn = Conexion.getConnection();
                }
            }
        }
        
        return rows;
    }
    
    public ArrayList<Persona> seleccionar() throws SQLException{
        //Creamos los objetos de conexion, statement para ejecutar las querys
        //y resulset para el retorno
        Connection conexion = null;
        //PreparedStatement estamento = null;
        PreparedStatement estamento = null;  
        ResultSet resultado = null;
        //donde guardaremos el numero de registros afectados
        ArrayList<Persona> personasArray = new ArrayList<>();
        int rows = 0;
            try {
            conexion = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            estamento = conexion.prepareStatement(SQL_SELECT);
            resultado = estamento.executeQuery();
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            while(resultado.next()){
                //System.out.println("Id -> "+resultado.getInt(1));
                //resultado.getString("Nombre -> "+resultado.getString(2));
                //resultado.getString("Apellido -> "+resultado.getString(3));
                personasArray.add(new Persona(resultado.getInt(1),resultado.getString(2),resultado.getString(3)));
            }
            
                
            } finally{
                Conexion.close(resultado);
                if(userConn == null){
                    userConn= Conexion.getConnection();
                }
                
            }
        return personasArray;
    
    }
    
    public int borrar(int idPersona) throws SQLException{
        //Creamos los objetos de conexion, statement para ejecutar las querys
        //y resulset para el retorno
        Connection conexion = null;
        //PreparedStatement estamento = null;
        PreparedStatement estamento = null;  
        ResultSet resultado = null;
        //donde guardaremos el numero de registros afectados
        int rows = 0;
        if(idPersona > 0){
            try {
            conexion = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            estamento = conexion.prepareStatement(SQL_DELETE);
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            int index = 1;      
            estamento.setInt(index++, idPersona);//parametro 1
            System.out.println("Eliminando");
            rows = estamento.executeUpdate();
                
            } finally{
                
                if(userConn == null){
                    userConn = Conexion.getConnection();
                }
            }
        }
        
        return rows;
    }
}
