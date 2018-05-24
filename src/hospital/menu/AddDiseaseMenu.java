package hospital.menu;

import hospital.Disease;
import hospital.menu.exception.MenuInitializationException;

import java.util.Scanner;

public class AddDiseaseMenu extends Menu {
    public AddDiseaseMenu() throws MenuInitializationException {
        super("Add disease");
    }

    @Override
    public Menu process() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Disease name: ");
        String diseaseName = scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();
        system.getDataBase().addDisease(new Disease(diseaseName, description));
        return parent;
    }
}
