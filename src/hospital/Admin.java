package hospital;

import hospital.menu.*;

import java.lang.System;
import java.util.function.Consumer;

public class Admin extends User {
    private static final Menu ADMIN_MENU =
            new Menu("admin menu",
                    new AddUserMenu(),
                    new AddDiseaseMenu(),
                    new RemoveUserMenu(),
                    new DisplayUsersMenu(),
                    new CustomMenu("Display users", s->s.displayUsers())
            );

    public Admin(String login, String password) {
        super(login, password);
        this.menu = ADMIN_MENU;
    }

    @Override
    public boolean hasAdminRights() {
        return true;
    }
}

//editDoctorList
