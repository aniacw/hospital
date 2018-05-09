package hospital.menu;

import hospital.User;

import java.util.Scanner;

public class LoginMenu extends Menu {
    public LoginMenu() {
        super("Login");
    }

    @Override
    public Menu process() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String login = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();
        User u = system.logIn(login, password);
        if (u == null)
            System.out.println("Invalid login or password");
        else
            u.showInterface();
        return parent;
    }
}
