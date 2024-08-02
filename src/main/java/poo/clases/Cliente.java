/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;


/**
 *
 * @author Marcos Barroso
 */
public abstract class Cliente extends Usuario {
    
    private String dni;
    private String nombre;
    private String telefono;
    
    /**
     * Constructor
     * @param dni
     * @param nombre
     * @param telefono
     * @param correo
     * @param clave 
     */
    public Cliente(String dni, String nombre, String telefono, String correo, String clave) {
        super(correo, clave);
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        
    }
    
    
    public abstract String eliminarCuenta();

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    

}

