package hospital;

import hospital.menu.LoginMenu;
import hospital.menu.Menu;

public class Program {
    public static void main(String[] args) {
        try {
            HospitalSystem system = new HospitalSystem();
            system.loadFromFile("db.txt");

            Menu mainMenu =
                    new Menu("Hospital System",
                            new LoginMenu());

            system.setMainMenu(mainMenu);//?

            system.addUser(new User("name", "***"));
            system.addUser(new User("login", "pass"));
            system.addUser(new Admin("admin", "admin"));

            DataBase db = system.getDataBase();
            db.addDoctor(new Doctor("Albert", "Kowalsky", 80, "chirurg"));
            db.addDoctor(new Doctor("Katarzyna", "Zielinska", 86, "chirurg"));
            db.addDoctor(new Doctor("Marian","Bauer", 999, "kardiolog"));

//            db.addDisease(new Disease("przeziebienie", "katar kaszel"));
//            db.addDisease(new Disease("ospa", "wysypka"));
//            db.addDisease(new Disease("zatrucie", "bigunka, gorczka"));

            system.run();


            system.saveToFile("db.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
