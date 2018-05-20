package hospital;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
}
