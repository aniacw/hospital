package hospital.menu;

import hospital.HospitalSystem;
import hospital.menu.exception.MenuInitializationException;

import java.util.Scanner;

public class RemoveUserMenu extends Menu {
    public RemoveUserMenu() throws MenuInitializationException {
        super("Remove user");
    }

    @Override
    public Menu process() {
        if (system.getLoggedUser().hasAdminRights()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please type the login");
            String loginToRemove = scanner.next();
            if (system.removeUserByLogin(loginToRemove))
                System.out.println("User successfully removed");
            else
                System.out.println("User with given login does not exist");
        } else {
            System.out.println("You are not authorized to perform this action");
        }
        return parent;
    }
}
