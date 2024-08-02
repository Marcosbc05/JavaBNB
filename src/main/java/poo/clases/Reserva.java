/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Marcos Barroso
 */
public class Reserva implements Serializable {

    private final Inmueble inmueble;
    private final Particular particular;
    private final LocalDate fechaEntrada;
    private final LocalDate fechaSalida;
    /**fecha en la que se realiza la reserva*/
    private final LocalDate fechaReserva;
    /**Precio total de la reserva: precio/noche del inmueble por el numero de dias*/
    private final double precio;
    /**numero de dias que dura la reserva*/
    private final long dias;
    /**Calificacion que da el particular al inmueble por la estancia por esta reserva*/
    private int calificacion;

    /**
     * constructor
     * @param inmueble
     * @param particular
     * @param fechaEntrada
     * @param fechaSalida
     * @throws poo.clases.ReservarException si el inmueble no está libre
     */
    public Reserva(Inmueble inmueble, Particular particular, LocalDate fechaEntrada, LocalDate fechaSalida) throws ReservarException {
        if (inmueble.isLibre(fechaSalida, fechaSalida)) {
            this.inmueble = inmueble;
            this.particular = particular;
            this.fechaEntrada = fechaEntrada;
            this.fechaSalida = fechaSalida;
            this.fechaReserva = LocalDate.now();
            this.calificacion=0;
            this.dias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
            if (particular.isVip()) {
                //si el cliente el vip tiene 10% de descuento
                this.precio = (this.dias * inmueble.getPrecioNoche()) * 0.9;
            } else {
                this.precio = this.dias * inmueble.getPrecioNoche();
            }
            JavaBNB.addReserva(this);
            //añadir pago a la tarjeta del particular
            if(particular.getTarjeta().getFechaCaducidad().isBefore(LocalDate.now())){
                throw new ReservarException("No se pudo realizar el pago.\nLa tarjeta está caducada.");
            }
            particular.getTarjeta().addPago(precio);
            generarFactura();
        } else {
            throw new ReservarException();
        }
    }

    /**
     * Genera factura con la información principal de la reserva.
     * Se guardan en la carpeta "facturasGeneradas".
     */
    public final void generarFactura() {
        try {
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("facturasGeneradas/" + this.fechaEntrada + "-" + this.inmueble.getTitulo() + "-" + this.particular.getDni() + "-" + ".txt")));

            salida.println("-------------------------------- Factura Reserva --------------------------------");
            salida.println("\n");
            DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
            salida.println("Fecha de reserva: " + LocalDateTime.now().format(formatoLargo));
            salida.println("\n");
            salida.println("Importe: " + getPrecio());
            salida.println("(Precio por noche x dias = " + this.inmueble.getPrecioNoche() + " x " + getDias() + ")");
            if (particular.isVip()) {
                salida.println("\tDescuento VIP aplicado (-10%): -" + (inmueble.getPrecioNoche() * dias) * 0.1);
            }
            salida.println("\n");
            salida.println("Inmueble: " + this.inmueble.getTitulo() + "(" + this.inmueble.getDireccion().getLocalidad() + ", " + this.inmueble.getDireccion().getCalle() + ", n. " + this.inmueble.getDireccion().getNumero() + " - " + this.inmueble.getDireccion().getCodigoPostal() + ")");
            salida.println("\tNº habitaciones: " + this.inmueble.getHabitaciones() + "\tNº camas: " + this.inmueble.getCamas() + "\tNº huéspedes: " + this.inmueble.getHuespedes());
            salida.println("\n");
            DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            salida.println("Fecha entrada: " + getFechaEntrada().format(formatoCorto));
            salida.println("Fecha salida: " + getFechaSalida().format(formatoCorto));
            salida.println("\n");
            salida.println("Nombre del cliente: " + this.particular.getNombre() + "\tTeléfono: " + this.particular.getTelefono() + "\tDNI: " + this.particular.getDni());
            salida.println("\n");
            salida.println("Para más informacion llame al " + this.inmueble.getAnfitrion().getTelefono());
            salida.println("\n");
            salida.println("------------------------------GRACIAS POR SU RESERVA-----------------------------");
            salida.println("------------------------------Disfrute de la estancia----------------------------");
            salida.println("---------------------------------------------------------------------------------");
            salida.close();

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public long getDias() {
        return dias;
    }

    public double getPrecio() {
        return precio;
    }
    

    public int getCalificacionReserva() {
        return calificacion;
    }
    
    /**
     * Cambia la calificacion y llama al método que calcula la media de la nota del inmueble
     * @param calificacion
     * @return Mensaje de éxtio o no de la operación
     */
    public String setCalificacion(int calificacion) {
        try{
           if (calificacion >= 1 && calificacion <= 5) {
                this.calificacion = calificacion;
                //actualizar calificacion inmueble:
                for (Inmueble i:JavaBNB.getInmuebles()){
                    if(i.getTitulo().equals(inmueble.getTitulo())){
                        i.calcCalificacion();
                        return "Calificacion añadida";
                    }
                }
            } else if (calificacion < 1 || calificacion > 5) {
                throw new CalificacionException();
            }return "El inmueble ya no existe";
        }catch(CalificacionException ce){
            return ce.getMessage();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public Particular getCliente() {
        return particular;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

}

class CalificacionException extends Exception {

    public CalificacionException() {
        super("La nota no está entre 1 y 5");
    }

    public CalificacionException(String txt) {
        super(txt);
    }
}