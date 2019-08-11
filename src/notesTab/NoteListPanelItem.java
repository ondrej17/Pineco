package notesTab;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteListPanelItem extends JPanel {

    private JTextField titleField;
    private JTextField dateField;
    private JTextArea bodyField;

    private GridBagConstraints gc;

    private SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy 'at' hh:mm:ss");

    public NoteListPanelItem(String title, Date date, String body) {

        titleField = new JTextField(title);
        dateField = new JTextField(ft.format(date));
        bodyField = new JTextArea(body);

        setBorder(BorderFactory.createLineBorder(Color.YELLOW));

        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;
        add(titleField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;
        add(dateField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;
        add(bodyField, gc);

        setVisible(true);
    }
}
