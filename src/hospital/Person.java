package hospital;

public class Person {
    private String name;
    private String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
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
