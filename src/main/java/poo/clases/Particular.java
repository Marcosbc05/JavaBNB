/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author Marcos Barroso
 */
public class Particular extends Cliente {

    private TarjetaCredito tarjeta;
    private boolean vip;
    /**
     * constructor
     * @param tarjeta
     * @param vip
     * @param dni
     * @param nombre
     * @param telefono
     * @param correo
     * @param clave 
     */
    public Particular(TarjetaCredito tarjeta, boolean vip, String dni, String nombre, String telefono, String correo, String clave) {
        super(dni, nombre, telefono, correo, clave);
        this.tarjeta = tarjeta;
        this.vip = vip;
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
     * Busca inmuebles de una ciudad y los ordena de menor a mayor precio
     * @param ciudad ciudad en la que se quiera buscar inmuebles
     * @return lista con los inmuebles de la ciudad ordenados de menor a mayor precio
     */
    public ArrayList<Inmueble> buscarInmuebleOrdenPrecio(String ciudad) {
        ArrayList<Inmueble> listaInm = new ArrayList<>(JavaBNB.getInmuebles());
        ArrayList<Inmueble> inmueblesCiudad = (ArrayList<Inmueble>) listaInm.stream()
                .filter(i -> i.getDireccion().getLocalidad().contains(ciudad))
                .collect(Collectors.toList());
        Comparator PrecioPerComp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Inmueble inm1 = (Inmueble) o1;
                Inmueble inm2 = (Inmueble) o2;
                Integer e1 = inm1.getPrecioNoche();
                Integer e2 = inm2.getPrecioNoche();
                return e1.compareTo(e2);
            }
        };
        Collections.sort(inmueblesCiudad, PrecioPerComp);
        return inmueblesCiudad;
    }
    
    /**
     * Busca inmuebles de una ciudad y los ordena de mayor a menor relevancia
     * @param ciudad ciudad en la que se quiera buscar inmuebles
     * @return lista con los inmuebles de la ciudad ordenados de mayor a menor relevancia
     */
    public ArrayList<Inmueble> buscarInmuebleOrdenRelevancia(String ciudad) {
        ArrayList<Inmueble> inmueblesCiudad = (ArrayList<Inmueble>) JavaBNB.getInmuebles().stream()
                .filter(i -> i.getDireccion().getLocalidad().contains(ciudad))
                .collect(Collectors.toList());
        Comparator CalificacionPerComp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Inmueble inm1 = (Inmueble) o1;
                Inmueble inm2 = (Inmueble) o2;
                Double e1 = inm1.getCalificacion();
                Double e2 = inm2.getCalificacion();
                return e2.compareTo(e1);
            }
        };
        Collections.sort(inmueblesCiudad, CalificacionPerComp);
        return inmueblesCiudad;
    }

    /**
     * Busca inmuebles de una ciudad que sean del tipo especificado
     * @param ciudad ciudad en la que se quiera buscar inmuebles
     * @param tipo tipo de inmueble
     * @return lista con los inmuebles de la ciudad que sean del tipo especificado
     */
    public ArrayList<Inmueble> buscarInmuebleOrdenTipo(String ciudad,String tipo) {
        ArrayList<Inmueble> inmueblesCiudad = (ArrayList<Inmueble>) JavaBNB.getInmuebles().stream()
                .filter(i -> i.getDireccion().getLocalidad().contains(ciudad)&&i.getTipo().equals(tipo))
                .collect(Collectors.toList());
        return inmueblesCiudad;
    }

    /**
     * @return Lista con las reservas realizadas por el cliente que llama la función
     */
    public ArrayList<Reserva> getReservasCliente() {
        ArrayList<Reserva> reservasCliente = (ArrayList) JavaBNB.getReservas().stream()
                .filter(r->r.getCliente().getCorreo().equals(getCorreo())).collect(Collectors.toList());
        return reservasCliente;
    }

    /**
     * @param inm Inmueble
     * @return true si el inmueble ha sido reservado por el cliente previamente
     */
    public boolean isReservado(Inmueble inm) {
        for (Reserva r : getReservasCliente()) {
            if (r.getInmueble().getTitulo().equals(inm.getTitulo())) {
                return true;
            }
        }
        return false;
    }
    

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    /**
     * Elimina cuenta
     * @return Mensaje de confirmación de éxito o no de la operacion realizada
     */
    @Override
    public String eliminarCuenta(){
        try{
        JavaBNB.getClientes().remove(this);
        return "Cuenta eliminada correctamente"; 
        }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
            return "No se puedo eliminar correctamente: "+e.getMessage();
        }catch (Exception e){
            return e.getMessage();
        }
    }

}



