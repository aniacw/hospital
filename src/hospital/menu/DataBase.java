package hospital.menu;

import hospital.*;

import javax.print.Doc;
import java.text.DateFormat;
import java.util.*;

public class DataBase extends SystemComponent {

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

    @Override
    public void setSystem(HospitalSystem system) {
        super.setSystem(system);
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
}
//kontener z doktorami, kontener z pacjentami, kontener z chorobami, kontener z wizytami i metodami pozwalającymi na wyszukiwania:
// pacjentów i doktorów po nazwisku, chroby po nazwie, wizyt po dacie i doktorze oraz wizyt po dacie i pacjencie.
// Instancję tej klasy będziemy przechowywać w systemie, będzie stanowić główne miejsce składowania danych o szpitalu (ale nie o userach systemu)
//Do tego powinna mieć możliwość dodawania tych rekordów, usuwania i wyszukiwania.