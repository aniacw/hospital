package hospital;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Disease implements Serializable {
    private static int lastID = 0;
    private int id;
    private String diseaseName;
    private String description;

    public Disease(String diseaseName, String description) {
        this.id = lastID++;
        this.diseaseName = diseaseName;
        this.description = description;
    }

    public Disease() {
        this.id = lastID++;
    }

    public String getDiseaseName() {
        return diseaseName;
    }


//    @Override
//    public void write(PrintWriter writer) throws IOException {
//        writer.print(id);
//        writer.print('\n');
//        writer.print(diseaseName);
//        writer.print('\n');
//        writer.print(description);
//        writer.print('\n');
//    }
//
//    @Override
//    public void read(Scanner scanner) {
//        id = scanner.nextInt();
//        scanner.nextLine();
//        diseaseName = scanner.nextLine();
//        description = scanner.nextLine();
//    }
}
