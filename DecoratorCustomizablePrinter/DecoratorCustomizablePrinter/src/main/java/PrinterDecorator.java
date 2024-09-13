public abstract class PrinterDecorator implements Printer {
    protected Printer printerB;

    public PrinterDecorator(Printer printer) {
        this.printerB = printer;
    }

    @Override
    public void print(String message) {
        printerB.print(message);
    }
}
