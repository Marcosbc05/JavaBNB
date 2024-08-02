/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;


/**
 *
 * @author Marcos Barroso
 */
public class Administrador extends Usuario {
    
    /**clave del usuario administrador*/
    private static final String claveAdm="admin";
    /**correo del usuario administardor*/
    private static final String correoAdm="admin@javabnb.com";

    public static String getClaveAdm(){
        return claveAdm;
    }
    public static String getCorreoAdm(){
        return correoAdm;
    }
}
