package Ex05_TaskManagementSystem;

public class TaskManager {

    private Task head;

    // Add Task
    public void addTask(int taskId, String taskName, String status) {

        Task newTask = new Task(taskId, taskName, status);

        if (head == null) {
            head = newTask;
        } else {

            Task current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newTask;
        }

        System.out.println("Task Added Successfully.");
    }

    // Search Task
    public void searchTask(int taskId) {

        Task current = head;

        while (current != null) {

            if (current.taskId == taskId) {
                System.out.println(current);
                return;
            }

            current = current.next;
        }

        System.out.println("Task Not Found.");
    }

    // Traverse Tasks
    public void traverseTasks() {

        if (head == null) {
            System.out.println("No Tasks Available.");
            return;
        }

        Task current = head;

        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // Delete Task
    public void deleteTask(int taskId) {

        if (head == null) {
            System.out.println("Task List is Empty.");
            return;
        }

        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task Deleted Successfully.");
            return;
        }

        Task current = head;

        while (current.next != null && current.next.taskId != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task Not Found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task Deleted Successfully.");
        }
    }
}
