/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaz;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import poo.clases.Anfitrion;
import poo.clases.Inmueble;

/**
 *
 * @author Marcos Barroso
 */
public final class PanelInmueblesAnf extends javax.swing.JPanel {
    private final Anfitrion anfitrion;
    private final ArrayList<Inmueble> inmuebles;
    private final JFrame parent;
       

    /**
     * Creates new form PanelInmueblesAnf
     * @param a anfitrion
     */
    public PanelInmueblesAnf(Anfitrion a,JFrame p) {
        initComponents();
        this.anfitrion=a;
        this.parent=p;
        inmuebles = anfitrion.getInmueblesAnfitrion();
        //mostrarDatos();
        mostrarInmuebles(inmuebles);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(0, 4, 5, 5));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
        
    public void mostrarInmuebles(ArrayList<Inmueble> inmuebles) {
        try {
            jPanel1.removeAll();
            if (inmuebles.isEmpty()) {
                JLabel jt = new javax.swing.JLabel();
                jt.setText("No se encuentran inmuebles para esa dirección");
                jt.setFont(new java.awt.Font("Segoe UI", 0, 16));
                jPanel1.add(jt);
            } else {
                for (Inmueble i : inmuebles) {
                    PanelInmVistaPrevia p = new PanelInmVistaPrevia(i, parent, false,true,this,anfitrion);
                    p.setSize(206, 303);
                    jPanel1.add(p);
                }
            }
            jPanel1.revalidate();
            jPanel1.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Inmuebles", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
