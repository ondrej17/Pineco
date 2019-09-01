package gui.notesTab;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class LineWrapCellRenderer extends JTextArea implements TableCellRenderer {

    public LineWrapCellRenderer() {

        setWrapStyleWord(true);
        setLineWrap(true);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }

        setText((String)value);
        setSize(table.getColumnModel().getColumn(column).getWidth(),
                getPreferredSize().height);
        if (table.getRowHeight(row) != getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height);
        }

        return this;
    }
}
