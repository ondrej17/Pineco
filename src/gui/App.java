package gui;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class App {

    public static void main(String[] args) {

//        // redirecting output in logFile.txt
//        try {
//            System.setOut(new PrintStream(new File("logFile.txt")));
//        }
//        catch(IOException e) {
//            System.out.println("File logFile.txt cannot be created...");
//        }

        // setting Look and Feel
        try {

            // system Look and Feel!
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception exc) {
            // Do nothing...
        }

        // we need this in case multi-threading in code
        SwingUtilities.invokeLater(new Runnable() {
            // need to override run method !
            @Override
            public void run() {
                // create new object - window
                new MainFrame();
            }
        });
    }
}
