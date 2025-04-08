/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista_administrativo;

import Dtos.AgregarBloqueoDTO;
import Dtos.AgregarComputadoraDTO;
import daos.BloqueoDAO;
import daos.ComputadoraDAO;
import daos.ConexionBD;
import daos.EstudianteDAO;
import daos.LaboratorioDAO;
import daos.SoftwareDAO;
import excepciones.NegocioException;
import interfaces.IAdministrativoNegocio;
import interfaces.IBloqueoDAO;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import interfaces.IEstudianteDAO;
import interfaces.ILaboratorioDAO;
import interfaces.ISoftwareDAO;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_administrativo.AdministrativoNegocio;

/**
 *
 * @author ang3lfco
 */
public class frmBloqueo extends javax.swing.JFrame {
    private IAdministrativoNegocio adminNegocio;
    /**
     * Creates new form frmBloqueo
     */
    public frmBloqueo() {
        IConexionBD conexion = new ConexionBD();
        IComputadoraDAO computadoraDAO = new ComputadoraDAO(conexion);
        ILaboratorioDAO laboratorioDAO = new LaboratorioDAO(conexion);
        ISoftwareDAO softwareDAO = new SoftwareDAO(conexion);
        IBloqueoDAO bloqueoDAO = new BloqueoDAO(conexion);
        IEstudianteDAO estudianteDAO = new EstudianteDAO(conexion);
        adminNegocio = new AdministrativoNegocio(computadoraDAO, laboratorioDAO, softwareDAO, bloqueoDAO, estudianteDAO);
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txaMotivo.setColumns(20);
        txaMotivo.setRows(5);
        jScrollPane1.setViewportView(txaMotivo);

        jLabel2.setText("Motivo del bloqueo:");

        jLabel1.setText("Estudiante a bloquear:");

        btnBloquear.setText("Bloquear");
        btnBloquear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBloquearMouseClicked(evt);
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
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
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
        try {
            AgregarBloqueoDTO bloqueoDTO = new AgregarBloqueoDTO(LocalDateTime.now(), txaMotivo.getText(), txfID.getText());
            adminNegocio.agregarBloqueo(bloqueoDTO);
        } catch (NegocioException ex) {
            Logger.getLogger(frmEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBloquearMouseClicked

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
            java.util.logging.Logger.getLogger(frmBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBloqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBloqueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloquear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaMotivo;
    private javax.swing.JTextField txfID;
    // End of variables declaration//GEN-END:variables
}
