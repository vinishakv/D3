import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Simple GUI calculator for sinh(x) using a Taylor-series approximation.
 *
 * <p>File: SinhCalculatorGui.java
 */
public class SinhCalculatorGui extends JFrame {
  private static final long serialVersionUID = 1L;

  private static final int TAYLOR_TERMS = 10;
  private static final int DEFAULT_WIDTH = 400;
  private static final int DEFAULT_HEIGHT = 200;

  private final JTextField inputField;
  private final JLabel resultLabel;

  /**
   * Creates the Sinh calculator GUI.
   */
  public SinhCalculatorGui() {
    super("Sinh(x) Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(3, 1));
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setLocationRelativeTo(null);

    // Input panel
    JPanel inputPanel = new JPanel();
    inputPanel.add(new JLabel("Enter value for x: "));
    inputField = new JTextField(15);
    inputField.setToolTipText("Type a real number (e.g., 1.23 or -0.5)");
    inputField.getAccessibleContext().setAccessibleName("Input for x");
    inputPanel.add(inputField);

    // Button
    JButton calculateButton = new JButton("Calculate sinh(x)");
    calculateButton.setMnemonic(KeyEvent.VK_C);
    calculateButton.setToolTipText("Compute sinh(x)");
    calculateButton
        .getAccessibleContext()
        .setAccessibleDescription("Compute the hyperbolic sine of the input");
    calculateButton.addActionListener(this::onCalculate);

    // Result display
    resultLabel = new JLabel("Result will be shown here", SwingConstants.CENTER);

    add(inputPanel);
    add(calculateButton);
    add(resultLabel);

    setVisible(true);
  }

  /**
   * Event handler for the Calculate button.
   *
   * @param e the ActionEvent triggered when the button is clicked
   */
  private void onCalculate(ActionEvent e) {
    String inputText = inputField.getText().trim();
    if (inputText.isEmpty()) {
      resultLabel.setText("Error: Please enter a value.");
      return;
    }

    try {
      double x = Double.parseDouble(inputText);
      double result = sinh(x);
      DecimalFormat df = new DecimalFormat("#.#####");
      resultLabel.setText(
          String.format("sinh(%s) = %s", df.format(x), df.format(result)));
    } catch (NumberFormatException ex) {
      resultLabel.setText("Error: Invalid input. Please enter a real number.");
      System.err.println("Invalid input: " + ex.getMessage());
    } catch (RuntimeException ex) {
      resultLabel.setText("Unexpected error occurred.");
      ex.printStackTrace();
    }
  }

  /**
   * Approximate sinh(x) using a Taylor series.
   *
   * @param x input value
   * @return approximation of sinh(x)
   */
  public static double sinh(double x) {
    double term = x;
    double result = x;
    for (int i = 1; i < TAYLOR_TERMS; i++) {
      term *= x * x / ((2 * i) * (2 * i + 1));
      result += term;
    }
    return result;
  }

  /**
   * Main method to launch the GUI.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new SinhCalculatorGui());
  }
}
