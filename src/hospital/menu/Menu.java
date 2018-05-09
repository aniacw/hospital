package hospital.menu;

import hospital.HospitalSystem;
import hospital.SystemComponent;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends SystemComponent {
    protected Menu parent;
    private String name;
    private ArrayList<Menu> submenus;

    public Menu(String name, Menu... submenus) {
        this.name = name;
        this.parent = null;
        this.submenus = new ArrayList<>();
        for (Menu menu : submenus)
            addSubmenu(menu);
    }

    public void display() {
        System.out.println(name);
        int i = 1;
        for (Menu menu : submenus) {
            System.out.println("(" + i + ") " + menu.name);
            ++i;
        }
        System.out.println("(0) BACK");
    }

    public Menu process() {
        Scanner inputScanner = new Scanner(System.in);
        int choice = inputScanner.nextInt();
        if (choice == 0)
            return parent;
        if (choice - 1 < submenus.size())
            return submenus.get(choice - 1);
        else
            return null;
    }

    public void addSubmenu(Menu menu) throws IllegalArgumentException {
        if (menu == null)
            throw new IllegalArgumentException("Menu cannot be null");
        if (submenus.contains(menu))
            throw new IllegalArgumentException("Menu already added");

        submenus.add(menu);
        menu.parent = this;
    }

    @Override
    public void setSystem(HospitalSystem system) {
        this.system = system;
        for (Menu menu : submenus)
            menu.setSystem(system);
    }

    public void run() {
        Menu current = this;
        while (current != null) {
            current.display();
            current = current.process();
        }
    }
}
