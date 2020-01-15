package model;

/**
 * class Note represents one particular note
 * it should have attributes like title, body, timestamp (maybe more) getters and setters
 */
public class Note {

    private String title;
    private String body;

    /**
     * constructor of class Note
     */
    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }

    /**
     * returns title
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets title of note
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * returns body of note
     */
    public String getBody() {
        return body;
    }

    /**
     * sets body of note
     */
    public void setBody(String body) {
        this.body = body;
    }
}
