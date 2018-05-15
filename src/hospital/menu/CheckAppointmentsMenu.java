package hospital.menu;

import hospital.Appointment;
import hospital.Patient;
import hospital.menu.exception.MenuInitializationException;

public class CheckAppointmentsMenu extends Menu {
    public CheckAppointmentsMenu() throws MenuInitializationException {
        super("Check appointments");
    }

    @Override
    public Menu process() {
        Patient patient;
        try {
            patient = (Patient) system.getLoggedUser().getPersonalData();
            if (patient == null){
                System.out.println("DataBase error: Personal data not set");
                return parent;
            }
        }
        catch (ClassCastException e){
            System.out.println("DataBase error: Current user is not a patient");
            return parent;
        }

        for (Appointment a : patient.getAppointments())
            System.out.println(a);

        return parent;
    }
}
