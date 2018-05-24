package hospital.menu;

import hospital.User;
import hospital.menu.exception.MenuInitializationException;

public class DisplayUsersMenu extends Menu {
    public DisplayUsersMenu() throws MenuInitializationException {
        super("Display users");
    }

    @Override
    public Menu process() {
        system.displayUsers();
        return parent;
    }
}
