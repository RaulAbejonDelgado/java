/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejopersonas;

import datos.PersonasJDBC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import pojo.Persona;
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
    
    public static void menu() {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        int opcion ;
        try {
            System.out.println("Menu de gestion de alumnos");
            System.out.println("**Selecione una opcion**");
            System.out.println("1- Listar todos los alumnos");
            System.out.println("2- Añadir alumno");
            System.out.println("3- Borrar alumno");
            System.out.println("4- Modificar alumno");
        opcion = Integer.parseInt(bufer.readLine()) ;
        new ManejoPersonas().opcionSelecionada(opcion);
        } catch (Exception e) {
            System.out.println("Error");
            menu();
        }
        
    }
    
    public void opcionSelecionada(int opcion){
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
    
    
}
