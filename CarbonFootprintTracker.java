import java.util.*;

public class CarbonFootprintTracker {
    private double totalCarbonFootprint;
    private int rewardPoints;
    private List<String> achievements;

    public CarbonFootprintTracker() {
        this.totalCarbonFootprint = 0;
        this.rewardPoints = 0;
        this.achievements = new ArrayList<>();
    }

    // Add a product and update footprint and rewards
    public void addProduct(Product product) {
        double productFootprint = calculateProductFootprint(product);
        totalCarbonFootprint += productFootprint;
        updateRewards(productFootprint);
    }

    // Calculate the carbon footprint of a single product
    private double calculateProductFootprint(Product product) {
        // Simplified calculation - in reality, this would be more complex
        return product.getCarbonFootprint() * 10; // Assuming each point equals 10 kg CO2
    }

    // Update reward points based on product footprint
    private void updateRewards(double productFootprint) {
        if (productFootprint < 50) { // Low footprint product
            rewardPoints += 10;
            checkAchievements();
        }
    }

    // Check and update user achievements
    private void checkAchievements() {
        if (rewardPoints >= 100 && !achievements.contains("Carbon Saver")) {
            achievements.add("Carbon Saver");
        }
        if (rewardPoints >= 500 && !achievements.contains("Eco Warrior")) {
            achievements.add("Eco Warrior");
        }
        // Add more achievements as needed
    }

    // Get a summary of the user's carbon footprint and rewards
    public String getFootprintSummary() {
        return String.format("Total Carbon Footprint: %.2f kg CO2\n" +
                             "Reward Points: %d\n" +
                             "Achievements: %s",
                             totalCarbonFootprint, rewardPoints,
                             String.join(", ", achievements));
    }
}
