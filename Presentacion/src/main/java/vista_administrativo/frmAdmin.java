/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista_administrativo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author ang3lfco
 */
public class frmAdmin extends javax.swing.JFrame {
    /**
     * Creates new form frmAdmin
     */
    public frmAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        
        efectoBoton(pnlAgregarEquipo);
        efectoBoton(pnlBloquear);
        efectoBoton(pnlAgregarSoftware);
        efectoBoton(pnlDesbloquear);
        efectoBoton(pnlAgregarHorario);
        efectoBoton(pnlInstalaciones);
    }
    
    private void efectoBoton(JPanel panel) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(new Color(230, 230, 230));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.WHITE);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnlAgregarEquipo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlBloquear = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlAgregarSoftware = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlDesbloquear = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlAgregarHorario = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnlInstalaciones = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(1, 109, 183));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        pnlAgregarEquipo.setBackground(new java.awt.Color(255, 255, 255));
        pnlAgregarEquipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlAgregarEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAgregarEquipoMouseClicked(evt);
            }
        });
        pnlAgregarEquipo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ordenador-personal.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 15, 17, 0);
        pnlAgregarEquipo.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 109, 183));
        jLabel2.setText("Agregar Equipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 58, 0, 65);
        pnlAgregarEquipo.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 41, 0, 0);
        jPanel1.add(pnlAgregarEquipo, gridBagConstraints);

        pnlBloquear.setBackground(new java.awt.Color(255, 255, 255));
        pnlBloquear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBloquear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBloquearMouseClicked(evt);
            }
        });
        pnlBloquear.setLayout(new java.awt.GridBagLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bloqueo-web.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 15, 17, 0);
        pnlBloquear.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 109, 183));
        jLabel4.setText("Bloquear Acceso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 58, 0, 58);
        pnlBloquear.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 18, 0, 0);
        jPanel1.add(pnlBloquear, gridBagConstraints);

        pnlAgregarSoftware.setBackground(new java.awt.Color(255, 255, 255));
        pnlAgregarSoftware.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlAgregarSoftware.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAgregarSoftwareMouseClicked(evt);
            }
        });
        pnlAgregarSoftware.setLayout(new java.awt.GridBagLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/agregar-servidor.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 15, 17, 0);
        pnlAgregarSoftware.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 109, 183));
        jLabel6.setText("Agregar Software");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 58, 0, 46);
        pnlAgregarSoftware.add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 42, 0);
        jPanel1.add(pnlAgregarSoftware, gridBagConstraints);

        pnlDesbloquear.setBackground(new java.awt.Color(255, 255, 255));
        pnlDesbloquear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlDesbloquear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDesbloquearMouseClicked(evt);
            }
        });
        pnlDesbloquear.setLayout(new java.awt.GridBagLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/desbloqueado.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 15, 17, 0);
        pnlDesbloquear.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 109, 183));
        jLabel8.setText("Permitir Acceso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 58, 0, 63);
        pnlDesbloquear.add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        jPanel1.add(pnlDesbloquear, gridBagConstraints);

        pnlAgregarHorario.setBackground(new java.awt.Color(255, 255, 255));
        pnlAgregarHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlAgregarHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAgregarHorarioMouseClicked(evt);
            }
        });
        pnlAgregarHorario.setLayout(new java.awt.GridBagLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cambio.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 15, 17, 0);
        pnlAgregarHorario.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 109, 183));
        jLabel10.setText("Horarios Especiales");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 58, 0, 30);
        pnlAgregarHorario.add(jLabel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 41, 0, 0);
        jPanel1.add(pnlAgregarHorario, gridBagConstraints);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo3.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 575;
        gridBagConstraints.ipady = -95;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel11, gridBagConstraints);

        pnlInstalaciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlInstalaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlInstalaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlInstalacionesMouseClicked(evt);
            }
        });
        pnlInstalaciones.setLayout(new java.awt.GridBagLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/configuracion (1).png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 15, 17, 0);
        pnlInstalaciones.add(jLabel12, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 109, 183));
        jLabel13.setText("Instalaciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 58, 0, 90);
        pnlInstalaciones.add(jLabel13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 41, 42, 0);
        jPanel1.add(pnlInstalaciones, gridBagConstraints);

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

    private void pnlAgregarEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAgregarEquipoMouseClicked
        // TODO add your handling code here:
        frmEquipo equipo = new frmEquipo();
        equipo.setVisible(true);
    }//GEN-LAST:event_pnlAgregarEquipoMouseClicked

    private void pnlBloquearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBloquearMouseClicked
        // TODO add your handling code here:
        frmBloqueo bloqueo = new frmBloqueo();
        bloqueo.setVisible(true);
    }//GEN-LAST:event_pnlBloquearMouseClicked

    private void pnlAgregarSoftwareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAgregarSoftwareMouseClicked
        // TODO add your handling code here:
        frmSoftware software = new frmSoftware();
        software.setVisible(true);
    }//GEN-LAST:event_pnlAgregarSoftwareMouseClicked

    private void pnlDesbloquearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDesbloquearMouseClicked
        // TODO add your handling code here:
        frmDesbloqueo desbloqueo = new frmDesbloqueo();
        desbloqueo.setVisible(true);
    }//GEN-LAST:event_pnlDesbloquearMouseClicked

    private void pnlAgregarHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAgregarHorarioMouseClicked
        // TODO add your handling code here:
        frmHorario horario = new frmHorario();
        horario.setVisible(true);
    }//GEN-LAST:event_pnlAgregarHorarioMouseClicked

    private void pnlInstalacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlInstalacionesMouseClicked
        // TODO add your handling code here:
        frmInstalacion instalacion = new frmInstalacion();
        instalacion.setVisible(true);
    }//GEN-LAST:event_pnlInstalacionesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlAgregarEquipo;
    private javax.swing.JPanel pnlAgregarHorario;
    private javax.swing.JPanel pnlAgregarSoftware;
    private javax.swing.JPanel pnlBloquear;
    private javax.swing.JPanel pnlDesbloquear;
    private javax.swing.JPanel pnlInstalaciones;
    // End of variables declaration//GEN-END:variables
}
