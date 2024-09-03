public class Main {
    public static void main(String[] args) {
        OrganizationComponent emp1 = new Employee("Matti Mansikka", 75000);
        OrganizationComponent emp2 = new Employee("Milla Mustikka", 90000);
        OrganizationComponent dept1 = new Department("HR");
        dept1.add(emp1);
        dept1.add(emp2);

        OrganizationComponent emp3 = new Employee("James Bond", 150000);
        OrganizationComponent dept2 = new Department("Finance");
        dept2.add(emp3);
        dept2.add(dept1);

        dept2.displayDetails();
        System.out.println("Total Salary: " + dept2.getSalary());
    }
}
