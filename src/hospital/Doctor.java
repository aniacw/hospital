package hospital;

public class Doctor extends Person {
    private int surgery;
    private String specialisation;

    public Doctor(String name, String lastName, int surgery, String specialisation){
        super(name, lastName);
        this.specialisation = specialisation;
        this.surgery = surgery;
    }
}
