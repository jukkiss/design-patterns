import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Recommendation> recommendations = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Create a new recommendation list");
            System.out.println("2. View existing recommendation lists");
            System.out.println("3. Clone and modify a recommendation list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the target audience: ");
                    String audience = scanner.nextLine();
                    Recommendation recommendation = new Recommendation(audience);

                    while (true) {
                        System.out.print("Add a book to this list? (yes/no): ");
                        String addBook = scanner.nextLine();
                        if (addBook.equalsIgnoreCase("no")) {
                            break;
                        }

                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter book genre (optional): ");
                        String genre = scanner.nextLine();
                        System.out.print("Enter publication year (optional, use 0 if unknown): ");
                        int year = Integer.parseInt(scanner.nextLine());

                        recommendation.addBook(new Book(title, author, genre, year));
                    }
                    recommendations.add(recommendation);
                    System.out.println("Recommendation list created!");
                    break;

                case "2":
                    if (recommendations.isEmpty()) {
                        System.out.println("No recommendation lists available.");
                    } else {
                        for (int i = 0; i < recommendations.size(); i++) {
                            System.out.println("\nList #" + (i + 1) + ":\n" + recommendations.get(i));
                        }
                    }
                    break;

                case "3":
                    if (recommendations.isEmpty()) {
                        System.out.println("No recommendation lists available to clone.");
                        break;
                    }

                    for (int i = 0; i < recommendations.size(); i++) {
                        System.out.println("\nList #" + (i + 1) + ":\n" + recommendations.get(i));
                    }
                    System.out.print("Enter the number of the list you want to clone: ");
                    int index = Integer.parseInt(scanner.nextLine()) - 1;

                    if (index < 0 || index >= recommendations.size()) {
                        System.out.println("Invalid list number.");
                        break;
                    }

                    Recommendation clonedList = recommendations.get(index).clone();
                    System.out.println("Cloned list:\n" + clonedList);

                    while (true) {
                        System.out.println("\nModify the cloned list:");
                        System.out.println("1. Add a book");
                        System.out.println("2. Remove a book");
                        System.out.println("3. Change target audience");
                        System.out.println("4. Save and exit modification");
                        System.out.print("Enter your choice: ");
                        String modChoice = scanner.nextLine();

                        switch (modChoice) {
                            case "1":
                                System.out.print("Enter book title: ");
                                String title = scanner.nextLine();
                                System.out.print("Enter book author: ");
                                String author = scanner.nextLine();
                                System.out.print("Enter book genre (optional): ");
                                String genre = scanner.nextLine();
                                System.out.print("Enter publication year (optional, use 0 if unknown): ");
                                int year = Integer.parseInt(scanner.nextLine());

                                clonedList.addBook(new Book(title, author, genre, year));
                                break;
                            case "2":
                                System.out.print("Enter the title of the book to remove: ");
                                String bookToRemove = scanner.nextLine();
                                clonedList.removeBook(bookToRemove);
                                break;
                            case "3":
                                System.out.print("Enter the new target audience: ");
                                String newAudience = scanner.nextLine();
                                clonedList.setTargetAudience(newAudience);
                                break;
                            case "4":
                                recommendations.add(clonedList);
                                System.out.println("Cloned list saved successfully!");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        if (modChoice.equals("4")) break;
                    }
                    break;

                case "4":
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
