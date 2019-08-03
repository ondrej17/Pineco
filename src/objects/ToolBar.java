package objects;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JPanel {

    // all components in toolbar
    private JLabel testLabel;
    private JButton testBtn;
    private JButton todosBtn;
    private JButton notesBtn;

    public ToolBar() {
        testLabel = new JLabel("Welcome ToolBar");
        testBtn = new JButton("Test Button");
        todosBtn = new JButton("Todos Button");
        notesBtn = new JButton("Notes Button");

        // set layout
        setLayout(new GridBagLayout());

        // create an important object - gc
        GridBagConstraints gc = new GridBagConstraints();

        // something that needs to be done
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(testLabel, gc);

        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(testBtn, gc);

        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(notesBtn, gc);

        gc.gridy = 3;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(todosBtn, gc);

    }

    // after clicking App -> Todos it creates toolbar for Todos
    public void prepareTodosToolbar() {
        System.out.println("Preparing Todos Toolbar");

        // unhide those components of toolbar, which are used in Todos
        todosBtn.setVisible(true);

        // hide those components of toolbar, which are not used in Todos
        notesBtn.setVisible(false);
    }

    // after clicking App -> Notes it creates toolbar for Notes
    public void prepareNotesToolbar() {
        System.out.println("Preparing Notes Toolbar");

        // unhide those components of toolbar, which are used in Notes
        notesBtn.setVisible(true);

        // hide those components of toolbar, which are not used in Notes
        todosBtn.setVisible(false);
    }
}

