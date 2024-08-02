/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

import java.io.Serializable;

/**
 *
 * @author Marcos Barroso
 */
public class Usuario implements Serializable {
    private String clave;
    private String correo;
    
    /**
     * constructor
     * @param correo
     * @param clave 
     */
    public Usuario(String correo, String clave) {
        this.clave = clave;
        this.correo = correo;
    }

    public Usuario() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getCorreo() {
        return correo;
    }

}
