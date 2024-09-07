import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    // single logger
    private static Logger instance;

    // writer
    private BufferedWriter writer;

    // filename
    private String fileName;

    // private constructor
    private Logger() {
        this.fileName = "defaultlog.txt";  // Default file name
        openFile();
    }

    // method to get singleton
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // method to set the file name
    public synchronized void setFileName(String fileName) {
        try {
            close();
        } catch (IOException e) {
            System.err.println("Error closing the current log file: " + e.getMessage());
        }
        this.fileName = fileName;
        openFile();
    }

    // method to write a log message to file and print to terminal
    public synchronized void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
            System.out.println("LOG: " + message);
        } catch (IOException e) {
            System.err.println("Error writing log message: " + e.getMessage());
        }
    }

    // method to close the log
    public synchronized void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }

    // method for opening the log
    private void openFile() {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));  // Append mode
        } catch (IOException e) {
            System.err.println("Virhe: " + e.getMessage());
        }
    }
}
