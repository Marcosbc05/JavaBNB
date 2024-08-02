/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author Marcos Barroso
 */
public class Inmueble implements Serializable {

    private String titulo;
    private Direccion direccion;
    private int huespedes;
    private int habitaciones;
    private int camas;
    private int baños;
    /**
     * atributo tipo de alojamiento: casa o apartamento
     */
    private final String tipo;
    private int precioNoche;
    private ArrayList<String> servicios = new ArrayList<>();
    private String foto;
    //** atributo calificacion sobre 5*/
    private double calificacion;
    private final Anfitrion anfitrion;

    /**
     * constructor
     *
     * @param anfitrion
     * @param titulo
     * @param direccion
     * @param huespedes
     * @param habitaciones
     * @param camas
     * @param baños
     * @param tipo
     * @param precioNoche
     * @param foto
     * @param servicios
     * @throws poo.clases.TituloRepetidoException si el titulo está ya
     * registrado.
     */
    public Inmueble(Anfitrion anfitrion, String titulo, Direccion direccion, int huespedes, int habitaciones, int camas, int baños, String tipo, int precioNoche, String foto, ArrayList<String> servicios) throws TituloRepetidoException {
        if (JavaBNB.tituloRepetido(titulo)) {
            throw new TituloRepetidoException();
        } else {
            this.titulo = titulo;
        }
        this.direccion = direccion;
        this.huespedes = huespedes;
        this.habitaciones = habitaciones;
        this.camas = camas;
        this.baños = baños;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.foto = foto;
        this.calificacion = 0;
        this.anfitrion = anfitrion;
        this.servicios = servicios;
        JavaBNB.addInmueble(this);
    }

    /**
     * Calcula la calificacion del inmueble a partir de la media de todas sus
     * reservas que le hayan calificado y llama al metodo que modifica la media del anfitrion.
     */
    public void calcCalificacion() {
        this.calificacion = getReservasInmueble().stream()
                .map(Reserva::getCalificacionReserva).filter(i -> i != 0)
                .collect(Collectors.averagingInt(Integer::intValue));
        //actualiza la media del anfitrion
        anfitrion.calcMediaCalificaciones();
    }

    public double getCalificacion() {
        return this.calificacion;
    }
    
    /**
     * Recuenta cuantas calificaciones hay registradas de este inmueble
     * @return numero de calificaciones registradas
     */
    public int getNumCalificaciones(){
        int numCalificaciones=0;
        for (Reserva r : getReservasInmueble()){
                if (r.getCalificacionReserva()>0){
                    numCalificaciones+=1;
                }
            }
        return numCalificaciones;
    }


    public void addServicio(String servicio) {
        if (!servicios.contains(servicio)) {
            servicios.add(servicio);
        }
    }

    public void setServicios(ArrayList<String> servicios) {
        this.servicios = servicios;
    }

    /**
     * Devuelve los servicios del inmueble convertidos de elemento del arrayList
     * a string separados entre comas
     *
     * @return String con los servicios del inmueble.
     */
    public String getServicios() {
        String serviciosString = "";
        for (String s : servicios) {
            serviciosString += s + ",";
        }
        return serviciosString;
    }

    public Anfitrion getAnfitrion() {
        return anfitrion;
    }

    public String getFoto() {
        return foto;
    }


    public void setFoto(String foto) {
        this.foto = foto;
    }


    public int getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(int precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getTipo() {
        return tipo;
    }

    public int getBaños() {
        return baños;
    }


    public void setBaños(int baños) {
        this.baños = baños;
    }

    public int getCamas() {
        return camas;
    }


    public void setCamas(int camas) {
        this.camas = camas;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(int huespedes) {
        this.huespedes = huespedes;
    }

    public Direccion getDireccion() {
        return direccion;
    }


    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTitulo() {
        return titulo;
    }

    /**
     * Modifica o estable titulo si no está ya usado
     * @param tituloNuevo
     * @throws TituloRepetidoException si el titulo ya está usado
     */
    public void setTitulo(String tituloNuevo) throws TituloRepetidoException {
        if (JavaBNB.tituloRepetido(tituloNuevo)&&(!tituloNuevo.equals(this.titulo))) {
            throw new TituloRepetidoException();
        } else {
            this.titulo = tituloNuevo;
        }
    }

    /**
     * Devuelve una lista con las reservas que se han realizado a este inmueble
     * @return ArrayList con las reservas del inmueble
     */
    public ArrayList<Reserva> getReservasInmueble() {
        return (ArrayList) JavaBNB.getReservas().stream()
                .filter(r -> r.getInmueble().getTitulo().equals(titulo))
                .collect(Collectors.toList());
    }

    /**
     * @param fechaIn fecha entrada de la reserva que se quiere hacer
     * @param fechaOut fecha salida de la reserva que se quiere hacer
     * @return true si entre las fechas indicadas está libre
     */
    public boolean isLibre(LocalDate fechaIn, LocalDate fechaOut) {
        ArrayList<Reserva> listaReservasInm = (ArrayList<Reserva>) JavaBNB.getReservas().stream()
                .filter(r -> r.getInmueble().getTitulo().equals(this.titulo))
                .collect(Collectors.toList());
        boolean libre = true;
        for (Reserva r : listaReservasInm) {
            if (!((fechaIn.isBefore(r.getFechaEntrada()) && fechaOut.isBefore(r.getFechaEntrada()))
                    || ((fechaOut.isAfter(r.getFechaSalida()) && fechaIn.isAfter(r.getFechaSalida()))))) {
                libre = false;
            }
        }
        return libre;
    }
}
