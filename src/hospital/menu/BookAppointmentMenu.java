package hospital.menu;

import hospital.Appointment;
import hospital.Patient;
import hospital.Person;
import hospital.SystemComponent;
import hospital.menu.exception.MenuInitializationException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookAppointmentMenu extends Menu {

    public BookAppointmentMenu() throws MenuInitializationException {
        super("Book appointment");
    }

    private Date readDate(Scanner scanner){
        Date date = null;
        while (date == null){
            try {
                System.out.println("Please type the date");
                date = Appointment.dateFormat.parse(scanner.next());
            } catch (ParseException e) {
                date = null;
                System.out.println("Invalid date format");
            }
        }
        return date;
    }

    @Override
    public Menu process() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the specialisation");
        String selectedSpecialization = scanner.next();
        Date selectedDate = readDate(scanner);
        try {
            Patient patient = (Patient) system.getLoggedUser().getPersonalData();
            if (patient == null){
                System.out.println("DataBase error: Personal data not set");
                return parent;
            }
            Appointment appointment =
                    new Appointment(
                            selectedDate,
                            system.getDataBase().findDoctorBySpecialisation(selectedSpecialization),
                            patient);
            system.getDataBase().addAppointment(appointment);
            patient.addAppointment(appointment);
        }
        catch (ClassCastException e){
            System.out.println("DataBase error: Current user is not a patient");
        }
        return parent;
    }
}
