package Ex02_ECommerceSearch;

public class Main {

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Keyboard", "Electronics"),
                new Product(102, "Laptop", "Electronics"),
                new Product(103, "Mouse", "Electronics"),
                new Product(104, "Phone", "Mobiles"),
                new Product(105, "Tablet", "Electronics")

        };

        System.out.println("Linear Search");

        Product result1 = SearchOperations.linearSearch(products, 104);

        if (result1 != null)
            System.out.println(result1);
        else
            System.out.println("Product Not Found");

        System.out.println();

        System.out.println("Binary Search");

        Product result2 = SearchOperations.binarySearch(products, 104);

        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Product Not Found");
    }
}
