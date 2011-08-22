package org.vaadin.jouni.dashlayout.tests.jflamy;

import com.vaadin.Application;
import com.vaadin.ui.Window;

public class DashApplication extends Application {
    private static final long serialVersionUID = 1L;
    private LoadWindow loadComputerWindow;

    @Override
    public void init() {
        Window mainWindow = new Window("Dash Application");
        setTheme("competition");

        loadComputerWindow = new LoadWindow();
        mainWindow.addWindow(loadComputerWindow);
        setMainWindow(mainWindow);
    }

}
