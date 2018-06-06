package hospital;

import hospital.menu.Menu;

import java.io.*;
import java.util.ArrayList;

public class HospitalSystem {
    private static final String DATABASE_FILENAME = "db.bin";

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

    public boolean removeUserByLogin(String login){
//        for (ListIterator<User> i = users.listIterator(); i.hasNext(); ){
//            User u = i.next();
//            if (u.getLogin().equals(login))
//                i.remove();
//        }
        return users.removeIf(u->u.getLogin().equals(login));
    }

    public void saveToFile(){
        try {
            FileOutputStream out = new FileOutputStream(DATABASE_FILENAME);
            dataBase.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        try {
            FileInputStream in = new FileInputStream(DATABASE_FILENAME);
            dataBase.read(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayUsers(){
        for (User u : users)
            System.out.println(u.getLogin());
    }
}
