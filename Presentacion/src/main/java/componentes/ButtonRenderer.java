/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ang3lfco
 */
public class ButtonRenderer extends JPanel implements TableCellRenderer {
    private final JButton editButton;
    private final JButton deleteButton;

    public ButtonRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(new Color(15,86,137));
        editButton = new JButton(new ImageIcon(getClass().getResource("/icons/editar2.png")));
        deleteButton = new JButton(new ImageIcon(getClass().getResource("/icons/eliminar1.png")));
        
        editButton.setPreferredSize(new Dimension(24, 24));
        deleteButton.setPreferredSize(new Dimension(24, 24));
        
        editButton.setBackground(Color.WHITE);
        deleteButton.setBackground(Color.WHITE);
        
        editButton.setBorderPainted(false);
        editButton.setFocusPainted(false);
        editButton.setContentAreaFilled(false);
        
        deleteButton.setBorderPainted(false);
        deleteButton.setFocusPainted(false);
        deleteButton.setContentAreaFilled(false);
        add(editButton);
        add(deleteButton);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
