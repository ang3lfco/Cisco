/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista_administrativo;

import Dtos.ComputadoraDTO;
import Dtos.ConsultarEstudianteDTO;
import Dtos.EditarEquipoDTO;
import componentes.ButtonEditor;
import componentes.ButtonRenderer;
import componentes.RoundedPanel;
import excepciones.NegocioException;
import interfaces.IAdministrativoNegocio;
import java.awt.Color;
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
public class frmComputadoras extends javax.swing.JFrame {

    private IAdministrativoNegocio adminNegocio;
    private int xMouse, yMouse;
    /**
     * Creates new form frmComputadoras
     */
    public frmComputadoras(IAdministrativoNegocio adminNegocio) {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
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

        this.adminNegocio = adminNegocio;
        try {
            cargarDatos();
            configurarTabla();
        } catch (NegocioException ex) {
            Logger.getLogger(frmComputadoras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarDatos() throws NegocioException {
        List<ComputadoraDTO> ArrayList;

//        List<ComputadoraDTO> pcs = adminNegocio.getComputadoras();
        List<ComputadoraDTO> pcs = adminNegocio.getComputadoras();
        DefaultTableModel model = (DefaultTableModel) tblPcs.getModel();
        model.setRowCount(0);
        for (ComputadoraDTO c : pcs) {
            Object[] row = new Object[7];
            row[0] = c.getNumero();
            row[1] = c.isEstado();
            row[2] = c.getDireccionIp();
            row[3] = c.getTipo();
            row[4] = c.getLaboratorio().getNombre();
            row[5] = c.getEtiqueta();
            model.addRow(row);
        }
        tblPcs.setRowHeight(50);
    }

    private void configurarTabla() {
        tblPcs.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());

        ButtonEditor editor = new ButtonEditor(
                e -> {
                    int fila = tblPcs.getSelectedRow();
                    if (fila >= 0) {

                        EditarEquipoDTO equipo;
                        int numero;
                        String ip;
                        String tipo;
                        String lab;

                        numero = (int) tblPcs.getValueAt(tblPcs.getSelectedRow(), 0);

                        ip = (String) tblPcs.getValueAt(tblPcs.getSelectedRow(), 2);
                        tipo = (String) tblPcs.getValueAt(tblPcs.getSelectedRow(), 3);
                        lab = (String) tblPcs.getValueAt(tblPcs.getSelectedRow(), 4);
                        EditarEquipoDTO editarDto = new EditarEquipoDTO();

                        equipo = new EditarEquipoDTO(numero, ip, tipo, lab);
                        frmEditarEquipo editar = new frmEditarEquipo(this.adminNegocio, equipo);
                        editar.setVisible(true);
                    }
                },
                e -> {
                    EditarEquipoDTO equipo;
                    int numero;
                    String ip;
                    String tipo;
                    String lab;

                    numero = (int) tblPcs.getValueAt(tblPcs.getSelectedRow(), 0);
                     ip = (String) tblPcs.getValueAt(tblPcs.getSelectedRow(), 2);
                    tipo = (String) tblPcs.getValueAt(tblPcs.getSelectedRow(), 3);
                    lab = (String) tblPcs.getValueAt(tblPcs.getSelectedRow(), 4);
                    EditarEquipoDTO editarDto = new EditarEquipoDTO();

                    equipo = new EditarEquipoDTO(numero, ip, tipo, lab);
                    
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro que deseas borrar?",
                            "Confirmar borrado",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if (respuesta == JOptionPane.YES_OPTION) {
                        adminNegocio.eliminarComputadora(equipo);
                    } else {
                        // Aquí puedes dejarlo vacío o hacer otra cosa si se cancela
                        JOptionPane.showMessageDialog(null, "Eliminacion cancelada");
                    }
                }
        );

        tblPcs.getColumnModel().getColumn(6).setCellEditor(editor);
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
        tblPcs = new javax.swing.JTable();
        lblAgregarComputadora = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblExpandir = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(15, 86, 137));

        tblPcs.setBackground(new java.awt.Color(15, 86, 137));
        tblPcs.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        tblPcs.setForeground(new java.awt.Color(255, 255, 255));
        tblPcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Estado", "IP", "Tipo", "Laboratorio", "Etiqueta", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPcs);

        lblAgregarComputadora.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblAgregarComputadora.setForeground(new java.awt.Color(255, 255, 255));
        lblAgregarComputadora.setText("+ Agregar Computadora");
        lblAgregarComputadora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarComputadoraMouseClicked(evt);
            }
        });

        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cerrar.png"))); // NOI18N
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblAgregarComputadora)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblExpandir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCerrar)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblExpandir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblAgregarComputadora)
                .addContainerGap(35, Short.MAX_VALUE))
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

    private void lblAgregarComputadoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarComputadoraMouseClicked
        // TODO add your handling code here:
        frmEquipo agregarEquipo;
        try {
            agregarEquipo = new frmEquipo(adminNegocio);
            agregarEquipo.setVisible(true);
        } catch (NegocioException ex) {
            Logger.getLogger(frmComputadoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lblAgregarComputadoraMouseClicked

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
//            java.util.logging.Logger.getLogger(frmComputadoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmComputadoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmComputadoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmComputadoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmComputadoras().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgregarComputadora;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblExpandir;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JTable tblPcs;
    // End of variables declaration//GEN-END:variables
}
