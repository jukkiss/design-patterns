public class LetsPrint {
    public static void main(String[] args) {
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print("Hello World!");

        Printer fileAndEncryptedPrinter = new EncryptedPrinter(new FilePrinter(new BasicPrinter()));
        fileAndEncryptedPrinter.print("Hello World!");

    }
}