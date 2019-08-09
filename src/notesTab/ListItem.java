package notesTab;

import javax.swing.*;

public class ListItem extends JTextArea {

    public ListItem(String date, String note) {

        append(date);
        append("\n");
        append(note);

    }

    public String toString() {
        String string = "";

        string = "note";

        return string;
    }
}
