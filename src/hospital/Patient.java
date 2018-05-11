package hospital;

import java.util.List;

public class Patient extends Person {
    private List<Disease> diseases;
    private boolean requiresSickLeave;

    public Patient(String name, String lastName, List<Disease> diseases, boolean requiresSickLeave) {
        super(name, lastName);
        this.diseases = diseases;
        this.requiresSickLeave = requiresSickLeave;
    }


}
