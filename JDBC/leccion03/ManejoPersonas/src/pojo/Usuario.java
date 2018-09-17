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
public class Usuario {
    private long id;
    private String nombre;
    private String email;
    private String pass;
   
    
    public Usuario() {
        super();
        this.id  = 0 ;
        this.nombre= "";
        this.email = "";    
        this.pass="";
    }

    public Usuario(int id, String nombre, String email, String pass) {
        this.id  = id ;
        this.nombre= nombre;
        this.email = email;    
        this.pass= pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", pass=" + pass + '}';
    }
    
}
