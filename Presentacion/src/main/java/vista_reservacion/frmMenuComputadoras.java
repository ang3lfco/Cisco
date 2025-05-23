/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista_reservacion;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteIngresaDTO;
import excepciones.NegocioException;
import exceptiones.PresentacionException;
import interfaces.IReservacionNegocio;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import vista_computadora.frmComputadora;

/**
 *
 * @author ReneEzequiel23
 */
public class frmMenuComputadoras extends javax.swing.JFrame {

    IReservacionNegocio reservacionNegocio;
    EstudianteIngresaDTO estudiante;
    int minutos;
    String tipo = "Reservacion";
    /**
     * Creates new form frmMenuComputadoras
     */
    public frmMenuComputadoras(IReservacionNegocio reservacionNegocio, EstudianteIngresaDTO estudiante) {
        this.reservacionNegocio = reservacionNegocio;
        this.estudiante = estudiante;
        initComponents();
        this.agregarBotones();
        this.llenarDatosEnPantalla();
    }

    public void llenarDatosEnPantalla(){
        lblNombreEstudiante.setText(estudiante.getNombre() + " " + 
                estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno());
        
        txtTiempo.setText(Integer.toString(estudiante.getTiempoDiario()));
    }
    
    
    private void agregarBotones() {
        List<ComputadoraDTO> computadoras = null;
        try {
            Long idLab = this.obtenerEquipo(this.obtenerIpDelEquipo()).getLaboratorio().getId();
            computadoras = reservacionNegocio.numeroComputadorasDTO(idLab,"Estudiante");
        } catch (NegocioException ex) {
            Logger.getLogger(frmMenuComputadoras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PresentacionException ex) {
            Logger.getLogger(frmMenuComputadoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (computadoras.isEmpty()) {
            
        }else{
        int columnas = (int) Math.ceil(Math.sqrt(computadoras.size()));
        int filas = (int) Math.ceil((double) computadoras.size() / columnas);

        jPanel.setLayout(new GridLayout(filas, columnas, 10, 10));

        for (int i = 1; i <= computadoras.size(); i++) {
            JButton boton = new JButton(String.valueOf(computadoras.get(i-1).getNumero()));
            // Aquí puedes personalizar el botón (icono, acción, etc.)
            

            int numeroBoton = i;
            ComputadoraDTO equipo = computadoras.get(numeroBoton-1);
            //pintarBotones
            
            if (estudiante.getCarrera().equals("Ingenieria en software") || !equipo.getEtiqueta().isEmpty()) {
                
                if (equipo.getEtiqueta().equals("Programacion")) {
                    boton.setBackground(Color.green);
                }
            }if (estudiante.getCarrera().equals("mecatronica") || !equipo.getEtiqueta().isEmpty()) {
                if (equipo.getEtiqueta().equals("Modelado3D")) {
                    boton.setBackground(Color.green);
                }
            }
            
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minutos = Integer.valueOf(txtTiempo.getText());
                    
                    frmConfirmarReserva confirmacion = new frmConfirmarReserva(reservacionNegocio,estudiante,equipo,minutos);
                    System.out.println(equipo.getEtiqueta());
                    confirmacion.setVisible(true);
                    cerrarVentana();
                }
            });
            jPanel.add(boton);
        }
        }
    }
    
    public ComputadoraDTO obtenerEquipo(String ip) {
        ComputadoraDTO pc = null;
        try {
            pc = this.reservacionNegocio.computadoraPorIpYTipo(ip,tipo);
        } catch (NegocioException ex) {
            Logger.getLogger(frmComputadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pc;
    }

    public String obtenerIpDelEquipo() throws PresentacionException {
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            String ip = direccion.getHostAddress();

            return ip;
        } catch (UnknownHostException e) {
            throw new PresentacionException("Error. " + e.getMessage());
        }
    }
    
    public void cerrarVentana(){
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblLaboratorio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNombreEstudiante = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 93, 170));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Minutos:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Laboratorio:");

        lblLaboratorio.setText("lab");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Estudiante:");

        lblNombreEstudiante.setText("nombre");

        txtTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lblLaboratorio))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombreEstudiante)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEstudiante)
                    .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLaboratorio)
                .addGap(18, 18, 18)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmMenuComputadoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmMenuComputadoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmMenuComputadoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmMenuComputadoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmMenuComputadoras().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblLaboratorio;
    private javax.swing.JLabel lblNombreEstudiante;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}
