/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista_reservacion;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.EstudianteIngresaDTO;
import Dtos.ReservaDTO;
import excepciones.NegocioException;
import interfaces.IReservacionNegocio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ReneEzequiel23
 */
public class frmConfirmarReserva extends javax.swing.JFrame {

    IReservacionNegocio reservacionNegocio;
    EstudianteIngresaDTO estudiante;
    ComputadoraDTO pc;
    /**
     * Creates new form frmConfirmarReserva
     */
    public frmConfirmarReserva(IReservacionNegocio reservacionNegocio, EstudianteIngresaDTO estudiante,ComputadoraDTO pc) {
        this.reservacionNegocio = reservacionNegocio;
        this.estudiante = estudiante;
        this.pc = pc;
        initComponents();
        this.llenarDatosEnPantalla();
    }
    
    private void llenarDatosEnPantalla(){
        alumnoLabel.setText(estudiante.getNombre() + " " + 
                estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno());
        
        cantidadMinutosLabel.setText(Integer.toString(estudiante.getTiempoDiario()));
        
        fechaLabel.setText(LocalDate.now().toString());
        
        numeroEquipoLabel.setText("Equipo: " + pc.getNumero());
        
        Long extra = Integer.toUnsignedLong(estudiante.getTiempoDiario());
        LocalTime fin = LocalTime.now().plusMinutes(extra);
        
        horaFinalLabel.setText(fin.getHour() + ":" + fin.getMinute());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fechaLabel = new javax.swing.JLabel();
        alumnoLabel = new javax.swing.JLabel();
        numeroEquipoLabel1 = new javax.swing.JLabel();
        cantidadMinutosLabel = new javax.swing.JLabel();
        numeroEquipoLabel2 = new javax.swing.JLabel();
        horaFinalLabel = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        lblNumeroEquipo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        numeroEquipoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 93, 170));

        fechaLabel.setText("dd/mm/aaaa");

        alumnoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        alumnoLabel.setText("Nombre alumno");

        numeroEquipoLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numeroEquipoLabel1.setText("Minutos apartados:");

        cantidadMinutosLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cantidadMinutosLabel.setText("90m");

        numeroEquipoLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numeroEquipoLabel2.setText("Su sesion finaliza en:");

        horaFinalLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        horaFinalLabel.setText("hh:mm");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        lblNumeroEquipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumeroEquipo.setText("programas");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        numeroEquipoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numeroEquipoLabel.setText("Equipo 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fechaLabel)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumeroEquipo)
                    .addComponent(numeroEquipoLabel)
                    .addComponent(btnAnterior)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alumnoLabel)
                    .addComponent(horaFinalLabel)
                    .addComponent(numeroEquipoLabel2)
                    .addComponent(cantidadMinutosLabel)
                    .addComponent(numeroEquipoLabel1)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(fechaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alumnoLabel)
                    .addComponent(numeroEquipoLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroEquipoLabel1)
                    .addComponent(lblNumeroEquipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(btnAnterior))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cantidadMinutosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numeroEquipoLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(horaFinalLabel)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        try {

        Long extra = Integer.toUnsignedLong(estudiante.getTiempoDiario());
        EstudianteDTO estudiante = new EstudianteDTO();
        ComputadoraDTO pc = new ComputadoraDTO();
        
        estudiante.setId(this.estudiante.getId());
        pc.setId(this.pc.getId());
        
        ReservaDTO reserva = new ReservaDTO(
                LocalDate.now(),
                LocalTime.now(),
                LocalTime.now().plusMinutes(extra),
                pc,
                estudiante
        );
        
            reservacionNegocio.agregarReserva(reserva);
            
            JOptionPane.showMessageDialog(null, "Reservacion realizada");
        } catch (NegocioException ex) {
            Logger.getLogger(frmConfirmarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnteriorActionPerformed

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
//            java.util.logging.Logger.getLogger(frmConfirmarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmConfirmarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmConfirmarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmConfirmarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmConfirmarReserva().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alumnoLabel;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JLabel cantidadMinutosLabel;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel horaFinalLabel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumeroEquipo;
    private javax.swing.JLabel numeroEquipoLabel;
    private javax.swing.JLabel numeroEquipoLabel1;
    private javax.swing.JLabel numeroEquipoLabel2;
    // End of variables declaration//GEN-END:variables
}
