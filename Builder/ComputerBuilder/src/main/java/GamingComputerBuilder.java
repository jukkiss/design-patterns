// GamingComputerBuilder.java
public class GamingComputerBuilder implements ComputerBuilder {
    private Computer.Builder builder;

    public GamingComputerBuilder() {
        builder = new Computer.Builder();
    }

    @Override
    public void buildProcessor() {
        builder.buildProcessor("AMD Ryzen 9");
    }

    @Override
    public void buildRAM() {
        builder.buildRAM(32);
    }

    @Override
    public void buildHardDrive() {
        builder.buildHardDrive("1 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        builder.buildGraphicsCard("NVIDIA RTX 3080");
    }

    @Override
    public void buildOperatingSystem() {
        builder.buildOperatingSystem("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return builder.build();
    }
}

