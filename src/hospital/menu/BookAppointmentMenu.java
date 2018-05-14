package hospital.menu;

import hospital.Appointment;
import hospital.Patient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookAppointmentMenu extends Menu {

    public BookAppointmentMenu(){
        super("Book appointment");
    }

    private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //dlaczego private static, dlaczego w tej klasie?

    private Date readDate(Scanner scanner){
        Date date = null;
        while (date == null){
            try {
                System.out.println("Please type the date");
                date = dateFormat.parse(scanner.next());
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
        Appointment appointment = new Appointment(selectedDate, system.getDataBase().findDoctorBySpecialisation(selectedSpecialization),
                (Patient)system.getLoggedUser().getPersonalData()); // co to jest
        system.getDataBase().addAppointment(appointment);
        return parent; //dlaczego
    }
}
