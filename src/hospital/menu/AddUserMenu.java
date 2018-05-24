package hospital.menu;

import hospital.User;
import hospital.menu.exception.MenuInitializationException;

import java.util.Scanner;

public class AddUserMenu extends Menu {

    public AddUserMenu() throws MenuInitializationException {
        super("Add user");
    }

    @Override
    public Menu process() {
        if (system.getLoggedUser().hasAdminRights()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please type your login");
            String login = scanner.next();
            System.out.println("Please type your password");
            String password = scanner.next();
            User newUser = new User(login, password);
            system.addUser(newUser);
        } else {
            System.out.println("You are not authorized to perform this action");
        }
        return parent;
    }
}
