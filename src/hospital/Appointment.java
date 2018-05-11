package hospital;

import java.util.Date;

public class Appointment {

    private String date;
    private Doctor doctor;
    private Patient patient;

    public Appointment(String date, Doctor doctor, Patient patient) {
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }
}
