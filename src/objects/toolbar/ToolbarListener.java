package objects.toolbar;

import java.util.EventListener;

public interface ToolbarListener extends EventListener {
    public void toolbarEventOccured(ToolbarEvent e);
}
