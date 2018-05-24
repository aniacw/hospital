package hospital;

import javax.print.Doc;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Doctor extends Person {
    private int surgery;
    private String specialisation;

    public Doctor(String name, String lastName, int surgery, String specialisation){
        super(name, lastName);
        this.specialisation = specialisation;
        this.surgery = surgery;
    }

    public Doctor(){
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public int getSurgery() {
        return surgery;
    }


    public void write(PrintWriter writer) throws IOException{
        writer.print(getName());
        writer.print('\n');
        writer.print(getLastName());
        writer.print('\n');
        writer.print(specialisation);
        writer.print('\n');
        writer.print(surgery);
        writer.print('\n');
    }

    public void read(Scanner scanner){

        surgery = scanner.nextInt();
        scanner.nextLine();
        specialisation = scanner.nextLine();
    }
}
