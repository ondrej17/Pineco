package gui.notesTab;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class NotesPanel extends JPanel {


    private Controller controller;

    private NotesPanelListener notesPanelListener;
    private final JLabel noteNameLabel;
    private final JScrollPane noteNameScrollPanel;
    private final JTextArea noteNameField;
    private final JLabel noteFieldLabel;
    private final JScrollPane noteBodyScrollPanel;
    private final JTextArea noteField;
    private final JButton addBtn;
    private final JButton delBtn;
    private final NoteTable noteTable;


    // constructor
    public NotesPanel() {

        // set up controller
        controller = new Controller();

        // create components of NotesPanel
        noteTable = new NoteTable();
        noteNameLabel = new JLabel("Note Title:");
        noteNameField = new JTextArea();
        noteNameScrollPanel = new JScrollPane(noteNameField);
        noteFieldLabel = new JLabel("Note:");
        noteField = new JTextArea();
        noteBodyScrollPanel = new JScrollPane(noteField);
        addBtn = new JButton("Add Note");
        delBtn = new JButton("Delete Note");

        // set mnemonics
        addBtn.setMnemonic(KeyEvent.VK_A);
        delBtn.setMnemonic(KeyEvent.VK_D);

        // load notes from storage
        controller.loadFromFile(new File("notesStorage.txt"));
        noteTable.setData(controller.getNotes());

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

        // set layout and add components
        layoutComponents();
    }

    private void layoutComponents() {


        // set note field
        noteNameScrollPanel.setPreferredSize(new Dimension(300, 50));
        noteBodyScrollPanel.setPreferredSize(new Dimension(300, 200));
        noteField.setLineWrap(true);
        noteField.setWrapStyleWord(true);
        noteNameField.setLineWrap(true);
        noteNameField.setWrapStyleWord(true);

        GridBagConstraints gcPanel;

        // set layout
        setLayout(new GridBagLayout());
        gcPanel = new GridBagConstraints();

        // add components to layout
        // LEFT PART - toolbar
        gcPanel.gridx = 0;      gcPanel.gridy = 0;
        gcPanel.weightx = 0.1;    gcPanel.weighty = 0.5;
        gcPanel.insets = new Insets(10, 0, 10, 5);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        add(noteNameLabel, gcPanel);

        gcPanel.gridx = 1;      gcPanel.gridy = 0;
        gcPanel.weightx = 1;    gcPanel.weighty = 0.5;
        gcPanel.insets = new Insets(10, 5, 10, 10);
        gcPanel.fill = GridBagConstraints.BOTH;
        gcPanel.anchor = GridBagConstraints.LINE_START;
        add(noteNameScrollPanel, gcPanel);

        gcPanel.gridx = 0;      gcPanel.gridy = 1;
        gcPanel.weightx = 0.1;    gcPanel.weighty = 20;
        gcPanel.insets = new Insets(10, 0, 10, 5);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.FIRST_LINE_END;
        add(noteFieldLabel, gcPanel);

        gcPanel.gridx = 1;      gcPanel.gridy = 1;
        gcPanel.weightx = 1;    gcPanel.weighty = 20;
        gcPanel.insets = new Insets(10, 5, 10, 10);
        gcPanel.fill = GridBagConstraints.BOTH;
        gcPanel.anchor = GridBagConstraints.LINE_START;
        add(noteBodyScrollPanel, gcPanel);

        gcPanel.gridx = 1;      gcPanel.gridy = 3;
        gcPanel.weightx = 1;    gcPanel.weighty = 1;
        gcPanel.insets = new Insets(20,  20, 20, 20);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.CENTER;
        add(addBtn, gcPanel);

        gcPanel.gridx = 1;      gcPanel.gridy = 4;
        gcPanel.weightx = 1;    gcPanel.weighty = 1;
        gcPanel.insets = new Insets(20, 20, 20, 20);
        gcPanel.fill = GridBagConstraints.NONE;
        gcPanel.anchor = GridBagConstraints.CENTER;
        add(delBtn, gcPanel);

        // RIGHT PART - list
        gcPanel.gridx = 2;      gcPanel.gridy = 0;
        gcPanel.gridheight = 5;
        gcPanel.weightx = 10;    gcPanel.weighty = 1;
        gcPanel.insets = new Insets(10, 10, 10, 10);
        gcPanel.fill = GridBagConstraints.BOTH;
        gcPanel.anchor = GridBagConstraints.CENTER;
        add(noteTable, gcPanel);

    }

    // function that sets listener !
    public void setNotesPanelListener(NotesPanelListener listener) {
        this.notesPanelListener = listener;
    }

    // function that adds note to list
    public void addListItem() {

        // add only non-empty note
        if (noteField.getText().trim().length() != 0) {

            // add note to the list
            //String note = "<html>" + noteNameField.getText() + "<br>" + "<br>" + noteField.getText() + "</html>";

            noteTable.addNote(noteNameField.getText(), noteField.getText());
            noteTable.refreshData();
            controller.saveToFile(new File("notesStorage.txt"));

            // clear note field
            noteField.setText("");
            noteNameField.setText("");
        }

    }

    // function that deletes selected note from list
    private void delListItem() {

        // get index of selected note
        int index = noteTable.getSelectedRow();
        System.out.println(index);

        // remove that note
        if (index != -1) {
            noteTable.removeNote(index);

            noteTable.refreshData();
            controller.saveToFile(new File("notesStorage.txt"));
        }

    }
}
