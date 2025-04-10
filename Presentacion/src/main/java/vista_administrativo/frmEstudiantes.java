/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista_administrativo;

import Dtos.ConsultarEstudianteDTO;
import Dtos.EstudianteTablaDTO;
import componentes.ButtonEditor;
import componentes.ButtonRenderer;
import componentes.RoundedPanel;
import excepciones.NegocioException;
import interfaces.IAdministrativoNegocio;
import java.awt.Color;
import java.awt.Cursor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ang3lfco
 */
public class frmEstudiantes extends javax.swing.JFrame {
    private IAdministrativoNegocio adminNegocio;
    private int xMouse, yMouse;
    /**
     * Creates new form frmEstudiantes
     */
    public frmEstudiantes(IAdministrativoNegocio adminNegocio) {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.adminNegocio = adminNegocio;
        
        try {
            cargarDatos();
        } catch (NegocioException ex) {
            Logger.getLogger(frmEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        configurarTabla();
        
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
        
//        tblEstudiantes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            @Override
//            public void mouseMoved(java.awt.event.MouseEvent e) {
//                int row = tblEstudiantes.rowAtPoint(e.getPoint());
//                int column = tblEstudiantes.columnAtPoint(e.getPoint());
//
//                // Ajusta el número de columna según en cuál estén los botones
//                if (column == 4) { // o el número correcto
//                    tblEstudiantes.setCursor(new Cursor(Cursor.HAND_CURSOR));
//                } else {
//                    tblEstudiantes.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//                }
//            }
//        });
    }
    
    
    private void cargarDatos() throws NegocioException {
        List<EstudianteTablaDTO> estudiantes = adminNegocio.getEstudiantesTabla();
        
        DefaultTableModel model = (DefaultTableModel) tblEstudiantes.getModel();
        model.setRowCount(0);
        for(EstudianteTablaDTO c : estudiantes){
            Object[] row = new Object[6];
            row[0] = c.getIdEstudiante();
            row[1] = c.getNombre();
            row[2] = c.getApellidoPaterno();
            row[3] = c.getApellidoMaterno();
            row[4] = c.getEstado();
            row[5] = c.getCarrera();
            model.addRow(row);
        }
        tblEstudiantes.setRowHeight(50);
    }
    
    private void configurarTabla() {
        tblEstudiantes.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        ButtonEditor editor = new ButtonEditor(
            e -> {
                int fila = tblEstudiantes.getSelectedRow();
                if (fila >= 0){
                    String idEstudiante = (String) tblEstudiantes.getValueAt(fila, 0);
                    frmEditarEstudiante editar = new frmEditarEstudiante(adminNegocio, idEstudiante);
                    editar.setVisible(true);
//                    JOptionPane.showMessageDialog(null, ": " + idEstudiante);
                }
//                JOptionPane.showMessageDialog(tblEstudiantes, "Seleccionaste una fila para editar.");
            },
            e -> {
                int fila = tblEstudiantes.getSelectedRow();
                if (fila >= 0){
                    String idEstudiante = (String) tblEstudiantes.getValueAt(fila, 0);
                    int respuesta = JOptionPane.showConfirmDialog(
                        tblEstudiantes,
                        "¿Estás seguro que deseas eliminar al estudiante con ID: " + idEstudiante + "?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                    );
                    if (respuesta == JOptionPane.YES_OPTION){
                        try {
                            adminNegocio.eliminarEstudiante(idEstudiante);
                            cargarDatos();
                        } catch (NegocioException ex) {
                            Logger.getLogger(frmEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } 
                    else{
                        JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
                    }
                }
                JOptionPane.showMessageDialog(tblEstudiantes, "Seleccionaste una fila para eliminar.");
            }
        );
        tblEstudiantes.getColumnModel().getColumn(6).setCellEditor(editor);
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
        tblEstudiantes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblExpandir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(15, 86, 137));

        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idEstudiante", "Nombre", "Apellido Paterno", "Apellido Materno", "Estado", "Carrera", ""
            }
        ));
        jScrollPane1.setViewportView(tblEstudiantes);

        jButton1.setText("jButton1");

        jLabel1.setText("jLabel1");

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cerrar.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimizar.png"))); // NOI18N
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });

        lblExpandir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/expandir.png"))); // NOI18N
        lblExpandir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExpandirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblExpandir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMinimizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCerrar)
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblExpandir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addContainerGap())
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

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void lblExpandirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExpandirMouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState() == JFrame.MAXIMIZED_BOTH){
            this.setExtendedState(JFrame.NORMAL);
        }
        else{
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_lblExpandirMouseClicked

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
//            java.util.logging.Logger.getLogger(frmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new frmEstudiantes().setVisible(true);
//                } catch (NegocioException ex) {
//                    Logger.getLogger(frmEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblExpandir;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JTable tblEstudiantes;
    // End of variables declaration//GEN-END:variables
}
