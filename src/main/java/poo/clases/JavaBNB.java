/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author Marcos Barroso
 */
public class JavaBNB implements Serializable {

    /**
     * ArrayList que almacena todos los clientes registrados
     */
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    /**
     * ArrayList que almacena todas las reservas hechas
     */
    private static ArrayList<Reserva> reservas = new ArrayList<>();
    /**
     * ArrayList que almacena todos los inmuebles creados
     */
    private static ArrayList<Inmueble> inmuebles = new ArrayList<>();

    /**
     * Serializar objetos.
     */
    public static void guardarDatos() {
        try {
            if (!clientes.isEmpty()) {
                FileOutputStream ostreamCli = new FileOutputStream("./copiaSeguridad/copiaClientes.dat");
                ObjectOutputStream oosCli = new ObjectOutputStream(ostreamCli);
                oosCli.writeObject(clientes);
                ostreamCli.close();
            } else {
                System.out.println("Error: No hay datos de clientes");
            }
            if (!reservas.isEmpty()) {
                FileOutputStream ostreamRes = new FileOutputStream("./copiaSeguridad/copiaReservas.dat");
                ObjectOutputStream oosRes = new ObjectOutputStream(ostreamRes);
                oosRes.writeObject(reservas);
                ostreamRes.close();
            } else {
                System.out.println("Error: No hay datos de reservas");
            }
            if (!inmuebles.isEmpty()) {
                FileOutputStream ostreamInm = new FileOutputStream("./copiaSeguridad/copiaInmuebles.dat");
                ObjectOutputStream oosInm = new ObjectOutputStream(ostreamInm);
                oosInm.writeObject(inmuebles);
                ostreamInm.close();
            } else {
                System.out.println("Error: No hay datos de inmuebles");
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Recuperar objetos guardados.
     */
    public static void cargarDatos() {
        try {
            //Lectura de los objetos cliente
            FileInputStream istreamCli = new FileInputStream("./copiaSeguridad/copiaClientes.dat");
            ObjectInputStream oisCli = new ObjectInputStream(istreamCli);
            clientes = (ArrayList) oisCli.readObject();
            istreamCli.close();
            //Lectura de los objetos inmueble
            FileInputStream istreamInm = new FileInputStream("./copiaSeguridad/copiaInmuebles.dat");
            ObjectInputStream oisInm = new ObjectInputStream(istreamInm);
            inmuebles = (ArrayList) oisInm.readObject();
            istreamInm.close();
            //Lectura de los objetos reserva
            FileInputStream istreamRes = new FileInputStream("./copiaSeguridad/copiaReservas.dat");
            ObjectInputStream oisRes = new ObjectInputStream(istreamRes);
            reservas = (ArrayList) oisRes.readObject();
            istreamRes.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void addInmueble(Inmueble inm) {
        if (!inmuebles.contains(inm)) {
            inmuebles.add(inm);
        }
    }

 
    public static void borrarInmueble(Inmueble inm) {
        if (inmuebles.contains(inm)) {
            inmuebles.remove(inm);
        }
    }


    public static void addReserva(Reserva res) {
        if (!reservas.contains(res)) {
            reservas.add(res);
        }
    }


    public static void addCliente(Cliente cli) {
        if (!clientes.contains(cli)) {
            clientes.add(cli);
        }
    }

    /**
     * Compruebe si el titulo del un inmueble ya ha sido usado
     *
     * @param titulo
     * @return true si el titulo ya ha sido usado
     */
    public static boolean tituloRepetido(String titulo) {
        ArrayList<String> titulos = (ArrayList) getInmuebles().stream().map(Inmueble::getTitulo).collect(Collectors.toList());
        return titulos.contains(titulo);
    }


    public static ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }

    /**
     * Filtra los inmuebles según la ciudad en la que se encuentres
     *
     * @param ciudad
     * @return ArrayList de inmuebles de la ciudad dada.
     */
    public static ArrayList<Inmueble> getInmueblesCiudad(String ciudad) {
        ArrayList<Inmueble> inmueblesCiudad = (ArrayList) inmuebles.stream()
                .filter(i -> i.getDireccion().getLocalidad().equals(ciudad))
                .collect(Collectors.toList());
        return inmueblesCiudad;
    }

    /**
     * ordena la lista reservas por fecha de reserva de la más a la menos
     * reciente
     *
     * @return lista de reservas ordenada
     */
    public static ArrayList<Reserva> getReservas() {
        Comparator FechaReservaComp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Reserva r1 = (Reserva) o1;
                Reserva r2 = (Reserva) o2;
                return r2.getFechaReserva().compareTo(r1.getFechaReserva());
            }
        };
        Collections.sort(reservas, FechaReservaComp);
        return reservas;
    }

    /**
     * Ordena las reservas de la más a la menos reciente a partir de la fecha
     * dada
     *
     * @param fecha
     * @return lista de reservas a partir de fecha ordenadas
     */
    public static ArrayList<Reserva> getReservasAfterFecha(LocalDate fecha) {
        ArrayList<Reserva> reservasAfter = new ArrayList<>();
        for (Reserva res : reservas) {
            if (res.getFechaReserva().isAfter(fecha) || res.getFechaReserva().equals(fecha)) {
                reservasAfter.add(res);
            }
        }
        Comparator FechaReservaComp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Reserva r1 = (Reserva) o1;
                Reserva r2 = (Reserva) o2;
                return r2.getFechaReserva().compareTo(r1.getFechaReserva());
            }
        };
        Collections.sort(reservasAfter, FechaReservaComp);
        return reservasAfter;
    }

    /**
     * Busca cliente según su correo
     *
     * @param correo
     * @return cliente cuyo correo es el dado
     */
    public static Cliente buscarClientePorCorreo(String correo) {
        for (Cliente c : clientes) {
            if (c.getCorreo().equals(correo)) {
                return c;
            }
        }
        return null;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     *
     * @return lista de los correos de los clientes
     */
    public static ArrayList<String> getCorreos() {
        ArrayList correos = (ArrayList) clientes.stream()
                .map(Cliente::getCorreo).collect(Collectors.toList());
        return correos;
    }

    /**
     * comprueba si el correo está registrado
     *
     * @param correo
     * @return true si el correo está registrado
     */
    public static boolean correoRegistrado(String correo) {
        try {
            return getCorreos().contains(correo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Comprueba que la fecha es válida.
     *
     * @param d dia
     * @param m mes
     * @param a año
     * @return true si la fecha es válida
     */
    public static boolean buenaFecha(int d, int m, int a) {
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (esBisiesto(a)) {
            diasMes[1] = 29;
        }
        return (a > 0 && m >= 1 && m <= 12 && d >= 1 && d <= diasMes[m - 1]);
    }

    /**
     * Comprueba si el año es bisiesto.
     *
     * @param a año
     * @return true si el año es bisiesto
     */
    public static boolean esBisiesto(int a) {
        return (a % 4 == 0) && ((a % 100 != 0) || (a % 400 == 0));
    }

    /**
     * Da valor a un dato de tipo LocalDate a partir de un string del tipo
     * dd/mm/aaaa
     *
     * @param fecha
     * @return LocalDate fecha
     * @throws FechaException si la fecha no es válida.
     */
    public static LocalDate setFecha(String fecha) throws FechaException {
        String[] fechaDividir = fecha.split("/");
        if (!buenaFecha(Integer.parseInt(fechaDividir[0]), Integer.parseInt(fechaDividir[1]), Integer.parseInt(fechaDividir[2]))) {
            throw new FechaException();
        } else {
            return LocalDate.of(Integer.parseInt(fechaDividir[2]), Integer.parseInt(fechaDividir[1]), Integer.parseInt(fechaDividir[0]));
        }
    }

    /**
     * Da valor a un dato de tipo LocalDate a partir de un string del tipo
     * dd/mm/aaaa
     *
     * @param fecha
     * @return LocalDate fecha
     * @throws FechaException si la fecha no es válida o es futura
     */
    public static LocalDate setFechaPasada(String fecha) throws FechaException {
        LocalDate fechaDef = setFecha(fecha);
        if (fechaDef.isAfter(LocalDate.now())) {
            throw new FechaException("La fecha no puede ser futura.");
        } else {
            return fechaDef;
        }
    }

    /**
     * Da valor a un dato de tipo LocalDate a partir de un string del tipo
     * dd/mm/aaaa
     *
     * @param fecha
     * @return LocalDate fecha
     * @throws FechaException si la fecha no es válida o es pasada
     */
    public static LocalDate setFechaFutura(String fecha) throws FechaException {
        LocalDate fechaDef = setFecha(fecha);
        if (fechaDef.isBefore(LocalDate.now())) {
            throw new FechaException("La fecha no puede ser pasada.");
        } else {
            return fechaDef;
        }
    }

    /**
     * Determina de qué tipo es el cliente de ese correo
     *
     * @param correo
     * @return tipo de cliente
     */
    public static String tipoCliente(String correo) {
        return buscarClientePorCorreo(correo).getClass().getSimpleName();
    }

    /**
     * Inicia sesión en JavaBNB
     *
     * @param correo
     * @param clave
     * @return true si el inicio de sesión es válido.
     * @throws poo.clases.InicioSesionException si hay un error al inciar sesion
     */
    public static boolean iniciarSesion(String correo, String clave) throws InicioSesionException {
        if (correo.equals(Administrador.getCorreoAdm())) {
            if (clave.equals(Administrador.getClaveAdm())) {
                return true;
            } else {
                throw new InicioSesionException(InicioSesionException.claveMal);
            }
        } else {
            if (correoRegistrado(correo)) {
                if (buscarClientePorCorreo(correo).getClave().equals(clave)) {
                    return true;
                } else {
                    throw new InicioSesionException(InicioSesionException.claveMal);
                }
            } else if (!correoRegistrado(correo)) {
                throw new InicioSesionException(InicioSesionException.noRegistrado);
            }
        }
        return false;
    }

    /**
     * Registra un usuario de tipo anfitrión
     *
     * @param tipo
     * @param nombre
     * @param dni
     * @param telf
     * @param correo
     * @param clave1
     * @param clave2
     * @throws ClaveException si las clave y la clave de confirmacion son
     * distintas, si los campos están vacíos o si la clave es de menos de 6
     * caracteres
     * @throws ClienteRegistradoException si el correo ya está registrado
     */
    public static void registrarse(String tipo, String nombre, String dni, String telf, String correo, String clave1, String clave2) throws ClaveException, ClienteRegistradoException {
        if (clave1.equals("") || correo.equals("") || dni.equals("") || nombre.equals("")) {
            throw new ClaveException("Rellene campos vacíos");
        }
        if (JavaBNB.correoRegistrado(correo) || correo.equals(Administrador.getCorreoAdm())) {
            throw new ClienteRegistradoException();
        }
        if (clave1.length() < 6) {
            throw new ClaveException("La contraseña debe ser de al menos 6 caracteres");
        }
        if (!clave1.equals(clave2)) {
            throw new ClaveException();
        }
        //crea objeto cliente anfitrión
        Cliente anf1 = new Anfitrion(dni, nombre, telf, correo, clave1);
    }

    /**
     * Registra un usuario de tipo anfitrión
     *
     * @param tipo
     * @param nombre
     * @param dni
     * @param telf
     * @param correo
     * @param clave1
     * @param clave2
     * @param vipSelection
     * @param fechaCaducidad
     * @param numTarjeta
     * @throws ClaveException si las clave y la clave de confirmacion son
     * distintas, si los campos están vacíos o si la clave es de menos de 6
     * caracteres
     * @throws ClienteRegistradoException si el correo ya está registrado
     * @throws FechaException si la fehca no es válida o es pasada
     */
    public static void registrarse(String tipo, String nombre, String dni, String telf, String correo, String clave1, String clave2, String vipSelection, String fechaCaducidad, String numTarjeta) throws ClaveException, ClienteRegistradoException, FechaException {
        if (clave1.equals("") || correo.equals("") || dni.equals("") || nombre.equals("") || fechaCaducidad.equals("") || numTarjeta.equals("")) {
            throw new ClaveException("Rellene campos vacíos");
        }
        if (JavaBNB.correoRegistrado(correo) || correo.equals(Administrador.getCorreoAdm())) {
            throw new ClienteRegistradoException();
        }
        if (clave1.length() < 6) {
            throw new ClaveException("La contraseña debe ser de al menos 6 caracteres");
        }
        if (!clave1.equals(clave2)) {
            throw new ClaveException();
        }
        boolean vip;
        switch (vipSelection) {
            case "Sí" ->
                vip = true;
            case "No" ->
                vip = false;
            default ->
                throw new ClaveException("Seleccione Sí o No");
        }//convierte String a LocalDate
        LocalDate fechaCaducidadDef = JavaBNB.setFechaFutura(fechaCaducidad);
        //crea objeto tarjeta
        TarjetaCredito tc1 = new TarjetaCredito(nombre, numTarjeta, fechaCaducidadDef);
        //crea objeto cliente particular
        Cliente par1 = new Particular(tc1, vip, dni, nombre, telf, correo, clave1);
    }

    /**
     * Modifica los datos de usuario particular.
     *
     * @param particular
     * @param claveActual
     * @param telefono
     * @param numTarjeta
     * @param fechaCad
     * @param vipSelection
     * @param nuevaClave1
     * @param nuevaClave2
     * @throws ClaveException si la contraseña es de menos de 6 caracteres, si
     * no son iguales o si la actual es incorrecta
     * @throws FechaException si la fecha de caducidad es pasada.
     */
    public static void modificarDatos(Particular particular, String claveActual, String telefono, String numTarjeta, String fechaCad, String vipSelection, String nuevaClave1, String nuevaClave2) throws ClaveException, FechaException {
        if (claveActual.equals(particular.getClave())) {
            particular.setTelefono(telefono);
            particular.getTarjeta().setNumero(numTarjeta);
            LocalDate fechaCaducidadDef = JavaBNB.setFechaFutura(fechaCad);
            particular.getTarjeta().setFechaCaducidad(fechaCaducidadDef);
            boolean vip;
            switch (vipSelection) {
                case "Sí" ->
                    vip = true;
                case "No" ->
                    vip = false;
                default ->
                    throw new ClaveException("Seleccione Sí o No");
            }
            particular.setVip(vip);
            //cambiar clave si el usuario ha escrito algo en ese campo
            if (!nuevaClave1.equals("")) {
                if (nuevaClave1.length() < 6) {
                    throw new ClaveException("La contraseña debe ser de mínimo 6 caracteres.");
                } else {
                    if (nuevaClave1.equals(nuevaClave2)) {
                        particular.setClave(nuevaClave1);
                    } else {
                        throw new ClaveException();
                    }
                }
            }
        } else {
            throw new ClaveException("La contraseña actual es incorrecta");
        }
    }

    /**
     * Modifica los datos de usuario anfitrion.
     *
     * @param anfitrion
     * @param telefono
     * @param claveActual
     * @param nuevaClave1
     * @param nuevaClave2
     * @throws ClaveException ClaveException si la contraseña es de menos de 6
     * caracteres, si no son iguales o si la actual es incorrecta
     */
    public static void modificarDatos(Anfitrion anfitrion, String telefono, String claveActual, String nuevaClave1, String nuevaClave2) throws ClaveException {
        if (claveActual.equals(anfitrion.getClave())) {
            anfitrion.setTelefono(telefono);
            //cambiar clave si el usuario ha escrito algo en ese campo
            if ((!nuevaClave1.equals(""))) {
                if (nuevaClave1.length() < 6) {
                    throw new ClaveException("La contraseña debe ser de mínimo 6 caracteres.");
                } else {
                    if (nuevaClave1.equals(nuevaClave2)) {
                        anfitrion.setClave(nuevaClave1);
                    } else {
                        throw new ClaveException();
                    }
                }
            }
        } else {
            throw new ClaveException("La contraseña actual es incorrecta");
        }
    }
}
