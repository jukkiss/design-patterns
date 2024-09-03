public class Employee implements OrganizationComponent {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to an employee.");
    }

    @Override
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from an employee.");
    }

    @Override
    public void displayDetails() {
        System.out.println("<Employee name=\"" + name + "\" salary=\"" + salary + "\" />");
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
