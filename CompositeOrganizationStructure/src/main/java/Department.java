import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {
    private String name;
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public void displayDetails() {
        System.out.println("<Department name=\"" + name + "\">");
        for (OrganizationComponent component : components) {
            component.displayDetails();
        }
        System.out.println("</Department>");
    }

    @Override
    public double getSalary() {
        return components.stream().mapToDouble(OrganizationComponent::getSalary).sum();
    }
}
