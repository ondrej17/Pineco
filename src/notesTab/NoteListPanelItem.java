package notesTab;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteListPanelItem extends JPanel {

    private JTextField titleField;
    private JTextField dateField;
    private JTextArea bodyField;

    private SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy 'at' hh:mm:ss");

    public NoteListPanelItem(String title, Date date, String body) {

        titleField = new JTextField(title);
        dateField = new JTextField(ft.format(date));
        bodyField = new JTextArea(body);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.BLUE);

        setLayout(new FlowLayout());

        add(titleField);
        add(dateField);
        add(bodyField);

        setVisible(true);

        System.out.println(title);
        System.out.println(date);
        System.out.println(body);
    }
}
