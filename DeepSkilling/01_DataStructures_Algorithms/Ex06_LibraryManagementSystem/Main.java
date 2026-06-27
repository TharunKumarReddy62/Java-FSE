package Ex06_LibraryManagementSystem;

public class Main {

    public static void main(String[] args) {

        // Books sorted alphabetically by title
        Book[] books = {

                new Book(101, "C Programming", "Dennis Ritchie"),
                new Book(102, "Data Structures", "Mark Allen"),
                new Book(103, "Java Programming", "James Gosling"),
                new Book(104, "Python Basics", "Guido van Rossum"),
                new Book(105, "Web Development", "John Smith")

        };

        System.out.println("Linear Search:");

        Book result1 = SearchOperations.linearSearch(books, "Java Programming");

        if (result1 != null)
            System.out.println(result1);
        else
            System.out.println("Book Not Found");

        System.out.println();

        System.out.println("Binary Search:");

        Book result2 = SearchOperations.binarySearch(books, "Java Programming");

        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Book Not Found");
    }
}
