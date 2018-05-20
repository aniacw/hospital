package hospital.menu;

import hospital.Admin;
import hospital.DataBase;
import hospital.HospitalSystem;
import hospital.User;

import java.util.Scanner;

public class AddUserMenu extends Menu {

    public AddUserMenu(String name, Menu... submenus) {
        super(name, submenus);
    }

    HospitalSystem hospitalSystem = new HospitalSystem();

    @Override
    public Menu process() {
        if (system.getLoggedUser().equals("admin")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please type your login");
            String login = scanner.next();
            System.out.println("Please type your password");
            String password = scanner.next();
            User newUser = new User(login, password);
            hospitalSystem.addUser(newUser);
        }
        return parent;
    }
}
