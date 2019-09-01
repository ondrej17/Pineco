package gui.notesTab;

import javax.swing.*;
import java.awt.*;

public class NoteTable extends JTable {

    private final JTable table;
    private final NoteTableModel dataTableModel;

    public NoteTable() {

        dataTableModel = new NoteTableModel();
        table = new JTable(dataTableModel);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);

    }

    public void loadNotes() {
        // app will load notes from config file to notePanel
    }

    public void addNote(String title, String body) {
        dataTableModel.addNote(new Object[]{title + "\n" + body});
    }

    public void removeNote(int index) {
        dataTableModel.removeNote(index);
    }
}
