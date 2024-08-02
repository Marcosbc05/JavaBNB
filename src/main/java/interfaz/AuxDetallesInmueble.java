/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaz;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import poo.clases.Inmueble;
import poo.clases.JavaBNB;
import poo.clases.Particular;
import poo.clases.Reserva;
import poo.clases.ReservarException;

/**
 *
 * @author Marcos Barroso
 */
public class AuxDetallesInmueble extends javax.swing.JDialog {

    private final Particular particular;
    private final Inmueble inmueble;
    private LocalDate fechaSalida, fechaEntrada;
    private final boolean reservar;

    /**
     * Creates new form AuxDetallesInmueble desde ventana particular
     * @param parent
     * @param modal
     * @param i
     * @param p
     * @param fechaIn
     * @param fechaOut
     * @param reservar 
     */
    public AuxDetallesInmueble(java.awt.Frame parent, boolean modal, Inmueble i, Particular p, LocalDate fechaIn, LocalDate fechaOut,boolean reservar) {
        super(parent, modal);
        initComponents();
        this.particular = p;
        this.inmueble = i;
        this.fechaEntrada = fechaIn;
        this.fechaSalida = fechaOut;
        this.reservar=reservar;
        jPanelReservar.setVisible(reservar);
        cargarDatos();
    }
    
    /**
     * Creates new form AuxDetallesInmueble desde ventana administrador
     * @param parent
     * @param modal
     * @param i
     * @param p
     * @param reservar 
     */
    public AuxDetallesInmueble(java.awt.Frame parent, boolean modal, Inmueble i, Particular p,boolean reservar) {
        super(parent, modal);
        initComponents();
        this.particular = p;
        this.inmueble = i;
        this.reservar=reservar;
        jPanelReservar.setVisible(reservar);
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelFoto = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTipo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jTextFieldCalificacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldHuespedes = new javax.swing.JTextField();
        jTextFieldBaños = new javax.swing.JTextField();
        jTextFieldHabitaciones = new javax.swing.JTextField();
        jTextFieldCamas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanelReservar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonReservar = new javax.swing.JButton();
        jFormattedTextFechaIn = new javax.swing.JFormattedTextField();
        jFormattedTextFechaOut = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabelAnfitrion = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(450, 160));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelTitulo.setText("Titulo");

        jLabelDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDireccion.setText("Direccion");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tipo:");

        jTextFieldTipo.setEditable(false);
        jTextFieldTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Precio:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Valoración:");

        jTextFieldPrecio.setEditable(false);
        jTextFieldPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldCalificacion.setEditable(false);
        jTextFieldCalificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Habitaciones:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Baños:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Huéspedes:");

        jTextFieldHuespedes.setEditable(false);
        jTextFieldHuespedes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldBaños.setEditable(false);
        jTextFieldBaños.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldHabitaciones.setEditable(false);
        jTextFieldHabitaciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldCamas.setEditable(false);
        jTextFieldCamas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Otros servicios:");

        jPanelReservar.setBackground(new java.awt.Color(255, 204, 204));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Fecha salida:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Fecha entrada:");

        jButtonReservar.setBackground(new java.awt.Color(255, 153, 51));
        jButtonReservar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonReservar.setText("Reservar");
        jButtonReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReservarActionPerformed(evt);
            }
        });

        jFormattedTextFechaIn.setEditable(false);
        try {
            jFormattedTextFechaIn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFechaIn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jFormattedTextFechaOut.setEditable(false);
        try {
            jFormattedTextFechaOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFechaOut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelReservarLayout = new javax.swing.GroupLayout(jPanelReservar);
        jPanelReservar.setLayout(jPanelReservarLayout);
        jPanelReservarLayout.setHorizontalGroup(
            jPanelReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservarLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jFormattedTextFechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFechaOut, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanelReservarLayout.setVerticalGroup(
            jPanelReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReservarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jButtonReservar)
                    .addComponent(jFormattedTextFechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFechaOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Camas:");

        jLabelAnfitrion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAnfitrion.setText("Anfitrion: ");

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNumero.setText("Teléfono:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelReservar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jTextFieldCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTextFieldHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldBaños, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCamas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addComponent(jLabelAnfitrion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabelTitulo)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelDireccion)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabelAnfitrion)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldHuespedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextFieldBaños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextFieldCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero))
                .addGap(12, 12, 12)
                .addComponent(jPanelReservar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void jButtonReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReservarActionPerformed
        int opt = JOptionPane.showConfirmDialog(this, "¿Desea confirmar su reserva?", "Reservar", JOptionPane.YES_NO_CANCEL_OPTION);
        try {
            String fechaIn =jFormattedTextFechaIn.getText();
            String fechaOut =jFormattedTextFechaOut.getText();
            fechaEntrada = JavaBNB.setFechaFutura(fechaIn);
            fechaSalida = JavaBNB.setFechaFutura(fechaOut);
            if (opt == JOptionPane.YES_OPTION && !(fechaIn.equals(fechaOut)||fechaEntrada.isAfter(fechaSalida))) {
                Reserva r = new Reserva(inmueble, particular, fechaEntrada, fechaSalida);
                JOptionPane.showMessageDialog(this, "Reservada confirmada\n Pago realizado por el importe de " + r.getPrecio() + " €\nFactura generada. Consúltela en la carpeta correspondiente", "Reserva de inmueble", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            }else if (fechaIn.equals(fechaOut)){
                throw new ReservarException("La fecha de entrada no puede ser la misma que la de salida.");
            }else if (fechaEntrada.isAfter(fechaSalida)){
                throw new ReservarException("La fecha de entrada no puede ser posterior a la de salida.");
            }
            jFormattedTextFechaIn.setEditable(true);
            jFormattedTextFechaOut.setEditable(true);
        } catch (ReservarException re) {
            JOptionPane.showMessageDialog(this, re.getMessage()+"\nModifique las fechas", "Reserva de inmueble", JOptionPane.ERROR_MESSAGE);
            jFormattedTextFechaIn.setEditable(true);
            jFormattedTextFechaOut.setEditable(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Reserva de inmueble", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonReservarActionPerformed

    private void cargarDatos() {
        try {
            jLabelTitulo.setText(inmueble.getTitulo());
            jLabelDireccion.setText(inmueble.getDireccion().toString());
            jTextFieldTipo.setText(inmueble.getTipo());
            jTextFieldPrecio.setText(String.valueOf(inmueble.getPrecioNoche()) + " € / noche");
            DecimalFormat formato = new DecimalFormat("#.##");
            jTextFieldCalificacion.setText(formato.format(inmueble.getCalificacion()) + " /5 ("+inmueble.getNumCalificaciones()+")");
            ImageIcon img = new ImageIcon("./imagenes/" + inmueble.getFoto());
            ImageIcon imgRedimensionada = new ImageIcon(img.getImage().getScaledInstance(219, 140, 1));
            jLabelFoto.setIcon(imgRedimensionada);
            jTextFieldCamas.setText(String.valueOf(inmueble.getCamas()));
            jTextFieldHabitaciones.setText(String.valueOf(inmueble.getHabitaciones()));
            jTextFieldBaños.setText(String.valueOf(inmueble.getBaños()));
            jTextFieldHuespedes.setText(String.valueOf(inmueble.getHuespedes()));
            if (reservar){
                DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                jFormattedTextFechaIn.setText(fechaEntrada.format(formatoCorto));
                jFormattedTextFechaOut.setText(fechaSalida.format(formatoCorto));
            }
            String[] serviciosList = inmueble.getServicios().split(",");
            String serviciosMostrar = "";
            for (String s : serviciosList) {
                serviciosMostrar += (s + "\n");
            }
            jTextArea1.setText(serviciosMostrar);
            jLabelNumero.setText("Teléfono: "+inmueble.getAnfitrion().getTelefono());
            if(inmueble.getAnfitrion().isSuperAnfitrion()) jLabelAnfitrion.setText("Superanfitrión: "+inmueble.getAnfitrion().getNombre());
            else jLabelAnfitrion.setText("Anfitrión: "+inmueble.getAnfitrion().getNombre());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Reserva de inmueble", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReservar;
    private javax.swing.JFormattedTextField jFormattedTextFechaIn;
    private javax.swing.JFormattedTextField jFormattedTextFechaOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAnfitrion;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelReservar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldBaños;
    private javax.swing.JTextField jTextFieldCalificacion;
    private javax.swing.JTextField jTextFieldCamas;
    private javax.swing.JTextField jTextFieldHabitaciones;
    private javax.swing.JTextField jTextFieldHuespedes;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTipo;
    // End of variables declaration//GEN-END:variables
}
