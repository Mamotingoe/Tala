import java.util.*;

public class SustainabilityRecommender {
    private List<Product> userProducts;

    public SustainabilityRecommender() {
        this.userProducts = new ArrayList<>();
    }

    // Add a product to the user's history
    public void addProduct(Product product) {
        userProducts.add(product);
    }

    // Generate sustainability recommendations based on user's product history
    public List<String> getRecommendations() {
        List<String> recommendations = new ArrayList<>();

        // Calculate average metrics
        double avgCarbonFootprint = calculateAverageMetric(p -> p.getCarbonFootprint());
        double avgWaterUsage = calculateAverageMetric(p -> p.getWaterUsage());
        double avgEnergyConsumption = calculateAverageMetric(p -> p.getEnergyConsumption());

        // Generate recommendations based on averages
        if (avgCarbonFootprint > 5) {
            recommendations.add("Try to choose products with lower carbon footprints.");
        }
        if (avgWaterUsage > 5) {
            recommendations.add("Look for products that use less water in their lifecycle.");
        }
        if (avgEnergyConsumption > 5) {
            recommendations.add("Consider more energy-efficient products.");
        }

        // Add more complex recommendation logic here

        return recommendations;
    }

    // Helper method to calculate average of a specific metric
    private double calculateAverageMetric(java.util.function.ToIntFunction<Product> metricExtractor) {
        return userProducts.stream()
                .mapToInt(metricExtractor)
                .average()
                .orElse(0);
    }
}
