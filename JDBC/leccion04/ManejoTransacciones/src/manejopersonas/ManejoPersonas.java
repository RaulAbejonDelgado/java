/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejopersonas;

import datos.Conexion;
import datos.PersonasJDBC;
import datos.UsuariosJDBC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drohne
 */
public class ManejoPersonas {

    

    
    public static void main(String[] args) {
       PersonasJDBC personasJDBC = new PersonasJDBC();
       //creamos un objeto conexion que se va a compartir para ejecutar todas las querys
       Connection conn = null;
        try { 
            conn = Conexion.getConnection();
            //revisamos si la conexion esta en modo autocommit
            //por defecto esta a true
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            
            PersonasJDBC personas =  new PersonasJDBC(conn);
            personas.insertar("Juan", "Palomo");
            //provocamos el fallo superando los 45 caracteres que soporta el campo en la db
             personas.insertar("Juan", "Palomooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
             //imagenmos que no da error
             conn.commit();  
            } catch (SQLException e) {
            //hacemos rollback en caso de error
            try {
                System.out.println("Entramos al rollback");
                //mostramos el error por consola
                e.printStackTrace(System.out);
                conn.rollback();
            }   catch (SQLException e1) {
                e1.printStackTrace(System.out);
            }
            
        }
    }
    
    }
