import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Create components
        JLabel inputLabel = new JLabel("     Enter Temperature:");
        JTextField inputField = new JTextField();
        JLabel scaleLabel = new JLabel("     Select Scale:");
        String[] scales = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> scaleComboBox = new JComboBox<>(scales);
        JButton convertButton = new JButton("Convert");
        convertButton.setBackground(Color.GREEN);
        convertButton.setForeground(Color.GRAY);
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Add components to frame
        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(scaleLabel);
        frame.add(scaleComboBox);
        frame.add(new JLabel()); // Empty placeholder
        frame.add(convertButton);
        frame.add(new JLabel("     Conversion Results:"));
        frame.add(resultArea);

        // Event handling for conversion
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputTemp = Double.parseDouble(inputField.getText());
                    String scale = (String) scaleComboBox.getSelectedItem();
                    StringBuilder results = new StringBuilder();

                    if (scale.equals("Celsius")) {
                        results.append("Fahrenheit: ").append(celsiusToFahrenheit(inputTemp)).append("\n");
                        results.append("Kelvin: ").append(celsiusToKelvin(inputTemp)).append("\n");
                    } else if (scale.equals("Fahrenheit")) {
                        results.append("Celsius: ").append(fahrenheitToCelsius(inputTemp)).append("\n");
                        results.append("Kelvin: ").append(fahrenheitToKelvin(inputTemp)).append("\n");
                    } else if (scale.equals("Kelvin")) {
                        results.append("Celsius: ").append(kelvinToCelsius(inputTemp)).append("\n");
                        results.append("Fahrenheit: ").append(kelvinToFahrenheit(inputTemp)).append("\n");
                    }

                    resultArea.setText(results.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Display frame
        frame.setVisible(true);
    }

    // Conversion methods
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return celsiusToKelvin(fahrenheitToCelsius(fahrenheit));
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return celsiusToFahrenheit(kelvinToCelsius(kelvin));
    }
}
