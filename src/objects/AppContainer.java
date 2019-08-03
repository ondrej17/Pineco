package objects;

import javax.swing.*;
import java.awt.*;

public class AppContainer extends JPanel {

    // all components in container
    private GridBagConstraints gc;
    private JLabel testLabel;
    private JLabel todosLabel1 = new JLabel("Todos 1");
    private JLabel todosLabel2 = new JLabel("Todos 2");
    private JLabel notesLabel1 = new JLabel("Notes 1");
    private JLabel notesLabel2 = new JLabel("Notes 2");

    public AppContainer() {

        testLabel = new JLabel("Welcome Panel");

        // set layout
        setLayout(new GridBagLayout());

        // create an important object - gc
        gc = new GridBagConstraints();

        // something that needs to be done
        gc.fill = GridBagConstraints.NONE;

        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(testLabel, gc);
    }

    // after clicking App -> Todos it creates panel for Todos
    public void prepareTodosPanel() {
        System.out.println("Preparing Todos Panel");

        // hide welcome screen
        testLabel.setVisible(false);

        // hide notes things
        notesLabel1.setVisible(false);
        notesLabel2.setVisible(false);

        // unhide todos things
        todosLabel1.setVisible(true);
        todosLabel2.setVisible(true);

        // set up todos things
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(todosLabel1, gc);

        gc.gridy = 0;
        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(todosLabel2, gc);

    }

    // after clicking App -> Notes it creates panel for Notes
    public void prepareNotesPanel() {
        System.out.println("Preparing Notes Panel");

        // hide welcome screen
        testLabel.setVisible(false);

        // hide todos things
        todosLabel1.setVisible(false);
        todosLabel2.setVisible(false);

        // unhide notes things
        notesLabel1.setVisible(true);
        notesLabel2.setVisible(true);

        // set up notes things
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(notesLabel1, gc);

        gc.gridy = 1;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(notesLabel2, gc);
    }
}
