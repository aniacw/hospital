package hospital;

import java.lang.System;

public class Admin extends User {
    public Admin(String login, String password) {
        super(login, password);
    }

    @Override
    public void showInterface() {
        System.out.println("ADMIN");
    }
}
//deleteUserAccount
//editDoctorList
//