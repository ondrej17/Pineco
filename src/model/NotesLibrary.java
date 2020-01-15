package model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * instance of class NotesLibrary holds all notes that are used in application
 */
public class NotesLibrary {

    private String fileWithNotes;
    private List<Note> listOfNotes = new ArrayList<>();

    /**
     * constructor of class NotesLibrary
     */
    public NotesLibrary(String file) {

        // this is file with notes
        this.fileWithNotes = file;
    }

    /**
     * loads notes from JSON file that stores notes and adds them to our list of notes
     */
    public void loadNotes() {

        // Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();

        try {
            //Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(this.fileWithNotes));

            // get titles of all notes in file
            List<String> titlesOfNotes = new ArrayList<String>(jsonObject.keySet());

            // iterate through this list and create a new Note object with corresponding title and body
            for (String title : titlesOfNotes) {
                listOfNotes.add(new Note(title, (String) jsonObject.get(title)));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * methods returns list of titles of all notes that are in library
     */
    public List<String> getTitles() {

        List<String> titlesOfNotes = new ArrayList<String>();
        for (Note note : listOfNotes) {
            titlesOfNotes.add(note.getTitle());
        }
        return titlesOfNotes;
    }

    /**
     * returns body of note with given 'title'
     */
    public String getBodyOfNote(String title) {

        for (Note note : listOfNotes) {
            if (note.getTitle().equals(title)) {
                return note.getBody();
            }
        }
        // TODO: it should raise an exception when title is not in listOfNotes.getTitles()
        return "None";
    }

    /**
     * adds new note to library and to json file
     */
    public void addNewNote(String currentTitle, String body) {

        // save note to library
        listOfNotes.add(new Note(currentTitle, body));

        // save note to json file as well
        // Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();

        try {
            // Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(this.fileWithNotes));

            // add new item to json object
            jsonObject.put(currentTitle, body);

            // save jsonObject to json file
            try (FileWriter file = new FileWriter(this.fileWithNotes)) {
                file.write(jsonObject.toJSONString());
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * removes selected note from library
     */
    public void removeNote(String selectedNote) {

        // remove note from library
        for (Note note : listOfNotes) {
            if (note.getTitle().equals(selectedNote)) {
                listOfNotes.remove(note);
                break;
            }
        }

        // remove note from json file as well
        // Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();

        try {
            // Parsing the contents of the JSON file
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(this.fileWithNotes));

            // remove selected note from json object
            jsonObject.remove(selectedNote);

            // save jsonObject to json file
            try (FileWriter file = new FileWriter(this.fileWithNotes)) {
                file.write(jsonObject.toJSONString());
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
