package notesTab;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class NoteListPanel extends JList {

    private int noteCounter = 0;

    private GridBagConstraints gc;

    public NoteListPanel(DefaultListModel listModel) {

        setModel(listModel);

        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();

    }

    public void addElement(String title, Date date, String body) {

        gc.gridx = 0;
        gc.gridy = noteCounter;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;
        add(new NoteListPanelItem(title, date, body), gc);

        updateUI();
        System.out.println(noteCounter);
        noteCounter++;
    }

}
