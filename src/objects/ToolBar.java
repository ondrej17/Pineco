package objects;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JPanel {

    // all components in toolbar
    private GridBagConstraints gc;
    private JLabel welcomeLabel = new JLabel("Welcome ToolBar");
    private JButton welcomeBtn = new JButton("Welcome Button");
    private JButton todosBtn = new JButton("Todos Button");
    private JButton notesBtn = new JButton("Notes Button");
    private JButton calendarBtn = new JButton("Calendar Button");

    public ToolBar() {

        // set layout
        setLayout(new GridBagLayout());

        // create an important object - gc
        gc = new GridBagConstraints();

        // something that needs to be done
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(welcomeLabel, gc);

        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(welcomeBtn, gc);

    }

    // after clicking App -> Todos it creates toolbar for Todos
    public void prepareTodosToolbar() {
        System.out.println("Preparing Todos Toolbar");

        // hide welcome toolbar things
        welcomeLabel.setVisible(false);
        welcomeBtn.setVisible(false);

        // unhide those components of toolbar, which are used in Todos
        todosBtn.setVisible(true);

        // hide those components of toolbar, which are not used in Todos
        notesBtn.setVisible(false);
        calendarBtn.setVisible(false);

        // set up todos things
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(todosBtn , gc);
    }

    // after clicking App -> Notes it creates toolbar for Notes
    public void prepareNotesToolbar() {
        System.out.println("Preparing Notes Toolbar");

        // hide welcome toolbar things
        welcomeLabel.setVisible(false);
        welcomeBtn.setVisible(false);

        // unhide those components of toolbar, which are used in Notes
        notesBtn.setVisible(true);

        // hide those components of toolbar, which are not used in Notes
        todosBtn.setVisible(false);
        calendarBtn.setVisible(false);

        // set up notes things
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(notesBtn, gc);
    }

    public void prepareCalendarToolbar() {
        System.out.println("Preparing Calendar Toolbar");

        // hide welcome toolbar things
        welcomeLabel.setVisible(false);
        welcomeBtn.setVisible(false);

        // unhide those components of toolbar, which are used in Notes
        calendarBtn.setVisible(true);

        // hide those components of toolbar, which are not used in Notes
        todosBtn.setVisible(false);
        notesBtn.setVisible(false);

        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(calendarBtn, gc);
    }
}

