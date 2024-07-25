import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TalaGUI extends JFrame {
    private ProductDatabase database = new ProductDatabase();
    private SustainabilityRecommender recommender = new SustainabilityRecommender();
    private CarbonFootprintTracker footprintTracker = new CarbonFootprintTracker();
    private JTextField nameField, categoryField, rawMaterialsField, manufacturingField, disposalField;
    private JCheckBox recyclableBox;
    private JSlider carbonSlider, waterSlider, energySlider;

    public TalaGUI() {
        setTitle("Tala");
        setSize(500, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(14, 2));

        nameField = new JTextField();
        categoryField = new JTextField();
        recyclableBox = new JCheckBox();
        carbonSlider = new JSlider(1, 10);
        waterSlider = new JSlider(1, 10);
        energySlider = new JSlider(1, 10);
        rawMaterialsField = new JTextField();
        manufacturingField = new JTextField();
        disposalField = new JTextField();
        JButton addButton = new JButton("Add Product");
        JButton showImpactButton = new JButton("Show Environmental Impact");
        JButton imageProcessButton = new JButton("Input from Image");
        JButton getRecommendationsButton = new JButton("Get AI Recommendations");
        JButton showFootprintButton = new JButton("Show Carbon Footprint");

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Recyclable:"));
        panel.add(recyclableBox);
        panel.add(new JLabel("Carbon Footprint (1-10):"));
        panel.add(carbonSlider);
        panel.add(new JLabel("Water Usage (1-10):"));
        panel.add(waterSlider);
        panel.add(new JLabel("Energy Consumption (1-10):"));
        panel.add(energySlider);
        panel.add(new JLabel("Raw Materials:"));
        panel.add(rawMaterialsField);
        panel.add(new JLabel("Manufacturing Process:"));
        panel.add(manufacturingField);
        panel.add(new JLabel("Disposal Method:"));
        panel.add(disposalField);
        panel.add(addButton);
        panel.add(showImpactButton);
        panel.add(imageProcessButton);
        panel.add(getRecommendationsButton);
        panel.add(showFootprintButton);

        addButton.addActionListener(e -> addProduct());
        showImpactButton.addActionListener(e -> showImpact());
        imageProcessButton.addActionListener(e -> processImage());
        getRecommendationsButton.addActionListener(e -> showRecommendations());
        showFootprintButton.addActionListener(e -> showFootprint());

        add(panel);
    }

    private void addProduct() {
        Product product = createProductFromInputs();
        database.addProduct(product);
        recommender.addProduct(product);
        footprintTracker.addProduct(product);
        JOptionPane.showMessageDialog(this, "Product added successfully!");
        clearFields();
    }

    private void showImpact() {
        if (database.getAllProducts().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No products available. Please add a product first.");
        } else {
            Product lastProduct = database.getAllProducts().get(database.getAllProducts().size() - 1);
            String impactReport = EnvironmentalImpactCalculator.calculateImpact(lastProduct);
            showReportDialog(impactReport, "Environmental Impact");
        }
    }

    private void processImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Product recognizedProduct = ImageProcessor.processImage(selectedFile.getAbsolutePath());
            populateFieldsFromProduct(recognizedProduct);
            JOptionPane.showMessageDialog(this, "Product recognized from image: " + recognizedProduct.getName());
        }
    }

    private void showRecommendations() {
        if (database.getAllProducts().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No products available. Please add some products first.");
        } else {
            List<String> recommendations = recommender.getRecommendations();
            StringBuilder report = new StringBuilder("AI Sustainability Recommendations:\n\n");
            for (int i = 0; i < recommendations.size(); i++) {
                report.append(i + 1).append(". ").append(recommendations.get(i)).append("\n");
            }
            showReportDialog(report.toString(), "AI Recommendations");
        }
    }

    private void showFootprint() {
        String footprintSummary = footprintTracker.getFootprintSummary();
        showReportDialog(footprintSummary, "Carbon Footprint and Rewards");
    }

    private Product createProductFromInputs() {
        return new Product(
            nameField.getText(),
            categoryField.getText(),
            recyclableBox.isSelected(),
            carbonSlider.getValue(),
            waterSlider.getValue(),
            energySlider.getValue(),
            rawMaterialsField.getText(),
            manufacturingField.getText(),
            disposalField.getText()
        );
    }

    private void populateFieldsFromProduct(Product product) {
        nameField.setText(product.getName());
        categoryField.setText(product.getCategory());
        recyclableBox.setSelected(product.isRecyclable());
        carbonSlider.setValue(product.getCarbonFootprint());
        waterSlider.setValue(product.getWaterUsage());
        energySlider.setValue(product.getEnergyConsumption());
        rawMaterialsField.setText(product.getRawMaterials());
        manufacturingField.setText(product.getManufacturingProcess());
        disposalField.setText(product.getDisposalMethod());
    }

    private void clearFields() {
        nameField.setText("");
        categoryField.setText("");
        recyclableBox.setSelected(false);
        carbonSlider.setValue(5);
        waterSlider.setValue(5);
        energySlider.setValue(5);
        rawMaterialsField.setText("");
        manufacturingField.setText("");
        disposalField.setText("");
    }

    private void showReportDialog(String report, String title) {
        JTextArea textArea = new JTextArea(report);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(this, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TalaGUI().setVisible(true);
        });
    }
}
