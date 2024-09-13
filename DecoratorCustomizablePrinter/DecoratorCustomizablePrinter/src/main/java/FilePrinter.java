import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter extends PrinterDecorator {
    private static final String filename = "thefile.txt";

    public FilePrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print(message);
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
