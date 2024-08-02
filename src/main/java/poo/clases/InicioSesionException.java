/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

/**
 *
 * @author Marcos Barroso
 */
public class InicioSesionException extends Exception {

    public static String noRegistrado = "El correo no se ha resgistrado todavía";
    public static String claveMal = "Contraseña incorrecta";

    public InicioSesionException(String txt) {
        super(txt);
    }
}
