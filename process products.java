import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " (" + category + ") - ₹" + price;
    }
}

public class ProductStreamProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("iPhone", "Electronics", 90000),
            new Product("Samsung TV", "Electronics", 60000),
            new Product("Nike Shoes", "Footwear", 7000),
            new Product("Puma Shoes", "Footwear", 5000),
            new Product("HP Laptop", "Electronics", 75000),
            new Product("Adidas Flip-flops", "Footwear", 1500)
        );

        // Group by Category
        System.out.println("🔹 Products grouped by category:");
        Map<String, List<Product>> grouped = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        grouped.forEach((category, list) -> {
            System.out.println(category + ": " + list);
        });

        // Most expensive product in each category
        System.out.println("\n🔹 Most expensive product in each category:");
        Map<String, Optional<Product>> maxPriceInCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category,
                     Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));
        maxPriceInCategory.forEach((cat, prod) -> 
            System.out.println(cat + ": " + prod.orElse(null)));

        // Average price
        double avgPrice = products.stream()
            .mapToDouble(p -> p.price)
            .average()
            .orElse(0.0);
        System.out.println("\n🔹 Average price of all products: ₹" + avgPrice);
    }
}
