public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer.Builder builder;

    public OfficeComputerBuilder() {
        builder = new Computer.Builder();
    }

    @Override
    public void buildProcessor() {
        builder.buildProcessor("Intel i5");
    }

    @Override
    public void buildRAM() {
        builder.buildRAM(16);
    }

    @Override
    public void buildHardDrive() {
        builder.buildHardDrive("512 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        builder.buildGraphicsCard("Integrated Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        builder.buildOperatingSystem("Windows 10");
    }

    @Override
    public Computer getComputer() {
        return builder.build();
    }
}