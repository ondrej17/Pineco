package objects.toolbar;

import java.awt.*;
import java.util.EventObject;

public class ToolbarEvent extends EventObject {

    private boolean addListItemBtnClicked;
    private boolean delListItemBtnClicked;

    public ToolbarEvent(Object source, boolean addListItemBtnClicked, boolean delListItemBtnClicked) {

        super(source);

        this.addListItemBtnClicked = addListItemBtnClicked;
        this.delListItemBtnClicked = delListItemBtnClicked;
    }


    public boolean isAddListItemBtnClicked() {
        return addListItemBtnClicked;
    }

    public void setAddListItemBtnClicked(boolean addListItemBtnClicked) {
        this.addListItemBtnClicked = addListItemBtnClicked;
    }

    public boolean isDelListItemBtnClicked() {
        return delListItemBtnClicked;
    }

    public void setDelListItemBtnClicked(boolean delListItemBtnClicked) {
        this.delListItemBtnClicked = delListItemBtnClicked;
    }
}
