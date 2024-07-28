import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private List<Product> products;

    public ProductDatabase() {
        this.products = new ArrayList<>();
    }

    // Add a product to the database
    public void addProduct(Product product) {
        products.add(product);
    }

    // Get all products in the database
    public List<Product> getAllProducts() {
        return new ArrayList<>(products); // Return a copy to preserve encapsulation
    }

    // Get the most recently added product
    public Product getLastProduct() {
        if (products.isEmpty()) {
            return null;
        }
        return products.get(products.size() - 1);
    }
}
