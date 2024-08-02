/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Marcos Barroso
 */
public class Anfitrion extends Cliente {

    private LocalDate fechaRegistro;
    private boolean superAnfitrion;

    /**
     * constructor
     * @param dni
     * @param nombre
     * @param telefono
     * @param correo
     * @param clave
     */
    public Anfitrion(String dni, String nombre, String telefono, String correo, String clave) {
        super(dni, nombre, telefono, correo, clave);
        this.fechaRegistro = LocalDate.now();
        this.superAnfitrion = false;
        try {
            //Si el correo ya está registrado lanza una excepción
            if (JavaBNB.correoRegistrado(correo)) {
                throw new ClienteRegistradoException();
            } else {
                JavaBNB.addCliente(this);
            }
        } catch (ClienteRegistradoException cre) {
            System.out.println(cre.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Calcula la media de calificaciones de los inmuebles del anfitrion 
     * y llama al metodo que establece si es superanfitrion si la media es mayor a 4.
     * @return media de calificaciones de los inmuebles de este anfitrion
     */
    public double calcMediaCalificaciones() {
        double mediaCalif = JavaBNB.getInmuebles().stream()
                .filter(i -> i.getAnfitrion().getCorreo().equals(this.getCorreo()))
                .map(Inmueble::getCalificacion)
                .collect(Collectors.averagingDouble(Double::doubleValue));
        setSuperAnfitrion(mediaCalif);
        return mediaCalif;
    }

    public boolean isSuperAnfitrion() {
        return superAnfitrion;
    }

    /**
     * Pone el valor superAnfitrion en true si la media de reseñas es igual o
     * mayor a 4.
     * @param mediaCalif 
     */
    public void setSuperAnfitrion(double mediaCalif) {
        this.superAnfitrion = (mediaCalif >= 4);
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Filtra todas las reservas y se queda con las que el inmueble es de este
     * anfitrion
     * @return lista con las reservas que han sido realizadas en los inmuebles
     * de este anfitrion.
     */
    public ArrayList<Reserva> getReservaAnfitrion() {
        ArrayList<Reserva> listaRes = new ArrayList<>(JavaBNB.getReservas());
        ArrayList<Reserva> reservasAnfitrion = (ArrayList<Reserva>) listaRes.stream()
                .filter(r -> r.getInmueble().getAnfitrion().getCorreo().equals(this.getCorreo()))
                .collect(Collectors.toList());
        return reservasAnfitrion;
    }

    /**
     * Filtra los inmuebles registrados y crea una lista con los que pertenecen a este anfitrión.
     * @return lista de los inmuebles de este anfitrion
     */
    public ArrayList<Inmueble> getInmueblesAnfitrion() {
        List<Inmueble> inmuebles = JavaBNB.getInmuebles();
        ArrayList<Inmueble> inmueblesAnf = (ArrayList<Inmueble>) inmuebles.stream()
                .filter(i -> i.getAnfitrion().getCorreo().equals(getCorreo())).collect(Collectors.toList());
        return inmueblesAnf;
    }
    
    /**
     * Elimina cuenta y sus inmuebles asociados
     * @return Mensaje de confirmación de éxito o no de la operacion realizada
     */
    @Override
    public String eliminarCuenta(){
        //borra los inmuebles asociados a este anfitrion
        try{
            for(Inmueble i: getInmueblesAnfitrion()){
                JavaBNB.borrarInmueble(i);
        }
        JavaBNB.getClientes().remove(this);
        return "Cuenta y sus inmuebles asociados eliminados"; 
        }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
            return "No se puedo eliminar correctamente: "+e.getMessage();
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
