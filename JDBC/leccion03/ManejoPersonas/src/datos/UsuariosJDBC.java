
package datos;
import pojo.*;
import java.sql.*;
import java.util.*;
/**
 *Clase encargada de hacer las operaciones de insert select update o select
 * @author drohne
 */
public class UsuariosJDBC {
    private final String SQL_INSERT = "INSERT INTO usuarios(nombre,email,password) VALUES(?,?,?)";
    private final String SQL_UPDATE ="UPDATE usuarios SET nombre=?,email=?,password=? WHERE id_usuarios=? VALUES(?,?,?,?)";
    private final String SQL_SELECT ="SELECT * FROM usuarios ORDER BY id_usuarios";
    private final String SQL_DELETE ="DELETE from usuarios WHERE id_usuarios=?";
    
    //funcion INSERT
    
    public int insertar(String nombre, String email,String pass){
        //Creamos los objetos de conexion, statement para ejecutar las querys
        //y resulset para el retorno
        Connection conexion = null;
        //PreparedStatement estamento = null;
        PreparedStatement estamento = null;  
        ResultSet resultado = null;
        //donde guardaremos el numero de registros afectados
        int rows = 0 ;
        try {
            conexion = Conexion.getConnection();
            estamento = conexion.prepareStatement(SQL_INSERT);
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            int index = 1;
            estamento.setString(index++, nombre);//parametro 1
            estamento.setString(index++, email);//parametro 2
            estamento.setString(index, pass);//parametro 3
            System.out.println("INSERTANDO ");
            //nos devuelve un entero representado el numero de registros afectados por la query
            rows = estamento.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Conexion.close(conexion);
        }
        return rows;
    }
    
    public int actualizar(int idPersona, String nombre, String email,String pass){
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
            conexion = Conexion.getConnection();
            estamento = conexion.prepareStatement(SQL_UPDATE);
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            int index = 1;
            
            
            estamento.setString(index++, nombre);//parametro 1
            estamento.setString(index++, email);//parametro 2
            estamento.setString(index++, pass);//parametro 3
            estamento.setInt(index++, idPersona);//parametro 4
            
            System.out.println("ACTUALIZANDO");
            rows = estamento.executeUpdate();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                Conexion.close(conexion);
            }
        }
        
        return rows;
    }
    
    public ArrayList<Usuario> seleccionar(){
        //Creamos los objetos de conexion, statement para ejecutar las querys
        //y resulset para el retorno
        Connection conexion = null;
        //PreparedStatement estamento = null;
        PreparedStatement estamento = null;  
        ResultSet resultado = null;
        //donde guardaremos el numero de registros afectados
        ArrayList<Usuario> usuariosArray = new ArrayList<>();
        int rows = 0;
            try {
            conexion = Conexion.getConnection();
            estamento = conexion.prepareStatement(SQL_SELECT);
            resultado = estamento.executeQuery();
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            while(resultado.next()){
                //System.out.println("Id -> "+resultado.getInt(1));
                //resultado.getString("Nombre -> "+resultado.getString(2));
                //resultado.getString("Apellido -> "+resultado.getString(3));
                usuariosArray.add(new Usuario(resultado.getInt(1),resultado.getString(2),resultado.getString(3),resultado.getString(4)));
            }
            
                
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                Conexion.close(resultado);
                Conexion.close(conexion);
            }
        return usuariosArray;
    
    }
    
    public int borrar(int idPersona){
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
            conexion = Conexion.getConnection();
            estamento = conexion.prepareStatement(SQL_DELETE);
            //resultado = estamento.executeQuery(estamento);
            //Con esto nos apoyaremos para sustituir los ? de la query por los parametros en ejecucion
            int index = 1;      
            estamento.setInt(index++, idPersona);//parametro 1
            System.out.println("Eliminando");
            rows = estamento.executeUpdate();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                Conexion.close(conexion);
            }
        }
        
        return rows;
    }
}
