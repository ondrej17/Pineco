package objects;

import javax.swing.*;
import java.awt.*;

public class AppPanel extends JPanel {

    // needed objects
    private GridBagConstraints gc;

    // objects on welcome screen
    private JLabel welcomeLabel;

    // objects on todos panel
    private JLabel todosLabel1 = new JLabel("Todos 1");
    private JLabel todosLabel2 = new JLabel("Todos 2");

    //objects on notes panel
    private JLabel notesLabel1 = new JLabel("Notes 1");
    private JLabel notesLabel2 = new JLabel("Notes 2");

    // objects on calendar panel
    private JLabel calendarLabel1 = new JLabel("Calendar 1");
    private JLabel calendarLabel2 = new JLabel("Calendar 2");

    // constructor of class
    public AppPanel() {

        welcomeLabel = new JLabel("Welcome Panel");

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
        add(welcomeLabel, gc);
    }

    // after clicking App -> Todos it creates panel for Todos
    public void prepareTodosPanel() {
        System.out.println("Preparing Todos Panel");

        // hide welcome screen
        welcomeLabel.setVisible(false);

        // hide notes things
        notesLabel1.setVisible(false);
        notesLabel2.setVisible(false);

        // hide calendar things
        calendarLabel1.setVisible(false);
        calendarLabel2.setVisible(false);

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
        welcomeLabel.setVisible(false);

        // hide todos things
        todosLabel1.setVisible(false);
        todosLabel2.setVisible(false);

        // hide calendar things
        calendarLabel1.setVisible(false);
        calendarLabel2.setVisible(false);

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

    // after clicking App -> Calendar it creates panel for Calendar
    public void prepareCalendarPanel() {
        System.out.println("Preparing Calendar Panel");

        // hide welcome screen
        welcomeLabel.setVisible(false);

        // hide todos things
        todosLabel1.setVisible(false);
        todosLabel2.setVisible(false);

        // hide notes things
        notesLabel1.setVisible(false);
        notesLabel2.setVisible(false);

        // unhide calendar things
        calendarLabel1.setVisible(true);
        calendarLabel2.setVisible(true);

        // set up calendar things
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(calendarLabel1, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(calendarLabel2, gc);
    }
}
