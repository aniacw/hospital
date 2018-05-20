package hospital;

import hospital.menu.AddUserMenu;
import hospital.menu.Menu;
import hospital.menu.RemoveUserMenu;

import java.lang.System;

public class Admin extends User {
    private static final Menu ADMIN_MENU =
            new Menu("admin menu",
                    new AddUserMenu(),
                    new RemoveUserMenu()
            );

    private Menu menu;
    private Person personalData;

    public Admin(String login, String password) {
        super(login, password);
        this.menu = ADMIN_MENU;
        this.personalData = null;
    }

    @Override
    public void showInterface() {
        System.out.println("ADMIN");
    }
}

//editDoctorList
