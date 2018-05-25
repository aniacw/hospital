package hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Appointment {
//dlaczego tu nie jest readDate
    public static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //dlaczego private static, dlaczego w tej klasie?
    private static int lastID = 0;
    private int id;
    private Date date;
    private Doctor doctor;
    private Patient patient;

    public Appointment(Date date, Doctor doctor, Patient patient) {
        this.id = lastID++;
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Appointment(){
        this.id = lastID++;
    }

    public Date getDate() {
        return date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    //    public void convertDate(String dateString) throws Exception {
//        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
//        Date date = dateFormat.parse(dateString);
//    }
    @Override
    public String toString(){
        return "Patient: " + patient.getFullName() +
                "\nDoctor: " + doctor.getFullName() +
                "\nSurgery: " + doctor.getSurgery() +
                "\nDate: " + dateFormat.format(date);
    }

    public void write(PrintWriter writer) throws IOException {
        writer.print(id);
        writer.print('\n');
        writer.print(date);
        writer.print('\n');
        writer.print(doctor);
        writer.print('\n');
        writer.print(patient);
        writer.print('\n');
    }

    public void read(Scanner scanner) {
        id = scanner.nextInt();
        scanner.nextLine();
        date = scanner.nextLine();
        doctor =  scanner.nextLine();
        patient = scanner.nextLine();
    }
}
