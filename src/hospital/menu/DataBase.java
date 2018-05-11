package hospital.menu;

import hospital.Doctor;
import hospital.HospitalSystem;
import hospital.Patient;
import hospital.SystemComponent;
import java.util.ArrayList;
import java.util.List;

public class DataBase extends SystemComponent {

    @Override
    public void setSystem(HospitalSystem system) {
        super.setSystem(system);
    }

    private List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(Doctor doctor1 = new Doctor("Thomas", "Smith", 5, "dentist"));

    private List<Patient> patientsList = new ArrayList<>();
    patientsList.add(Patient patient1 = new Patient("Rachel", "Green", "leg injury", true));




}
