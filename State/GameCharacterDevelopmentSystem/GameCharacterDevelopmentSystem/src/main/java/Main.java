import java.util.Scanner;

public class Main {
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        Character character = new Character("Hero");

        while (true) {
            character.displayStatus();

            System.out.println("Choose: 1: Train 2: Meditate 3: Fight: 0: Exit ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    character.train();
                    break;
                case 2:
                    character.meditate();
                    break;
                case 3:
                    character.fight();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Try again");
            }

            if (choice == 0) {
                break;
            }
        }
    }
}
