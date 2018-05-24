package hospital;

import com.sun.istack.internal.NotNull;
import hospital.menu.*;

public class User extends SystemComponent {
    private static final Menu DEFAULT_USER_MENU =
            new Menu("main",
                    new Menu("settings",
                            new ChangePasswordMenu(),
                            new ChangeEmailMenu()
                    ),
                    new BookAppointmentMenu(),
                    new CheckAppointmentsMenu(),
                    new SetPersonalDataMenu()
            );

    private static int lastID = 0;
    private int id;
    private String login;
    private String password;
    protected Menu menu;
    private Person personalData;
    private String email;

    public User(String login, String password) {
        this.id=lastID++;
        this.login = login;
        this.password = password;
        this.menu = DEFAULT_USER_MENU;
        this.personalData = null;
        this.email = null;
    }

    public User(String login, String password, Menu menu) {
        this.id=lastID++;
        this.login = login;
        this.password = password;
        this.menu = menu;
        this.personalData = null;
        this.email = null;
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

    public Person getPersonalData() {
        return personalData;
    }

    public void setPersonalData(@NotNull Person personalData){
        this.personalData = personalData;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean hasAdminRights(){
        return false;
    }
}