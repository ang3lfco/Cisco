/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista_administrativo;

import Dtos.EditarLaboratoriosDTO;
import Dtos.LaboratoriosTablaDTO;
import componentes.ButtonEditor;
import componentes.ButtonRenderer;
import componentes.RoundedPanel;
import excepciones.NegocioException;
import interfaces.IAdministrativoNegocio;
import java.awt.Color;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ReneEzequiel23
 */
public class frmLaboratorios extends javax.swing.JFrame {

    private IAdministrativoNegocio adminNegocio;
    private int xMouse, yMouse;
    /**
     * Creates new form frmLaboratorios
     */
    public frmLaboratorios(IAdministrativoNegocio adminNegocio) {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.adminNegocio = adminNegocio;
        try {
            cargarDatos();
            configurarTabla();
        } catch (NegocioException ex) {
            Logger.getLogger(frmComputadoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    
    private void cargarDatos() throws NegocioException {
        List<LaboratoriosTablaDTO> laboratorios;
        laboratorios = adminNegocio.getLaboratorios();
        
        
        DefaultTableModel model = (DefaultTableModel) tblLaboratorios.getModel();
        model.setRowCount(0);
        for (LaboratoriosTablaDTO l : laboratorios) {
            Object[] row = new Object[6];
            row[0] = l.getNombre();
            row[1] = l.getContraseña();
            row[2] = l.getHoraInicio();
            row[3] = l.getHoraFin();
            row[4] = l.getInstituto().getSiglas();
            model.addRow(row);
        }
        tblLaboratorios.setRowHeight(50);
    }

    private void configurarTabla() {
        tblLaboratorios.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());

        ButtonEditor editor = new ButtonEditor(
                e -> {
                    int fila = tblLaboratorios.getSelectedRow();
                    if (fila >= 0) {

                        EditarLaboratoriosDTO laboratorio;
                        
                        String nombre;
                        LocalTime inicio;
                        String contra;
                        String instituto;
                        LocalTime fin;
                        
                        nombre = (String) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 0);

                        contra = (String) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 1);
                        inicio = (LocalTime) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 2);
                        fin = (LocalTime) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 3);
                        instituto = (String) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 4);

                        laboratorio = new EditarLaboratoriosDTO(nombre, inicio, fin, contra, instituto);
                        
                        frmEditarLaboratorio editar = new frmEditarLaboratorio(adminNegocio, laboratorio);
                        editar.setVisible(true);
                    }
                },
                e -> {
                    EditarLaboratoriosDTO laboratorio;
                        
                        String nombre;
                        LocalTime inicio;
                        String contra;
                        String instituto;
                        LocalTime fin;
                        
                        nombre = (String) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 0);

                        contra = (String) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 1);
                        inicio = (LocalTime) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 2);
                        fin = (LocalTime) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 3);
                        instituto = (String) tblLaboratorios.getValueAt(tblLaboratorios.getSelectedRow(), 4);

                        laboratorio = new EditarLaboratoriosDTO(nombre, inicio, fin, contra, instituto);
                    
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro que deseas borrar?",
                            "Confirmar borrado",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if (respuesta == JOptionPane.YES_OPTION) {
                        adminNegocio.eliminarLaboratorio(laboratorio);
                    } else {
                        // Aquí puedes dejarlo vacío o hacer otra cosa si se cancela
                        JOptionPane.showMessageDialog(null, "Eliminacion cancelada");
                    }
                }
        );

        tblLaboratorios.getColumnModel().getColumn(5).setCellEditor(editor);
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
        tblLaboratorios = new javax.swing.JTable();
        lblAgregarLaboratorio = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblExpandir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(15, 86, 137));

        tblLaboratorios.setBackground(new java.awt.Color(15, 86, 137));
        tblLaboratorios.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        tblLaboratorios.setForeground(new java.awt.Color(255, 255, 255));
        tblLaboratorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "contraseña", "HoraInicio", "HoraFin", "Instituto", ""
            }
        ));
        jScrollPane1.setViewportView(tblLaboratorios);

        lblAgregarLaboratorio.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblAgregarLaboratorio.setForeground(new java.awt.Color(255, 255, 255));
        lblAgregarLaboratorio.setText("+ Agregar Laboratorio");
        lblAgregarLaboratorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarLaboratorioMouseClicked(evt);
            }
        });

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblAgregarLaboratorio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblExpandir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCerrar)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblExpandir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAgregarLaboratorio)
                .addGap(23, 23, 23))
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

    private void lblAgregarLaboratorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarLaboratorioMouseClicked
        frmAgregarLaboratorio laboratorio = new frmAgregarLaboratorio(this.adminNegocio);
        laboratorio.setVisible(true);
    }//GEN-LAST:event_lblAgregarLaboratorioMouseClicked

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
//            java.util.logging.Logger.getLogger(frmLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmLaboratorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmLaboratorios().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgregarLaboratorio;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblExpandir;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JTable tblLaboratorios;
    // End of variables declaration//GEN-END:variables
}
