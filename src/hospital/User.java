package hospital;

import hospital.menu.ChangePasswordMenu;
import hospital.menu.Menu;

public class User extends SystemComponent {
    private static final Menu DEFAULT_USER_MENU =
            new Menu("main",
                    new Menu("settings",
                            new ChangePasswordMenu(),
                            new Menu("change email")
                    ),
                    new Menu("book visit")
            );

    private String login;
    private String password;
    private Menu menu;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.menu = DEFAULT_USER_MENU;
    }

    public User(String login, String password, Menu menu) {
        this.login = login;
        this.password = password;
        this.menu = menu;
    }

    public void showInterface() {
        menu.run();
    }

    public String getLogin() {
        return login;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String oldPassword, String newPassword) {
        if (authenticate(oldPassword))
            password = newPassword;
    }

    @Override
    public void setSystem(HospitalSystem system) {
        this.system = system;
        menu.setSystem(system);//?
    }
}
//deleteAccount
//bookAppointment
//cancelAppointment

