public class SmartRemote extends BasicRemote {
    public SmartRemote(Device device) {
        super(device);
    }

    public void voiceControl(String command) {
        System.out.println("SmartRemote: Voice Control - Executing command: " + command);
        if (command.equalsIgnoreCase("browse internet")) {
            if (device instanceof SmartTV) {
                ((SmartTV) device).browseInternet();
            } else {
                System.out.println("SmartRemote: Device does not support this feature.");
            }
        } else {
            System.out.println("SmartRemote: Unknown command.");
        }
    }
}
