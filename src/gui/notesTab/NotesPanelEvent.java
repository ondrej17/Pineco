package gui.notesTab;

import java.util.EventObject;

public class NotesPanelEvent extends EventObject {

    // variables that stores info anout which button was clicked
    private boolean addClicked;
    private boolean delClicked;

    // constructor of EVENT
    public NotesPanelEvent(Object source, boolean addClicked, boolean delClicked) {

        super(source);

        this.addClicked = addClicked;
        this.delClicked = delClicked;
    }

    // getters and setters for each button
    public boolean isAddClicked() {
        return addClicked;
    }

    public void setAddClicked(boolean addClicked) {
        this.addClicked = addClicked;
    }

    public boolean isDelClicked() {
        return delClicked;
    }

    public void setDelClicked(boolean delClicked) {
        this.delClicked = delClicked;
    }
}
