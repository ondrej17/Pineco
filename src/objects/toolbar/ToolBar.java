package objects.toolbar;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ForkJoinPool;

public class ToolBar extends JPanel {

    // needed objects
    private GridBagConstraints gc;
    private ToolbarListener toolbarListener;

    // objects on welcome toolbar
    private JLabel welcomeLabel = new JLabel("Welcome ToolBar");
    private JButton welcomeBtn = new JButton("Welcome Button");

    // objects on todos toolbar
    private JButton todosBtn = new JButton("Todos Button");

    // objects on notes toolbar
    private JButton addListItemBtn = new JButton("Add Note");

    // objects on calendar toolbar
    private JButton calendarBtn = new JButton("Calendar Button");

    // constructor
    public ToolBar() {

        // set borders and title
        this.setBorder(BorderFactory.createTitledBorder("Toolbar"));

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

        // set actions to all buttons
        addListItemBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean addListItemBtnClicked = true;

                ToolbarEvent ev = new ToolbarEvent(this, addListItemBtnClicked);

                if (toolbarListener != null) {
                    toolbarListener.toolbarEventOccured(ev);
                }
            }
        });

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
        addListItemBtn.setVisible(false);
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
        addListItemBtn.setVisible(true);

        // hide those components of toolbar, which are not used in Notes
        todosBtn.setVisible(false);
        calendarBtn.setVisible(false);

        // set up notes things
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(addListItemBtn, gc);
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
        addListItemBtn.setVisible(false);

        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(calendarBtn, gc);
    }

    public void setToolbarListener(ToolbarListener listener) {
        this.toolbarListener = listener;
    }

}

