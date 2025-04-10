/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author ang3lfco
 */
public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel;
    private final JButton editButton;
    private final JButton deleteButton;

    public ButtonEditor(ActionListener editAction, ActionListener deleteAction) {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        editButton = new JButton(new ImageIcon(getClass().getResource("/icons/editar2.png")));
        deleteButton = new JButton(new ImageIcon(getClass().getResource("/icons/eliminar1.png")));
        
        editButton.setPreferredSize(new Dimension(24, 24));
        deleteButton.setPreferredSize(new Dimension(24, 24));
        
        editButton.addActionListener(editAction);
        deleteButton.addActionListener(deleteAction);
        
        editButton.setBackground(Color.WHITE);
        deleteButton.setBackground(Color.WHITE);
        
        panel.add(editButton);
        panel.add(deleteButton);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}
