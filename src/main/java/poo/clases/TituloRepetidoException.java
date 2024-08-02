/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

/**
 *
 * @author Marcos Barroso
 */
public class TituloRepetidoException extends Exception{
    
    public TituloRepetidoException(){
        super("Ese titulo ya ha sido seleccionado. Pruebe con otro título distinto");
    }
}
