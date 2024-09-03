public class AbstractFactoryMain {
    public static void main(String[] args) {
        UIFactory factory = new AFactory(); // Change to BFactory for different style

        Button button = factory.createButton("Click Me");
        TextField textField = factory.createTextField("Enter Name");
        Checkbox checkbox = factory.createCheckbox("Accept Terms");

        button.display();
        textField.display();
        checkbox.display();

        // Change text and display again
        button.setText("Submit");
        textField.setText("Enter Email");
        checkbox.setText("Subscribe to Newsletter");

        button.display();
        textField.display();
        checkbox.display();
    }
}
