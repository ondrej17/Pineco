package notesTab;

import javax.swing.*;

public class ListItem extends JTextArea {

    public ListItem(String title) {

        //setColumns(50);
        setText(title);
        setLineWrap(true);
        setWrapStyleWord(true);

    }
}
