import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawForm implements ActionListener {
    private JFrame frame;
    private JLabel withdrawLabel;
    private JTextField amountField;
    private JButton confirmButton;
    private JButton homeButton;
    private Customer customer;

    public WithdrawForm(Customer customer) {
        this.customer = customer;

        frame = new JFrame("Withdraw");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null); // Use null layout

        withdrawLabel = new JLabel("Enter the amount to withdraw: Current Balance is "+ customer.getAccount().InitialBalance);
        amountField = new JTextField();
        confirmButton = new JButton("Confirm");
        homeButton = new JButton("Home");

        confirmButton.addActionListener(this);
        homeButton.addActionListener(this);

        frame.add(withdrawLabel);
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

        withdrawLabel.setBounds((frame.getWidth() - labelWidth) / 2, startY, labelWidth, labelHeight);
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
            } else if (amount > customer.getAccount().InitialBalance) {
                JOptionPane.showMessageDialog(frame, "Insufficient funds. Please enter an amount less than or equal to your current balance.");
            } else {
                customer.withdraw(amount);
                JOptionPane.showMessageDialog(frame, "Withdrawn " + amount + " from your account.");
                withdrawLabel.setText("Enter the amount to withdraw: Current Balance is "+ customer.getAccount().InitialBalance);
                amountField.setText("");
            }
        } else if (e.getSource() == homeButton) {
            frame.dispose();
            new home(customer); // Assuming you have a Home class that represents the home window
        }
    }
}