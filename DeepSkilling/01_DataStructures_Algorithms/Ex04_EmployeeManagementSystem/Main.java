package Ex04_EmployeeManagementSystem;

public class Main {

    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager(10);

        manager.addEmployee(new Employee(101, "Rahul", "Developer", 60000));
        manager.addEmployee(new Employee(102, "Anjali", "Tester", 50000));
        manager.addEmployee(new Employee(103, "Kiran", "Manager", 90000));

        System.out.println("\nAll Employees:");

        manager.traverseEmployees();

        System.out.println("\nSearch Employee:");

        manager.searchEmployee(102);

        System.out.println("\nDelete Employee:");

        manager.deleteEmployee(102);

        System.out.println("\nEmployees After Deletion:");

        manager.traverseEmployees();
    }
}
