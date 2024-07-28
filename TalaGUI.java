import javax.swing. *;
import java.awt. *;
import java.io.File;
import java.util.List;

public class TalaGUI extends JFrame {

  // Core componentes of the application

  // GUI components
  private JTextField namField, categoryField, rawMaterialsField, manufacturingField, disposalField;
  private JCheckBox recyclabeBox;
  private JSlider carbonSlider, waterSlider, energySlider;

  public TalaGUI () {
    // Set up teh main window
    setTitle("Tala");
    setSize(500,750);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the main panel with a grid layout
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(14, 2));

    // Intialize Input Components
    namField = new JTextField();
    categoryField = new JTextField();
    recyclabeBox = new JCheckBox();
    carbonSlider = new JSlider(1, 10);
    waterSlider = new JSlider(1, 10);
    energySlider = new JSlider(1,10);
    rawMaterialsField = new JTextField();
    manufacturingField = new JTextField();
    disposalField = new JTextField();

    // Create buttons for various actions
    JButton addButton = new JButton("Add Product");
    JButton showImpactButton = new JButton("Show Environmental Impact");
    JButton imageProcessButton = new JButton("Input from Image");
    JButton getRecommendationsButton = new JButton("Get AI Recommendations");
    JButton showFootprintButton = new JButton("Show Carbon Footprint");

    //Add components to the panel
    panel.add(new JLabel("Name:"));
    panel.add(new JLabel("Category:"));
    panel.add(new JLabel("Recyclable:"));
    panel.add(new JLabel("Carbon Footprint(1-10):"));
    panel.add(new JLabel("Water Usage(1-10):"));
    panel.add(new JLabel("Energy Consumptions(1-10):"));
    panel.add(new JLabel("Raw Materials:"));
    panel.add(new JLabel("Manufacturing Process:"));
    panel.add(new JLabel("Disposal Method:"));
    panel.add(disposalField);
    panel.add(addButton);
    panel.add(showImpactButton);
    panel.add(imageProcessButton);
    panel.add(getRecommendationsButton);
    panel.add(showFootprintButton);

  }
}
