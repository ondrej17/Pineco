package controller;

import model.Note;
import model.NoteStoreFile;

import java.io.File;
import java.util.List;

public class Controller {

    NoteStoreFile notesFile = new NoteStoreFile();

    public List<Note> getNotes() {
        return notesFile.getNotes();
    }

    public void loadFromFile(File file) {
        notesFile.loadFromFile(file);
    }

    public void saveToFile(File file) {
        notesFile.saveToFile(file);
    }
}
