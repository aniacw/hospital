package hospital.menu;

import hospital.HospitalSystem;
import hospital.User;
import hospital.menu.exception.MenuInitializationException;
import java.util.Scanner;

public class RemoveUserMenu extends Menu {
    public RemoveUserMenu() throws MenuInitializationException {
        super("Remove user");
    }

    HospitalSystem hospitalSystem = new HospitalSystem();

    @Override
    public Menu process() {
        if (system.getLoggedUser().equals("admin")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please type the name");
            String nameToRemove = scanner.next();
            System.out.println("Please type the last name");
            String lastNameToRemove = scanner.next();
            hospitalSystem.removeUser(system.getDataBase().findUserByFullName(nameToRemove, lastNameToRemove));
        }
            return parent;
    }
}
