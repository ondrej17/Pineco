package notesTab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesPanel extends JPanel {

    private NotesPanelListener notesPanelListener;
    private final GridBagConstraints gcPanel;
    private final JLabel noteNameLabel;
    private final JTextField noteNameField;
    private final JLabel noteFieldLabel;
    private final JScrollPane noteScrollPanel;
    private final JTextArea noteField;
    private final JButton addBtn;
    private final JButton delBtn;
    private final JScrollPane listScrollPanel;
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JLabel colorLabel;
    private JList colorList;

    // these colors we have available
    private final String colors[] = {"grey", "green", "red"};

    // constructor
    public NotesPanel() {

        // set layout
        setLayout(new GridBagLayout());
        gcPanel = new GridBagConstraints();

        // create components of NotesPanel
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        colorLabel = new JLabel("Note Color");
        colorList = new JList(colors);
        colorList.setSelectedIndex(0);

        noteNameLabel = new JLabel("Note Title:");
        noteNameField = new JTextField(100);
        noteFieldLabel = new JLabel("Note:");
        noteField = new JTextArea();
        noteScrollPanel = new JScrollPane(noteField);
        listScrollPanel = new JScrollPane(list);
        addBtn = new JButton("Add Note");
        delBtn = new JButton("Delete Note");

        // set note field
        noteScrollPanel.setPreferredSize(new Dimension(500, 200));
        noteField.setLineWrap(true);
        noteField.setWrapStyleWord(true);

        // set list
        listScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listScrollPanel.setPreferredSize(new Dimension(500, 200));
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(-1);
        list.setCellRenderer(new CustomCellRenderer());

        // add components to layout
        // LEFT PART - toolbar
        gcPanel.gridx = 0;      gcPanel.gridy = 0;
        gcPanel.weightx = 0.1;    gcPanel.weighty = 0.1;
        gcPanel.insets = new Insets(10, 0, 10, 5);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.LINE_END;
        add(noteNameLabel, gcPanel);

        gcPanel.gridx = 1;      gcPanel.gridy = 0;
        gcPanel.weightx = 1;    gcPanel.weighty = 0.1;
        gcPanel.insets = new Insets(10, 5, 10, 10);
        gcPanel.fill = GridBagConstraints.BOTH;
        gcPanel.anchor = GridBagConstraints.LINE_START;
        add(noteNameField, gcPanel);

        gcPanel.gridx = 0;      gcPanel.gridy = 1;
        gcPanel.weightx = 0.1;    gcPanel.weighty = 1;
        gcPanel.insets = new Insets(10, 0, 10, 5);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        add(noteFieldLabel, gcPanel);

        gcPanel.gridx = 1;      gcPanel.gridy = 1;
        gcPanel.weightx = 1;    gcPanel.weighty = 1;
        gcPanel.insets = new Insets(10, 5, 10, 10);
        gcPanel.fill = GridBagConstraints.BOTH;
        gcPanel.anchor = GridBagConstraints.LINE_START;
        add(noteScrollPanel, gcPanel);

        gcPanel.gridx = 0;      gcPanel.gridy = 2;
        gcPanel.weightx = 0.1;    gcPanel.weighty = 1;
        gcPanel.insets = new Insets(10, 0, 10, 5);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        add(colorLabel, gcPanel);

        gcPanel.gridx = 1;      gcPanel.gridy = 2;
        gcPanel.weightx = 1;    gcPanel.weighty = 0.5;
        gcPanel.insets = new Insets(10, 5, 10, 10);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.FIRST_LINE_START;
        add(colorList, gcPanel);

        gcPanel.gridx = 1;      gcPanel.gridy = 4;
        gcPanel.weightx = 1;    gcPanel.weighty = 1;
        gcPanel.insets = new Insets(20,  20, 20, 20);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.CENTER;
        add(addBtn, gcPanel);

        gcPanel.gridx = 1;      gcPanel.gridy = 5;
        gcPanel.weightx = 1;    gcPanel.weighty = 1;
        gcPanel.insets = new Insets(20, 20, 20, 20);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.CENTER;
        add(delBtn, gcPanel);

        // RIGHT PART - list
        gcPanel.gridx = 2;      gcPanel.gridy = 0;
        gcPanel.gridheight = 6;
        gcPanel.weightx = 4;    gcPanel.weighty = 1;
        gcPanel.insets = new Insets(20, 20, 20, 20);
        gcPanel.fill = GridBagConstraints.BOTH;
        gcPanel.anchor = GridBagConstraints.CENTER;
        add(listScrollPanel, gcPanel);

        // ACTIONS OF BUTTONS
        // if addBtn is clicked, it triggers this NotesPanelEvent
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

        // if delBtn is clicked, it triggers this NotesPanelEvent
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

    // function that sets listener !
    public void setNotesPanelListener(NotesPanelListener listener) {
        this.notesPanelListener = listener;
    }

    // function that adds note to list
    public void addListItem() {

        // add only non-empty note
        if (noteField.getText().trim().length() != 0) {
            // getting actual time
            Date date = new Date( );

            // create new string that will be note
            ListItem note = new ListItem(noteNameField.getText(), date, noteField.getText());

            // add note to the list
            listModel.addElement(note.getNoteDetail());

            // clear note field
            noteField.setText("");
        }

    }

    // function that deletes selected note from list
    private void delListItem() {

        // get index of selected note
        int index = list.getSelectedIndex();

        // remove that note
        if (index != -1) {
            listModel.removeElementAt(index);
        }
    }
}
