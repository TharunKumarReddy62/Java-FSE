package Ex04_EmployeeManagementSystem;

public class EmployeeManager {

    private Employee[] employees;
    private int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add Employee
    public void addEmployee(Employee employee) {

        if (count < employees.length) {
            employees[count++] = employee;
            System.out.println("Employee Added Successfully.");
        } else {
            System.out.println("Employee Array is Full.");
        }
    }

    // Search Employee
    public void searchEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == id) {
                System.out.println(employees[i]);
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    // Traverse Employees
    public void traverseEmployees() {

        if (count == 0) {
            System.out.println("No Employees Available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == id) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[count - 1] = null;
                count--;

                System.out.println("Employee Deleted Successfully.");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }
}