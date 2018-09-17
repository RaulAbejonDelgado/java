/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejopersonas;

import datos.PersonasJDBC;
import datos.UsuariosJDBC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    
    final int OPCION_LISTAR = 1;
    final int OPCION_ANADIR = 2;
    final int OPCION_BORRAR = 3;
    final int OPCION_MODIFICAR = 4;
    ArrayList<Persona> personasArray = new ArrayList();
    PersonasJDBC personasJDBC = new PersonasJDBC();
    ArrayList<Usuario> usuariosArray = new ArrayList<Usuario>();
    UsuariosJDBC usuariosJDBC = new UsuariosJDBC();
    boolean flag = false;

    
    public static void main(String[] args) {
       
       
        
        
        try { 
            //personasJDBC.insertar("Nombre", "Apellido");
            menu();
            
            
           
            //opcionSelecionada(opcion);
            
        } catch (Exception ex) {
            Logger.getLogger(ManejoPersonas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
            
        }
    }
    
    public static void menu(){
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        try {
            System.out.println("Menu de gestion");
            System.out.println("Quiere operar con usuarios o alumnos");
            System.out.println("1- Operar con alumnos");
            System.out.println("2- Operar con usuarios");
            opcion = Integer.parseInt(bufer.readLine()) ;
            new ManejoPersonas().opcionSelecionadaGeneral(opcion);
        } catch (Exception e) {
        }
    }
    public void opcionSelecionadaGeneral(int opcion) {
       switch(opcion){
            case 1:
               menuAlumno();
            case 2:
               menuUsuario();       
        }
    }
    
    public static void menuAlumno() {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        int opcion ;
        try {
            System.out.println("Menu de gestion de alumnos");
            System.out.println("**Selecione una opcion**");
            System.out.println("1- Listar todos los alumnos");
            System.out.println("2- Añadir alumno");
            System.out.println("3- Borrar alumno");
            System.out.println("4- Modificar alumno");
            System.out.println("5- Volver");
        opcion = Integer.parseInt(bufer.readLine()) ;
        new ManejoPersonas().opcionSelecionadaAlumno(opcion);
        } catch (Exception e) {
            System.out.println("Error");
            menuAlumno();
        }
        
    }
   
        public static void menuUsuario() {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        int opcion ;
        try {
            System.out.println("Menu de gestion de alumnos");
            System.out.println("**Selecione una opcion**");
            System.out.println("1- Listar todos los Usuarios");
            System.out.println("2- Añadir usuario");
            System.out.println("3- Borrar usuario");
            System.out.println("4- Modificar usuario");
            System.out.println("5- Volver");
        opcion = Integer.parseInt(bufer.readLine()) ;
        new ManejoPersonas().opcionSelecionadaUsuario(opcion);
        } catch (Exception e) {
            System.out.println("Error");
            menuUsuario();
        }
        
    }
    
    
    private void opcionSelecionadaUsuario(int opcion) {
        switch(opcion){
            case 1:
                listarUsuarios();
            case 2:
                agragarUsuarios();
            case 3:
                borrarUsuarios();
            case 4:
               modificarUsuarios();
        }
    }
    
    public void agragarUsuarios() {
        System.out.println("agregarUsaurios");
        String nombre;
        String email;
        String pass;
        String retryPass;
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        int rows;
        try {
            System.out.println("Introduce el nombre del usuario");
            nombre = bufer.readLine();
            System.out.println("Introduce una direccion de correo");
            email = bufer.readLine();
            System.out.println("Introduce una contraseña");
            pass = bufer.readLine();
            System.out.println("Repita la contraseña");
            retryPass = bufer.readLine();
            comprobarContraseña(pass,retryPass);
            if (flag){
                usuariosJDBC.insertar(nombre, email,pass);
            }
        } catch (Exception e) {
        }
    }

    public void borrarUsuarios() {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        int idBorrar;
        
        try {
            System.out.println("BorrarUsuarios");
            System.out.println("Introduza el id del registro que desea borrar");
            idBorrar = Integer.parseInt(bufer.readLine()) ;
            usuariosJDBC.borrar(idBorrar);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Borrar Usuarios");
            borrarUsuarios();
        }
        
         
    }
    
    public void listarUsuarios() {
        usuariosArray = usuariosJDBC.seleccionar();
        for (Usuario iteraUsuarios : usuariosArray){
            System.out.println(iteraUsuarios.toString());
        }
        menu();
    }
    
     private void modificarUsuarios() {
         System.out.println("modificarUSuarios");
    }
    
    public void opcionSelecionadaAlumno(int opcion){
        switch(opcion){
            case 1:
                listarAlumnos();
            case 2:
                agragarAlumnos();
            case 3:
                BorrarAlumnos();
                
        }
    }

    public void listarAlumnos() {
        personasArray = personasJDBC.seleccionar();
        for (Persona iteraPersonas : personasArray){
            System.out.println(iteraPersonas.toString());
        }
        menu();
    }
 

    private void agragarAlumnos() {
       String nombre;
       String apellido;
       int rows;
       BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            System.out.println("Introduce el nombre del alumno");
            nombre = bufer.readLine();
            System.out.println("Introduce el apellido del alumno");
            apellido = bufer.readLine();
            rows = personasJDBC.insertar(nombre, apellido);
            System.out.println("Alumno agregado correctamente");
        } catch (Exception e) {
            
        }finally{
            menu();
        }
       
       
    }

    private void BorrarAlumnos() {
       
       int id;
       BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            System.out.println("Introduce el id del registro que quieres eliminar");
            id = Integer.parseInt(bufer.readLine());
            
            personasJDBC.borrar(id);
            System.out.println("Alumno borrado correctamente");
        } catch (Exception e) {
            
        }finally{
            menu();
        }
    }

    private void comprobarContraseña(String pass, String retryPass) {
        if(pass.contentEquals(retryPass)){
            flag= true;
        }
        
    }

   

 

   

    

    
    
    
}
