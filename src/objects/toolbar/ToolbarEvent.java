package objects.toolbar;

import java.awt.*;
import java.util.EventObject;

public class ToolbarEvent extends EventObject {

    private boolean addListItemBtnClicked;

    public ToolbarEvent(Object source, boolean addListItemBtnClicked) {

        super(source);

        this.addListItemBtnClicked = addListItemBtnClicked;
    }


    public boolean isAddListItemBtnClicked() {
        return addListItemBtnClicked;
    }

    public void setAddListItemBtnClicked(boolean addListItemBtnClicked) {
        this.addListItemBtnClicked = addListItemBtnClicked;
    }
}
