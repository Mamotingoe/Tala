public class Product {
  private String name;
  private String category;
  private boolean isRecyclable;
  private int carbonFootprint; // 1-10 scale
  private int waterUsage; //1-10 scale
  private int energyConsumption; //1-10 scale
  private String rawMaterials;
  private String manufacturingProcess;
  private String disposalMethod;

  //Constructor
  public Product(String name, String category, boolean isRecyclable, int carbonFootprint, int waterUsage, int energyConsumption, String rawMaterials, String manufaturingProcess, String disposalMethod) {

    this.name = name;
    this.category = category;
    this.isRecyclable = isRecyclable;
    this.carbonFootprint = carbonFootprint;
    this.waterUsage = waterUsage;
    this.energyConsumption = energyConsumption;
    this.rawMaterials = rawMaterials;
    this.manufacturingProcess = manufacturingProcess;
    this.disposalMethod = disposalMethod;
  }

   // Getter methods
   public String getName() { return name; }
   public String getCategory() { return category; }
   public boolean isRecyclable() { return isRecyclable; }
   public int getCarbonFootprint() { return carbonFootprint; }
   public int getWaterUsage() { return waterUsage; }
   public int getEnergyConsumption() { return energyConsumption; }
   public String getRawMaterials() { return rawMaterials; }
   public String getManufacturingProcess() { return manufacturingProcess; }
   public String getDisposalMethod() { return disposalMethod; }
}
