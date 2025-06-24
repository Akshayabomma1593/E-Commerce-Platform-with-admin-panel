import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("Laptop", 999.99));
        products.add(new Product("T-Shirt", 19.99));
        products.add(new Product("Coffee Mug", 9.99));
    }

    public static void addProduct(String name, double price) {
        products.add(new Product(name, price));
    }
}
