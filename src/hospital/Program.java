package hospital;

import hospital.menu.LoginMenu;
import hospital.menu.Menu;

public class Program {
    public static void main(String[] args) {
        try {
            HospitalSystem system = new HospitalSystem();

            Menu mainMenu =
                    new Menu("Hospital System",
                            new LoginMenu());

            system.setMainMenu(mainMenu);//?

            system.addUser(new User("name", "***"));
            system.addUser(new Admin("admin", "admin"));
            system.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
