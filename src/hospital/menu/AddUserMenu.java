package hospital.menu;

public class AddUserMenu extends Menu {

    public AddUserMenu(String name, Menu... submenus) {
        super(name, submenus);
    }

    @Override
    public Menu process() {
        return parent;
    }
}
