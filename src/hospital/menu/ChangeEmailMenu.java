package hospital.menu;

import hospital.User;
import hospital.menu.exception.MenuInitializationException;
import java.util.Scanner;

public class ChangeEmailMenu extends Menu {

    public ChangeEmailMenu() throws MenuInitializationException {
        super("change email");
    }

    @Override
    public Menu process() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type old email:");
        String oldEmail = scanner.next();
        User loggedUser = system.getLoggedUser();
        if (oldEmail.equals(loggedUser.getEmail())) {
            System.out.println("New email:");
            String newEmail = scanner.next();
            loggedUser.setEmail(newEmail);
        }
        return parent;
    }
}
