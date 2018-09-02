/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author drohne
 */
public class Persona {
    private int id ;
    private String nombre;
    private String apellido;
    
     public Persona() {
         this.id  = 0 ;
         this.nombre= "";
         this.apellido = "";    
    }

    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId()  {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    

    public void setId(int id) {
        this.id = id ;
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "id="+ id +"nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
    
}
