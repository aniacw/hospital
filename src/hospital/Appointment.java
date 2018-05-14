package hospital;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
//dlaczego tu nie jest readDate
    private Date date;
    private Doctor doctor;
    private Patient patient;

    public Appointment(Date date, Doctor doctor, Patient patient) {
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
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




}
