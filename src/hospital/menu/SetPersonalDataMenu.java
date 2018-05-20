package hospital.menu;

import hospital.Patient;
import java.util.Scanner;

public class SetPersonalDataMenu extends Menu{
    public SetPersonalDataMenu(){
        super("Set personal data");
    }

    @Override
    public Menu process() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        String name = scanner.next();
        System.out.println("Surname:");
        String surname = scanner.next();
        system.getLoggedUser().setPersonalData(new Patient(name, surname));
        return parent;
    }
}
