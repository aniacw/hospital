package hospital;

import hospital.menu.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class HospitalSystem {
    private ArrayList<User> users;
    private User loggedUser;
    private Menu mainMenu;
    private DataBase dataBase;

//    private static final HospitalSystem instance = new HospitalSystem();
//
//    public static HospitalSystem getInstance() {
//        return HospitalSystem.instance;
//    }

    public HospitalSystem() {
        users = new ArrayList<>();
        loggedUser = null;
        dataBase = new DataBase();
        dataBase.setSystem(this);//?
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
        u.setSystem(this);//?
    }

    public void removeUser(User u){
        users.remove(u);

    }

    public void setMainMenu(Menu mainMenu) {
        this.mainMenu = mainMenu;
        mainMenu.setSystem(this);//?
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

//    public class Condition{
//        private String login;
//
//        public Condition(String login) {
//            this.login = login;
//        }
//
//        public boolean invoke(User u){
//            return u.getLogin().equals(login);
//        }
//    }

    public boolean removeUserByLogin(String login){
//        for (ListIterator<User> i = users.listIterator(); i.hasNext(); ){
//            User u = i.next();
//            if (u.getLogin().equals(login))
//                i.remove();
//        }
        return users.removeIf(u->u.getLogin().equals(login));
    }

    public void saveToFile(String filename){
        try {
            PrintWriter writer = new PrintWriter(filename);
            dataBase.write(writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename){
        try {
            Scanner scanner = new Scanner(new FileInputStream(filename));
            if (!scanner.hasNext())
                return;
            dataBase.read(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayUsers(){
        for (User u : users)
            System.out.println(u.getLogin());
    }
}
