/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Marcos Barroso
 */
public class TarjetaCredito implements Serializable {

    private final String nombreTitular;
    private String numero;
    private LocalDate fechaCaducidad;
    /**
     * Lista con los distintos pagos que se han realizado con esta tarjeta
     */
    private final ArrayList<Double> pagos;

    /**
     * constructor
     *
     * @param nombreTitular
     * @param numero debe de ser de 16 dígitos
     * @param fechaCaducidad
     */
    public TarjetaCredito(String nombreTitular, String numero, LocalDate fechaCaducidad) {
        this.nombreTitular = nombreTitular;
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
        this.pagos = new ArrayList<>();
    }

    /**
     * Añade pago a la lista de pagos que se han realizado con esta tarjeta
     *
     * @param cantidad
     */
    public void addPago(Double cantidad) {
        this.pagos.add(cantidad);
    }

    /**
     * @return Lista con los pagos que ha realizado esta tarjeta
     */
    public ArrayList<Double> getPagos() {
        return pagos;
    }

    /**
     *
     * @return fecha de caducidad de la tarjeta
     */
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * @return numero de la tarjeta
     */
    public String getNumero() {
        return numero;
    }

    /**
     * 
     * @return nombre del titular de la tarjeta
     */
    public String getNombreTitular() {
        return nombreTitular;
    }
    
    /**
     * Cambia el numero de la tarjeta
     * @param numero 
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Cambia la fecha de caducidad de la tarjeta
     * @param fecha 
     */
    public void setFechaCaducidad(LocalDate fecha) {
        this.fechaCaducidad = fecha;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" + "nombreTitular=" + nombreTitular + ", numero=" + numero + ", fechaCaducidad=" + fechaCaducidad + '}';
    }

}
