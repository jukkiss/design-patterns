
public class Main {

    public static void main(String[] args) {
        // Example 1: Bad practice - unused variable
        int unusedVariable = 5;

        // Example 2: Performance issue - redundant method call in loop
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }

        // Example 3: PMD - Simple rule violation (using an instance variable without initialization)
        User user = new User();
        System.out.println(user.getName());
    }

    // Example of a method with a bug (FindBugs will flag this)
    public static void divide(int a, int b) {
        System.out.println(a / b);
    }
}
