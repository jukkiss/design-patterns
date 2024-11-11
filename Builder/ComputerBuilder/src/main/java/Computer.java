
public class Computer {
    private String processor;
    private int ramSize;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    private Computer() {}

    public String getProcessor() { return processor; }
    public int getRamSize() { return ramSize; }
    public String getHardDrive() { return hardDrive; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getOperatingSystem() { return operatingSystem; }

    public static class Builder {
        private Computer computer;

        public Builder() {
            computer = new Computer();
        }

        public Builder buildProcessor(String processor) {
            computer.processor = processor;
            return this;
        }

        public Builder buildRAM(int ramSize) {
            computer.ramSize = ramSize;
            return this;
        }

        public Builder buildHardDrive(String hardDrive) {
            computer.hardDrive = hardDrive;
            return this;
        }

        public Builder buildGraphicsCard(String graphicsCard) {
            computer.graphicsCard = graphicsCard;
            return this;
        }

        public Builder buildOperatingSystem(String operatingSystem) {
            computer.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build() {
            return computer;
        }
    }

    @Override
    public String toString() {
        return "Computer [processor=" + processor + ", RAM=" + ramSize + "GB, hardDrive=" + hardDrive
                + ", graphicsCard=" + graphicsCard + ", OS=" + operatingSystem + "]";
    }
}
