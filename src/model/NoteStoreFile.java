package model;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class NoteStoreFile {

    private List<Note> notes;

    public NoteStoreFile() {
        notes = new LinkedList<Note>();
    }

    public List<Note> getNotes() {
        return notes;
    }

    // loads all lights in config file into HashMap
    public void loadFromFile(File file) {

        // loading lights
        // need to look like:
        // [name]   [participation]

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));

            String line1 = reader.readLine();
            String line2 = reader.readLine();

            while ((line1 != null) && (line2 != null)) {

                notes.add(new Note(line1, line2));

                // System.out.println(line);
                // read next line
                line1 = reader.readLine();
                line2 = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(File file) {

        // loading results
        // need to look like:
        // [name]   [participation]

        PrintWriter writer;
        try {
            writer = new PrintWriter(file, "UTF-8");

            for (Note note: notes) {
                // title1
                // body1
                // title2
                // body2
                // and so on ...

                String line = String.format("%s\n%s\n", note.getTitle(), note.getBody());
                writer.print(line);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
