import objects.AppContainer;
import objects.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class MainFrame extends JFrame {

    // components of MainFrame
    private ToolBar toolbar; // on the left
    private AppContainer container; // on the right, contains calendar, todos or notes

    // constructor of MainFrame
    public MainFrame() {

        // name of frame
        super("Order");

        // set layout for this frame
        setLayout(new GridBagLayout());

        // create an important object - gc
        GridBagConstraints gc = new GridBagConstraints();

        // something that needs to be done
        gc.fill = GridBagConstraints.BOTH;

        // set components
        toolbar = new ToolBar();
        container = new AppContainer();
        setJMenuBar(createMenuBar());

        // add components to gridLayout
        gc.gridy = 0; // first row

            // first column
            gc.weightx = 0.2;
            gc.weighty = 1;
            gc.gridx = 0;
            gc.anchor = GridBagConstraints.CENTER;
            gc.insets = new Insets(0, 0, 0, 0);
            add(toolbar, gc);

            // second column
            gc.weightx = 6;
            gc.weighty = 1;
            gc.gridx = 1;
            gc.anchor = GridBagConstraints.CENTER;
            gc.insets = new Insets(0, 0, 0, 0);
            add(container, gc);


        // set size of new window
        setMinimumSize(new Dimension(500, 600));
        //setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        // set what program should do when closing window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set visible, so we can see it
        setVisible(true);
    }


    public JMenuBar createMenuBar() {

        // create menuBar
        JMenuBar menuBar = new JMenuBar();

        // create each menus in menuBar
        JMenu appMenu = new JMenu("App");
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        // add menus to menuBar
        menuBar.add(appMenu);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // create menuItems in appMenu
        JMenuItem notes = new JMenuItem("Notes");
        JMenuItem todos = new JMenuItem("To-Do");

        // add menuItems to appMenu
        appMenu.add(notes);
        appMenu.add(todos);


        // add menuItems to other menus

        // set up actionListener for each item
        notes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.prepareNotesPanel();
                toolbar.prepareNotesToolbar();
            }
        });

        todos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                container.prepareTodosPanel();
                toolbar.prepareTodosToolbar();
            }
        });
        return menuBar;
    }
}
