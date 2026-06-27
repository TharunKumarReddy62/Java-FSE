package Ex05_TaskManagementSystem;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        manager.addTask(101, "Design UI", "Pending");
        manager.addTask(102, "Develop Backend", "In Progress");
        manager.addTask(103, "Write Test Cases", "Pending");

        System.out.println("\nAll Tasks:");

        manager.traverseTasks();

        System.out.println("\nSearch Task:");

        manager.searchTask(102);

        System.out.println("\nDelete Task:");

        manager.deleteTask(102);

        System.out.println("\nTasks After Deletion:");

        manager.traverseTasks();
    }
}
