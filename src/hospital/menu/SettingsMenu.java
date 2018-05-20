package hospital.menu;

import hospital.menu.exception.MenuInitializationException;

public class SettingsMenu extends Menu {
    public SettingsMenu() throws MenuInitializationException {
        super("settings");
    }

    @Override
    public Menu process() {
        return parent;
    }
}
