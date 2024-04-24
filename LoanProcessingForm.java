import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanProcessingForm extends JFrame {

    private Customer customer;

    private JLabel rateLabel;
    private JTextField rateField;
    private JLabel termLabel;
    private JTextField termField;
    private JLabel purposeLabel;
    private JTextField purposeField;
    private JCheckBox fixedRateCheckBox; // Checkbox for indicating fixed or variable rate
    private JButton applyButton;
    private JButton backButton;
    private JLabel errorLabel;

    public LoanProcessingForm(Customer customer) {
        this.customer = customer;

        setTitle("Loan Processing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        rateLabel = new JLabel("Interest Rate:");
        rateField = new JTextField(10);
        termLabel = new JLabel("Loan Term:");
        termField = new JTextField(10);
        purposeLabel = new JLabel("Purpose:");
        purposeField = new JTextField(20);
        fixedRateCheckBox = new JCheckBox("Fixed Rate"); // Checkbox for indicating fixed or variable rate
        applyButton = new JButton("Apply");
        backButton = new JButton("Back");
        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(rateLabel, gbc);
        gbc.gridx = 1;
        panel.add(rateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(termLabel, gbc);
        gbc.gridx = 1;
        panel.add(termField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(purposeLabel, gbc);
        gbc.gridx = 1;
        panel.add(purposeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(fixedRateCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(applyButton, gbc);

        gbc.gridy = 5;
        panel.add(backButton, gbc);

        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(errorLabel, gbc);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyForLoan();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the home page
                new home(customer);
                dispose(); // Close the current window
            }
        });
    }

    private void applyForLoan() {
        String rateText = rateField.getText();
        String term = termField.getText();
        String purpose = purposeField.getText();
        boolean isFixedRate = fixedRateCheckBox.isSelected(); // Get the value of the checkbox

        if (rateText.isEmpty() || term.isEmpty() || purpose.isEmpty()) {
            errorLabel.setText("Please fill in all fields.");
        } else {
            try {
                double rate = Double.parseDouble(rateText);
                LoanProcessing loanProcessing = new LoanProcessing(customer);
                if (loanProcessing.CheckEligibility(customer, rate, isFixedRate, term, purpose)) {
                    loanProcessing.ApplyForLoan(customer, rate, isFixedRate, term, purpose);
                    JOptionPane.showMessageDialog(this, "Loan application submitted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    errorLabel.setText("Sorry, you are not eligible for the loan.");
                }
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid interest rate.");
            }
        }
    }
}
