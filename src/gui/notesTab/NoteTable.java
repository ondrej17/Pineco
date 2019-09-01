package gui.notesTab;

import model.Note;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.util.List;

public class NoteTable extends JTable {

    private final JTable table;
    private final NoteTableModel dataTableModel;

    public NoteTable() {

        dataTableModel = new NoteTableModel();
        table = new JTable(dataTableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setDefaultRenderer(String.class, new LineWrapCellRenderer());
        table.setTableHeader(null);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(400);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);

    }

    @Override
    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public void addNote(String title, String body) {
        dataTableModel.addNote(new Note(title, body));
        dataTableModel.fireTableDataChanged();
    }

    public void removeNote(int index) {
        dataTableModel.removeNote(index);
        dataTableModel.fireTableDataChanged();
    }

    public void setData(List<Note> notes) {
        dataTableModel.setData(notes);
    }

    public void refreshData() {
        dataTableModel.fireTableDataChanged();
    }

    public void clearData() {
        dataTableModel.clearData();
        dataTableModel.fireTableDataChanged();
    }
}
