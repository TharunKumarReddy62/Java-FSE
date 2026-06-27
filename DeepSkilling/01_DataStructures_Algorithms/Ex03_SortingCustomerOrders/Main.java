package Ex03_SortingCustomerOrders;

public class Main {

    public static void main(String[] args) {

        Order[] orders = {

                new Order(101, "Rahul", 7500),
                new Order(102, "Anjali", 3200),
                new Order(103, "Kiran", 12000),
                new Order(104, "Sneha", 4500),
                new Order(105, "Vijay", 9000)

        };

        System.out.println("Original Orders:");

        SortOperations.display(orders);

        System.out.println("\nBubble Sort:");

        SortOperations.bubbleSort(orders);

        SortOperations.display(orders);

        Order[] orders2 = {

                new Order(101, "Rahul", 7500),
                new Order(102, "Anjali", 3200),
                new Order(103, "Kiran", 12000),
                new Order(104, "Sneha", 4500),
                new Order(105, "Vijay", 9000)

        };

        System.out.println("\nQuick Sort:");

        SortOperations.quickSort(orders2, 0, orders2.length - 1);

        SortOperations.display(orders2);
    }
}