/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

/**
 *
 * @author marco
 */
public class FechaException extends Exception {

    public FechaException() {
        super("Fecha no válida");
    }

    public FechaException(String txt) {
        super(txt);
    }
}
