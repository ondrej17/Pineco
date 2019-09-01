package model;

import java.io.Serializable;

public class Note implements Serializable {


    private String title;
    private String body;

    public Note(String title, String body) {

        this.title = title;
        this.body = body;
    }

    // getters and setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
