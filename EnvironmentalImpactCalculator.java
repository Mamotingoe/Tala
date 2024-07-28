public class EnvironmentalImpactCalculator {
  // Calculate the environmental impact of a product
  public static String calculateImpact(Product product) {
      StringBuilder impact = new StringBuilder();
      impact.append("Environmental Impact Report for ").append(product.getName()).append(":\n\n");
      impact.append("Carbon Footprint: ").append(getImpactLevel(product.getCarbonFootprint())).append("\n");
      impact.append("Water Usage: ").append(getImpactLevel(product.getWaterUsage())).append("\n");
      impact.append("Energy Consumption: ").append(getImpactLevel(product.getEnergyConsumption())).append("\n");
      impact.append("Recyclable: ").append(product.isRecyclable() ? "Yes" : "No").append("\n");
      impact.append("Raw Materials: ").append(product.getRawMaterials()).append("\n");
      impact.append("Manufacturing Process: ").append(product.getManufacturingProcess()).append("\n");
      impact.append("Disposal Method: ").append(product.getDisposalMethod()).append("\n");

      return impact.toString();
  }

  // Convert numeric impact to descriptive level
  private static String getImpactLevel(int value) {
      if (value <= 3) return "Low";
      if (value <= 7) return "Medium";
      return "High";
  }
}
