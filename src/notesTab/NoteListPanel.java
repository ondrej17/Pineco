package notesTab;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class NoteListPanel extends JPanel {

    public NoteListPanel() {
        setLayout(new FlowLayout());
        setBackground(Color.PINK);

    }

    public void addElement(String title, Date date, String body) {

        setBackground(Color.RED);
        add(new NoteListPanelItem(title, date, body));
    }
}
