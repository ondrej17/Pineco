package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.NotesLibrary;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * main controller class
 */
public class Controller implements Initializable {
    // objects in application that we want to interact
    @FXML
    private ListView<String> notesListView;
    @FXML
    private TextArea noteBodyTextArea;
    @FXML
    private TextField noteTitleTextField;

    // object that stores all notes
    private NotesLibrary notesLibrary;


    /**
     * initialization of controller
     * loads notesLibrary from file and sets notesListView
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // initialize library of notes
        notesLibrary = new NotesLibrary(this.getFileWithNotes());

        // load notes to library
        notesLibrary.loadNotes();

        // get list of titles and upload them to notesListView
        notesListView.getItems().addAll(notesLibrary.getTitles());

    }

    /**
     * method that return the name of file that is ude to store the notes
     */
    private String getFileWithNotes() {

        // TODO: how to make it run on Linux too?
        // Linux version ?
        // return "docs/notesStorage.json";

        // Windows version
        return "docs" + File.separator + "notesStorage.json";
    }

    /**
     * method that is called when 'Add Note' is pressed in Notes Tab
     * only adds new note when title and body are not empty and note with same title is not in library
     * then saves a new note to json file
     */
    public void addNoteBtnClicked() {

        if (!noteBodyTextArea.getText().isEmpty() && !noteTitleTextField.getText().isEmpty()) {
            // current title of note
            String currentTitle = noteTitleTextField.getText();

            // check if currentNote is already in library
            int isThereCurrentNote = 0;
            for (String title : notesLibrary.getTitles()) {
                if (title.equals(currentTitle)) {
                    isThereCurrentNote = 1;
                    break;
                }
            }

            if (isThereCurrentNote == 0) {
                // add a new note to library (only if there is none note with same title)
                notesLibrary.addNewNote(noteTitleTextField.getText(), noteBodyTextArea.getText());

                // add a title to notesListView
                notesListView.getItems().add(noteTitleTextField.getText());

                notesListView.getSelectionModel().select(noteTitleTextField.getText());
            }
        }
    }

    /**
     * methods that is called when there is click to notesListView
     * loads title and body of selected note to right panel
     * invokes saving new note to json file
     */
    public void clickedToNotesListView() {

        // find out which note was selected
        String selectedNote = notesListView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {

            // if there is a title, we need to save the note
            if (!noteTitleTextField.getText().equals("")) {
                String currentTitle = noteTitleTextField.getText();

                // check if currentNote is already in library
                int isThereCurrentNote = 0;
                for (String title : notesLibrary.getTitles()) {
                    if (title.equals(currentTitle)) {
                        isThereCurrentNote = 1;
                        break;
                    }
                }

                if (isThereCurrentNote == 0) {
                    // add a new note (only if there is none with this title)
                    notesLibrary.addNewNote(currentTitle, noteBodyTextArea.getText());

                    // add a title to notesListView
                    notesListView.getItems().add(currentTitle);
                }
            }

            // now a selected note can be shown
            noteTitleTextField.setText(selectedNote);
            noteBodyTextArea.setText(notesLibrary.getBodyOfNote(selectedNote));
        }
    }

    /**
     * removes selected note from notesListView, notesLibrary and json file
     */
    public void removeNoteBtnClicked() {

        // find selected notes in notesListView
        String selectedNote = notesListView.getSelectionModel().getSelectedItem();

        // remove it from notesListView
        notesListView.getItems().removeAll(selectedNote);

        // remove note
        notesLibrary.removeNote(selectedNote);

        // set title field and body text area
        noteTitleTextField.setText("");
        noteBodyTextArea.setText("");
    }

    /**
     * clears both title text field and body text area of note
     */
    public void newNoteBtnClicked() {

        noteTitleTextField.setText("");
        noteBodyTextArea.setText("");
    }


}
