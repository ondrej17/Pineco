package notesTab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotesPanel extends JPanel {

    private NotesPanelListener notesPanelListener;
    private final GridBagConstraints gcPanel;
    private final JTextArea noteField;
    private final JButton addBtn;
    private final JButton delBtn;
    private DefaultListModel listModel;
    private JList list;


    // constructor
    public NotesPanel() {

        // set layout
        this.setLayout(new GridBagLayout());
        gcPanel = new GridBagConstraints();
        gcPanel.fill = GridBagConstraints.BOTH;

        // create components of NotesPanel
        listModel = new DefaultListModel();
        list = new JList(listModel);
        noteField = new JTextArea(6, 30);
        addBtn = new JButton("Add Note");
        delBtn = new JButton("Delete Note");

        // set list
        list.setPreferredSize(new Dimension(200, 200));
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(10);

        // add components to layout
        // LEFT PART - toolbar
        // add toolbar things to toolbar
        gcPanel.gridx = 0;
        gcPanel.gridy = 0;
        gcPanel.weighty = 1;
        gcPanel.anchor = GridBagConstraints.CENTER;
        gcPanel.insets = new Insets(5, 5, 5, 5);
        add(noteField, gcPanel);

        gcPanel.gridx = 0;
        gcPanel.gridy = 1;
        gcPanel.weighty = 1;
        gcPanel.anchor = GridBagConstraints.CENTER;
        gcPanel.insets = new Insets(5, 5, 5, 5);
        add(addBtn, gcPanel);

        gcPanel.gridx = 0;
        gcPanel.gridy = 2;
        gcPanel.weighty = 1;
        gcPanel.anchor = GridBagConstraints.CENTER;
        gcPanel.insets = new Insets(5, 5, 5, 5);
        add(delBtn, gcPanel);

        // RIGHT PART - list
        gcPanel.gridheight = 3;
        gcPanel.gridx = 1;
        gcPanel.weightx = 1;
        gcPanel.weighty = 1;

        gcPanel.gridy = 0;
        gcPanel.anchor = GridBagConstraints.CENTER;
        gcPanel.insets = new Insets(5, 5, 5, 5);
        add(list, gcPanel);

        // set actions to all buttons
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                boolean addClicked = true;
                boolean delClicked = false;

                NotesPanelEvent event = new NotesPanelEvent(this, addClicked, delClicked);

                if (notesPanelListener != null) {
                    notesPanelListener.notesPanelEventOcurred(event);
                }
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                boolean addClicked = false;
                boolean delClicked = true;

                NotesPanelEvent event = new NotesPanelEvent(this, addClicked, delClicked);

                if (notesPanelListener != null) {
                    notesPanelListener.notesPanelEventOcurred(event);
                }
            }
        });

        // set notes panel listener
        setNotesPanelListener(new NotesPanelListener() {
            @Override
            public void notesPanelEventOcurred(NotesPanelEvent e) {

                // if add button was clicked, do this
                if (e.isAddClicked()) {
                    addListItem();
                }

                // if delete button was clicked, do this
                if (e.isDelClicked()) {
                    delListItem();
                }
            }
        });
    }

    // functions
    public void setNotesPanelListener(NotesPanelListener listener) {
        this.notesPanelListener = listener;
    }

    public void addListItem() {
        String note = noteField.getText();

        listModel.addElement(note);

        noteField.setText("");
    }

    private void delListItem() {
        int index = list.getSelectedIndex();
        if (index != -1) {
            listModel.removeElementAt(index);
        }
    }
}
