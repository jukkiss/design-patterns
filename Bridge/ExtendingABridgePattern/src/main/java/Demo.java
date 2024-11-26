public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
        testDevice(new SmartTV());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();

        if (device instanceof SmartTV) {
            System.out.println("Tests with smart remote.");
            SmartRemote smartRemote = new SmartRemote(device);
            smartRemote.power();
            smartRemote.voiceControl("browse internet");
            smartRemote.voiceControl("unknown command");
            device.printStatus();
        }
    }
}
