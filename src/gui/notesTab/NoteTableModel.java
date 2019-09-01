package gui.notesTab;

import model.Note;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class NoteTableModel extends AbstractTableModel {

    private List<Note> notes;

    private String[] colNames =  {"Title of Note", "Body of Note"};

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return notes.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Note light = notes.get(row);

        switch (col) {
            case 0:
                return light.getTitle();
            case 1:
                return light.getBody();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 0:
            case 1:
                return String.class;
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col)
    {
        if (notes == null) return;

        Note note = notes.get(row);

        switch (col) {
            case 0:
                note.setTitle((String) value);
                break;
            case 1:
                note.setBody((String) value);
                break;
            default:
                return;
        }
        fireTableCellUpdated(row, col);
    }

    public void setData(List<Note> lights) {
        this.notes = lights;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void removeNote(int index) {
        notes.remove(index);
    }

    public void clearData() {
        notes.removeAll(notes);
    }


}
