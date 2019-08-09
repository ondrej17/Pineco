package notesTab;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class CustomCellRenderer implements ListCellRenderer {
    protected static EtchedBorder noFocusBorder = new EtchedBorder(EtchedBorder.RAISED);

    protected static EtchedBorder focusBorder = new EtchedBorder(EtchedBorder.LOWERED);

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
        renderer.setBorder(cellHasFocus ? focusBorder : noFocusBorder);
        return renderer;
    }
}