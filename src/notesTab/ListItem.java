package notesTab;

import javax.swing.*;
import java.awt.*;

public class ListItem extends JTextArea {

    public ListItem(String title, String body) {

        //setColumns(50);
        setText("");

        append(">>> " + title);
        append("\n\n");
        append(body);

        setLineWrap(true);
        setWrapStyleWord(true);

    }
}
