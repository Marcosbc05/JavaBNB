/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

/**
 *
 * @author Marcos Barroso
 */
public class ReservarException extends Exception {
    public ReservarException() {
        super("El inmueble ya está reservado para esas fechas");
    }
    public ReservarException(String txt) {
        super(txt);
    }
}
