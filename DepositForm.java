import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositForm implements ActionListener {
    private JFrame frame;
    private JLabel depositLabel;
    private JTextField amountField;
    private JButton confirmButton;
    private JButton homeButton;
    private Customer customer;

    public DepositForm(Customer customer) {
        this.customer = customer;

        frame = new JFrame("Deposit");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null); // Use null layout

        depositLabel = new JLabel("Enter the amount to deposit: Current Balance is "+ customer.getAccount().InitialBalance);
        amountField = new JTextField();
        confirmButton = new JButton("Confirm");
        homeButton = new JButton("Home");

        confirmButton.addActionListener(this);
        homeButton.addActionListener(this);

        frame.add(depositLabel);
        frame.add(amountField);
        frame.add(confirmButton);
        frame.add(homeButton);

        // Set bounds for components
        int labelWidth = 320;
        int labelHeight = 60;
        int fieldWidth = 250;
        int fieldHeight = 30;
        int buttonWidth = 100;
        int buttonHeight = 30;

        int horizontalPadding = 20;
        int verticalPadding = 10;

        int startY = (frame.getHeight() - labelHeight - fieldHeight - buttonHeight - 4 * verticalPadding) / 2;

        depositLabel.setBounds((frame.getWidth() - labelWidth) / 2, startY, labelWidth, labelHeight);
        amountField.setBounds((frame.getWidth() - fieldWidth) / 2, startY + labelHeight + verticalPadding, fieldWidth, fieldHeight);
        confirmButton.setBounds((frame.getWidth() - buttonWidth) / 2, startY + 2 * (labelHeight + verticalPadding) + fieldHeight, buttonWidth, buttonHeight);
        homeButton.setBounds((frame.getWidth() - buttonWidth) / 2, startY + 3 * (labelHeight + verticalPadding) + 2 * fieldHeight, buttonWidth, buttonHeight);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(frame, "Invalid amount. Amount must be greater than 0.");
            } else {
                customer.deposit(amount);
                JOptionPane.showMessageDialog(frame, "Deposited " + amount + " to your account.");
                depositLabel.setText("Enter the amount to deposit: Current Balance is "+ customer.getAccount().InitialBalance);
                amountField.setText("");
            }
        } else if (e.getSource() == homeButton) {
            frame.dispose();
            new home(customer); // Assuming you have a Home class that represents the home window
        }
    }
}