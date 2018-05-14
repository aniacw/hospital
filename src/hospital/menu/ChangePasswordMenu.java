package hospital.menu;

import hospital.User;

import java.util.Scanner;

public class ChangePasswordMenu extends Menu {
    public ChangePasswordMenu() {
        super("Change Password");
    }

    @Override
    public Menu process(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Old password: ");
        String oldPassword = scanner.next();
        User loggedUser = system.getLoggedUser();//? system
        if (loggedUser.authenticate(oldPassword)){
            System.out.println("New password: ");
            String newPassword = scanner.next();
            loggedUser.setPassword(oldPassword, newPassword);
            System.out.println("OK");
        }
        else
            System.out.println("Invalid password");
        return parent;
    }
}
