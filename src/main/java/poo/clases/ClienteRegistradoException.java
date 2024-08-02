/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

/**
 *
 * @author Marcos Barroso
 */
public class ClienteRegistradoException extends Exception{
    
    public ClienteRegistradoException() {
        super("El correo ya se ha registrado");
    }

}