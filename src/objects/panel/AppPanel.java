package objects.panel;

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
    private DefaultListModel listModel = new DefaultListModel();
    private JList list = new JList(listModel);

    // objects on calendar panel
    private JLabel calendarLabel1 = new JLabel("Calendar 1");
    private JLabel calendarLabel2 = new JLabel("Calendar 2");

    // constructor
    public AppPanel() {

        // set borders and title
        this.setBorder(BorderFactory.createTitledBorder("Welcome Screen"));

        welcomeLabel = new JLabel("Welcome panel");

        // set layout
        setLayout(new FlowLayout());

        add(welcomeLabel);
    }

    // after clicking App -> Todos it creates panel for Todos
    public void prepareTodosPanel() {
        System.out.println("Preparing Todos panel");

        // set borders and title
        this.setBorder(BorderFactory.createTitledBorder("TO-DO"));

        // hide welcome screen
        welcomeLabel.setVisible(false);

        // hide notes things
        list.setVisible(false);

        // hide calendar things
        calendarLabel1.setVisible(false);
        calendarLabel2.setVisible(false);

        // unhide todos things
        todosLabel1.setVisible(true);
        todosLabel2.setVisible(true);

        // set layout

        // set up todos things

        add(todosLabel1);

        add(todosLabel2);

    }

    // after clicking App -> Notes it creates panel for Notes
    public void prepareNotesPanel() {
        System.out.println("Preparing Notes panel");

        // set borders and title
        this.setBorder(BorderFactory.createTitledBorder("Notes"));

        // hide welcome screen
        welcomeLabel.setVisible(false);

        // hide todos things
        todosLabel1.setVisible(false);
        todosLabel2.setVisible(false);

        // hide calendar things
        calendarLabel1.setVisible(false);
        calendarLabel2.setVisible(false);

        // unhide notes things
        list.setVisible(true);

        // set layout
        setLayout(new BorderLayout(5, 5));

        // set up notes things
        add(list, BorderLayout.CENTER);

    }

    // after clicking App -> Calendar it creates panel for Calendar
    public void prepareCalendarPanel() {
        System.out.println("Preparing Calendar panel");

        // set borders and title
        this.setBorder(BorderFactory.createTitledBorder("Calendar"));

        // hide welcome screen
        welcomeLabel.setVisible(false);

        // hide todos things
        todosLabel1.setVisible(false);
        todosLabel2.setVisible(false);

        // hide notes things
        list.setVisible(false);

        // unhide calendar things
        calendarLabel1.setVisible(true);
        calendarLabel2.setVisible(true);

        // set layout

        // set up calendar things
        add(calendarLabel1);

        add(calendarLabel2);
    }

    public void addListItem(String note) {
        listModel.addElement(note);
    }
}
