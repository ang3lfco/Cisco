/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista_administrativo;

import Dtos.AgregarBloqueoDTO;
import componentes.RoundedPanel;
import excepciones.NegocioException;
import interfaces.IAdministrativoNegocio;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ang3lfco
 */
public class frmBloqueo extends javax.swing.JFrame {
    private IAdministrativoNegocio adminNegocio;
    private int xMouse, yMouse;
    /**
     * Creates new form frmBloqueo
     */
    public frmBloqueo(IAdministrativoNegocio adminNegocio) {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
        this.adminNegocio = adminNegocio;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel redondo
        RoundedPanel mainPanel = new RoundedPanel(50, new Color(15,86,137));
        mainPanel.setOpaque(false);
        setContentPane(mainPanel);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        
        // Ajustar márgenes para evitar que los componentes cubran los bordes redondeados
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0) // Márgenes izquierdos
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addGap(0)) // Márgenes derechos
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0) // Márgenes superiores
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGap(0)) // Márgenes inferiores
        );

        jPanel1.setOpaque(false);
        
        // Movimiento del Frame
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                setLocation(evt.getXOnScreen() - xMouse, evt.getYOnScreen() - yMouse);
            }
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txaMotivo = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txfID = new javax.swing.JTextField();
        btnBloquear = new javax.swing.JButton();
        lblExpandir = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(15, 86, 137));

        txaMotivo.setColumns(20);
        txaMotivo.setRows(5);
        jScrollPane1.setViewportView(txaMotivo);

        jLabel2.setText("Motivo del bloqueo:");
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Estudiante a bloquear:");
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        txfID.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txfID.setText("ID de estudiante");

        btnBloquear.setText("Bloquear");
        btnBloquear.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnBloquear.setForeground(new java.awt.Color(15, 86, 137));
        btnBloquear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBloquearMouseClicked(evt);
            }
        });

        lblExpandir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/expandir.png"))); // NOI18N
        lblExpandir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExpandirMouseClicked(evt);
            }
        });

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimizar.png"))); // NOI18N
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cerrar.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBloquear)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel1)
                        .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblExpandir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCerrar)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblExpandir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnBloquear)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBloquearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBloquearMouseClicked
        // TODO add your handling code here:
        AgregarBloqueoDTO bloqueoDTO = new AgregarBloqueoDTO(LocalDateTime.now(), txaMotivo.getText(), txfID.getText());
        try {
            adminNegocio.agregarBloqueo(bloqueoDTO);
            JOptionPane.showMessageDialog(null, "Bloqueo asignado.");
            this.dispose();
        } 
        catch (NegocioException ex) {
            Logger.getLogger(frmEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBloquearMouseClicked

    private void lblExpandirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExpandirMouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState() == JFrame.MAXIMIZED_BOTH){
            this.setExtendedState(JFrame.NORMAL);
        }
        else{
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_lblExpandirMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(frmBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmBloqueo().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloquear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblExpandir;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JTextArea txaMotivo;
    private javax.swing.JTextField txfID;
    // End of variables declaration//GEN-END:variables
}
