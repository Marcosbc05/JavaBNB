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
public class Direccion implements Serializable {
    
    private String calle;
    private int numero;
    private int codigoPostal;
    private String localidad;

    /**
     * Constructor
     * @param calle
     * @param numero
     * @param codigoPostal
     * @param localidad 
     */
    public Direccion(String calle, int numero, int codigoPostal, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
    }
    

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return localidad+", C/ " + calle + ", nº " + numero  +" (" + codigoPostal+')';
    }

}
