package notesTab;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;

class EditableJList extends JList {
    public EditableJList(EditableListModel listModel) {
        setModel(listModel);
        addMouseListener();
        //setFixedCellWidth(50);
        setFixedCellHeight(100);

        // set our custom cell renderer
        setCellRenderer(new TextComponentCellRenderer());
    }

    private void addMouseListener() {
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    EditableListModel listModel = (EditableListModel) getModel();

                    // determine the clicked item
                    int index = locationToIndex(e.getPoint());
                    Object value = listModel.getElementAt(index);
                    final JTextComponent tc = (JTextComponent) value;

                    // set the appropriate border for editing
                    String classname = tc.getClass().getName().toString();
                    classname = classname.substring(classname.lastIndexOf("."));
                    tc.setBorder(UIManager.getBorder(classname + "border"));

                    // make this border appear in the JList
                    listModel.updateItem(index);

                    tc.addFocusListener(new FocusListener() {
                        public void focusGained(FocusEvent fe) {
                            // no selection color desired when editing a JTextComponent
                            clearSelection();
                        }

                        public void focusLost(FocusEvent fe) {
                            // remove the border again when stopped editing
                            tc.setBorder(null);
                        }
                    });

                    // request the focus on this component to be able to edit it
                    tc.requestFocus();

                    // listen to all key events on the JTextComponent and update the
                    // JList item every time.  Without this, you won't see the changes.
                    tc.getDocument().addDocumentListener(new UpdateListDocumentListener(listModel, index));
                }
            }
        };

        addMouseListener(mouseListener);
    }

    // DocumentListener that takes care of updating a JList item
    // when editing it.  Calls updateItem on our custom EditableListModel
    private class UpdateListDocumentListener implements DocumentListener {
        private EditableListModel elm;
        private int index;

        public UpdateListDocumentListener(EditableListModel elm, int index) {
            this.elm = elm;
            this.index = index;
        }

        public void insertUpdate(DocumentEvent e) {
            elm.updateItem(index);
        }

        public void removeUpdate(DocumentEvent e) {
            elm.updateItem(index);
        }

        public void changedUpdate(DocumentEvent e) {
            elm.updateItem(index);
        }
    }

    private class TextComponentCellRenderer implements ListCellRenderer {
        public Component getListCellRendererComponent(
                JList list,
                Object value,            // value to display
                int index,               // cell index
                boolean isSelected,      // is the cell selected
                boolean cellHasFocus)    // the list and the cell have the focus
        {
            JTextComponent tc = (JTextComponent) value;
            if (isSelected) {
                tc.setBackground(list.getSelectionBackground());
                tc.setForeground(list.getSelectionForeground());
            }
            else {
                tc.setBackground(list.getBackground());
                tc.setForeground(list.getForeground());
            }

            tc.setEnabled(list.isEnabled());
            tc.setFont(list.getFont());
            tc.setBorder(null);

            return (Component) value;
        }
    }

    public static class EditableListModel extends DefaultListModel {
        public void updateItem(int index) {
            fireContentsChanged(this, index, index);
        }

        public void addElement(JTextComponent tc) {
            super.addElement(tc);
        }

        public void removeElement(int index) {
            super.removeElementAt(index);
        }
    }
}
