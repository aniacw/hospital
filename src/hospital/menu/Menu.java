package hospital.menu;

import hospital.HospitalSystem;
import hospital.SystemComponent;
import hospital.menu.exception.MenuInitializationException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends SystemComponent {
    protected Menu parent;
    private String name;
    private ArrayList<Menu> submenus;

    public Menu(String name, Menu... submenus) throws MenuInitializationException {
        this.name = name;
        this.parent = null;
        this.submenus = new ArrayList<>();
        for (Menu menu : submenus) //?
            addSubmenu(menu);
    }

    boolean validChoice(int choice){
        return choice <= submenus.size() && choice >= 0;
    }

    public void display() {
        System.out.println(name);
        int i = 1;
        for (Menu menu : submenus) {
            System.out.println("(" + i + ") " + menu.name);
            ++i;
        }
        System.out.println(parent == null ? "(0) EXIT" : "(0) BACK");
    }

    int getChoice(){
        Scanner inputScanner = new Scanner(System.in);
        int choice = inputScanner.nextInt();
        while (!validChoice(choice)){
            System.out.println("Invalid input");
            choice = inputScanner.nextInt();
        }
        return choice;
    }

    public Menu process() {
        display();
        int choice = getChoice();
        if (choice == 0)
            return parent;
        if (choice - 1 < submenus.size())
            return submenus.get(choice - 1);
        else
            return null;
    }

    public void addSubmenu(Menu menu) throws MenuInitializationException {//?
        if (menu == null)
            throw new MenuInitializationException("Menu cannot be null");
        if (submenus.contains(menu))
            throw new MenuInitializationException("Menu already added");

        submenus.add(menu);
        menu.parent = this;//?
    }

    @Override
    public void setSystem(HospitalSystem system) {
        this.system = system;
        for (Menu menu : submenus)
            menu.setSystem(system);//?
    }

    public final void run() {
        Menu current = this;
        while (current != null) {
            current = current.process();// w ogole nie rozumiem tej metody
        }
    }
}