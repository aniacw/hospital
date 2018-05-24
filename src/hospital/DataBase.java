package hospital;

import hospital.*;

import javax.print.Doc;
import java.io.*;
import java.text.DateFormat;
import java.util.*;

public class DataBase extends SystemComponent implements Serializable {

    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Disease> diseases;
    private List<Appointment> appointments;

    public DataBase() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        diseases = new ArrayList<>();
        appointments = new ArrayList<>();
    }


    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDisease(Disease disease) {
        diseases.add(disease);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeDoctor(String name) {
        for (Doctor d : doctors)
            if (d.getFullName().equals(name))
                doctors.remove(d);
    }

    public void removePatient(String name) {
        for (Patient p : patients)
            if (p.getFullName().equals(name))
                patients.remove(p);
    }

    public void removeDisease(String name) {
        for (Disease d : diseases)
            if (d.getDiseaseName().equals(name))
                diseases.remove(d);
    }

    public void removeAppointment(Date date, String name) {
        for (Appointment a : appointments)
            if (a.getDate().equals(date) && a.getPatient().equals(name))
                appointments.remove(a);
    }

    public Doctor findDoctorByName(String name) {
        for (Doctor d : doctors)
            if (d.getFullName().equals(name))
                return d;
        return null;
    }

    public Patient findPatientByName(String name) {
        for (Patient p : patients)
            if (p.getFullName().equals(name))
                return p;
        return null;
    }

    public Doctor findDoctorBySpecialisation(String specialization) {
        for (Doctor d : doctors)
            if (d.getSpecialisation().equals(specialization))
                return d;
        return null;
    }

    public Disease findDisease(String name) {
        for (Disease d : diseases)
            if (d.getDiseaseName().equals(name))
                return d;
        return null;
    }

    public Appointment findAppointmentByDateDoctor(Date date, String name) {
        for (Appointment a : appointments)
            if (a.getDate().equals(date) && a.getDoctor().equals(name))
                return a;
        return null;
    }

    public Appointment findAppointmentByDatePatient(Date date, String name) {
        for (Appointment a : appointments)
            if (a.getDate().equals(date) && a.getPatient().equals(name))
                return a;
        return null;
    }

    @Override
    public void write(PrintWriter writer) throws IOException {
        writer.print(diseases.size());
        writer.print('\n');
        for (Disease d : diseases)
            d.write(writer);

        writer.print(doctors.size());
        writer.print('\n');
        for (Doctor doc : doctors)
            doc.write(writer);

        writer.print(patients.size());
        writer.print('\n');
        for (Patient p : patients)
            p.write(writer);

        writer.print(appointments.size());
        writer.print('\n');
        for (Appointment a : appointments)
            a.write(writer);
    }


    @Override
    public void read(Scanner scanner) {
        int size = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < size; ++i) {
            Disease d = new Disease();
            d.read(scanner);
            diseases.add(d);
        }
        for (int s = 0; s <size; s++) {
            Appointment a = new Appointment();
            a.read(scanner);
            appointments.add(a);
        }

        for (int e = 0; e < size; e++){
            Doctor d = new Doctor();
            d.read(scanner);
            doctors.add(d);
        }

        for (int o = 0; o < size; o++) {
            Patient p = new Patient();
            p.read(scanner);
            patients.add(p);
        }
    }


}
