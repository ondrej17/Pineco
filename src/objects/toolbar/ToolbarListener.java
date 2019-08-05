package objects.toolbar;

import java.util.EventListener;

public interface ToolbarListener extends EventListener {
    public void toolbarEventOcurred(ToolbarEvent e);
}
