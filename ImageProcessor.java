import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ImageProcessor {
    private static final Map<String, Product> productDatabase = new HashMap<>();
    private static final Random random = new Random();

    static {
        // Simulate a database of products recognized from images
        productDatabase.put("apple", new Product("Apple", "Fruit", true, 2, 3, 1, "Soil, Water", "Farming", "Compost"));
        productDatabase.put("water_bottle", new Product("Water Bottle", "Beverage", true, 5, 7, 4, "Plastic", "Molding", "Recycle"));
        productDatabase.put("laptop", new Product("Laptop", "Electronics", false, 8, 6, 9, "Various Metals, Plastic", "Assembly", "E-waste Recycling"));
    }

    // Simulate image processing and product recognition
    public static Product processImage(String imagePath) {
        // In a real app, this would use computer vision to recognize the product
        // For this simulation, we'll randomly select a product from our database
        String[] products = productDatabase.keySet().toArray(new String[0]);
        String recognizedProduct = products[random.nextInt(products.length)];

        System.out.println("Recognized product from image: " + recognizedProduct);
        return productDatabase.get(recognizedProduct);
    }
}
