package hospital;

import hospital.menu.Menu;

import java.util.ArrayList;

public class HospitalSystem {
    private ArrayList<User> users;
    private User loggedUser;
    private Menu mainMenu;

    public HospitalSystem() {
        users = new ArrayList<>();
        loggedUser = null;
    }

    public User logIn(String login, String password) {
        for (User u : users) {
            if (u.getLogin().equals(login) && u.authenticate(password)) {
                loggedUser = u;
                return u;
            }
        }
        return null;
    }

    public void run() {
        mainMenu.run();
    }

    public void addUser(User u) {
        users.add(u);
        u.setSystem(this);
    }

    public void setMainMenu(Menu mainMenu) {
        this.mainMenu = mainMenu;
        mainMenu.setSystem(this);
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
