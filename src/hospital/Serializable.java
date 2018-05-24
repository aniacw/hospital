package hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public interface Serializable {
    void write(PrintWriter writer) throws IOException;
    void read(Scanner scanner) throws IOException;
}
