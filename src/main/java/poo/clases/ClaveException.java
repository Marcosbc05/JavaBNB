/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

/**
 *
 * @author Marcos Barroso
 */
public class ClaveException extends Exception{
    
    public ClaveException() {
        super("Las contraseñas introducidas no coinciden");
    }

    public ClaveException(String txt) {
        super(txt);
    }
}
