package notesTab;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListItem extends JTextArea {

    private String title;
    private Date date;
    private String note;
    private SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy 'at' hh:mm:ss");

    public ListItem(String title, Date date, String note) {

        this.title = title;
        this.date = date;
        this.note = note;

        // do something with the note
        append(title);
        append("\n");
        append(note);

    }

    public String getNoteDetail() {
        return ft.format(date) + " - " + title;
    }

    public Date getNoteDate() {
        return date;
    }

    public String getNoteTitle() {
        return title;
    }

    public String getNoteBody() {
        return note;
    }

    public void saveNote() {

    }
}
