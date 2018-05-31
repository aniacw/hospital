package hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient extends Person {
    private List<Disease> diseases;
    private boolean requiresSickLeave;
    private ArrayList<Appointment> appointments;

    public Patient(String name, String lastName) {
        super(name, lastName);
        this.diseases = new ArrayList<>();
        this.requiresSickLeave = false;
        appointments=new ArrayList<>();
    }

    public Patient(String name, String lastName, List<Disease> diseases, boolean requiresSickLeave) {
        super(name, lastName);
        this.diseases = diseases;
        this.requiresSickLeave = requiresSickLeave;
    }


    public void addAppointment(Appointment a){
        appointments.add(a);
    }

    public Patient() {
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void sendConfirmationEmail(Appointment a){
        System.out.println("Email to the patient sent");
    }

    public void write(PrintWriter writer) throws IOException{
        writer.print(getName());
        writer.print('\n');
        writer.print(getLastName());
        writer.print('\n');
        writer.print(diseases);
        writer.print('\n');
        writer.print(requiresSickLeave);
        writer.print('\n');
        writer.print(appointments);
        writer.print('\n');
    }

//    public void read(Scanner scanner){
//
//            disease = scanner.nextLine();
//
//        requiresSickLeave = scanner.nextLine();
//        appointments =
//        ;
//
//    }
}
