
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // get logger instance
        Logger logger = Logger.getInstance();

        // log file
        logger.setFileName("logit.txt");

        // messages
        logger.write("Äpp starts");
        logger.write("coding 600 million dollar startup");
        logger.write("stop");

        // close
        try {
            logger.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
