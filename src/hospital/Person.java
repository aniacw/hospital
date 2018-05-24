package hospital;

public class Person {
    private static int lastID = 0;
    private int id;
    private String name;
    private String lastName;

    public Person(String name, String lastName) {
        this.id = lastID++;
        this.name = name;
        this.lastName = lastName;
    }

    public Person() {
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getFullName(){
        return name + " " + lastName;
    }

    public final Patient asPatient(){
        try{
            return (Patient)this;
        }
        catch (ClassCastException e){
            return null;
        }
    }
}
