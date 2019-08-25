package notesTab;

import java.util.EventListener;

public interface NotesPanelListener extends EventListener {
    void notesPanelEventOcurred(NotesPanelEvent e);
}
