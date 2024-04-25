import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferForm implements ActionListener {

    JFrame frame = new JFrame();
    JTextField  customerNameField, amountField;
    JButton transferButton;

    JButton backButton;

    JLabel ErrorLabel,balanceLabel;
    int shiftFactor = -60; // New variable for shifting fields

    Customer transferer;

    public TransferForm(Customer customer) {
        // Set up the frame
        transferer = customer;
        frame.setTitle("Transfer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null); // Use null layout for fixed-size components

        // Load image
        ImageIcon icon = new ImageIcon("Banking_System/Images/transfericon.png");
        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon = new ImageIcon(newimg); // transform it backButton

        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(20, 20, icon.getIconWidth(), icon.getIconHeight());
        frame.add(imageLabel);

        // Create components

        JLabel informationLabel = new JLabel("<html><div style='text-align: center;'>"
                + "<p style='text-align: center;'>Welcome " + customer.FName + "!</p>"
                + "<p style='text-align: justify;'>"
                +  "<br>"
                + "This is where you can transfer funds<br>"
                + "to another customer, just type the<br>"
                + "customer's username and the amount<br>"
                + "you want to deposit!"
                + "</p>"
                + "</div></html>");

        JLabel nameLabel = new JLabel("Customer username:");
        customerNameField = new JTextField();
        JLabel amountLabel = new JLabel("Amount to Transfer:");
        amountField = new JTextField();
        transferButton = new JButton("Transfer");
        transferButton.addActionListener(this);

        backButton = new JButton("Back to HomePage");
        backButton.addActionListener(this);

        ErrorLabel = new JLabel();
        ErrorLabel.setBounds(170,470,250,20);
        balanceLabel = new JLabel("Your balance is " + transferer.getAccount().InitialBalance + "$");


        // Add components to the frame
        frame.add(informationLabel);
        frame.add(nameLabel);
        frame.add(customerNameField);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(transferButton);
        frame.add(backButton);
        frame.add(ErrorLabel);
        frame.add(balanceLabel);

        // Set bounds for components
        int labelWidth = 120;
        int labelHeight = 30;
        int fieldWidth = 250;
        int fieldHeight = 30;
        int buttonWidth = 100;
        int buttonHeight = 30;

        int horizontalPadding = 20;
        int verticalPadding = 10;

        int imageHeight = icon.getIconHeight();
        int startY = (frame.getHeight() - imageHeight - labelHeight - fieldHeight - buttonHeight - 4 * verticalPadding) / 2 + imageHeight + verticalPadding;

        // Apply shiftFactor to each field
        int shift = shiftFactor;
        informationLabel.setBounds(200,30,300,300);
        balanceLabel.setBounds(200,250,200,20);
        nameLabel.setBounds((frame.getWidth() - labelWidth) / 2, startY + shift, labelWidth, labelHeight);
        customerNameField.setBounds((frame.getWidth() - fieldWidth) / 2, startY + labelHeight + verticalPadding + shift, fieldWidth, fieldHeight);
        amountLabel.setBounds((frame.getWidth() - labelWidth) / 2, startY + 2 * (labelHeight + verticalPadding) + fieldHeight + shift, labelWidth, labelHeight);
        amountField.setBounds((frame.getWidth() - fieldWidth) / 2, startY + 3 * (labelHeight + verticalPadding) + fieldHeight + shift, fieldWidth, fieldHeight);
        transferButton.setBounds((frame.getWidth() - buttonWidth) / 2 + 75, startY + 4 * (labelHeight + verticalPadding) + 2 * fieldHeight + shift, buttonWidth , buttonHeight);
        backButton.setBounds((frame.getWidth() - buttonWidth) / 2 - 120, startY + 4 * (labelHeight + verticalPadding) + 2 * fieldHeight + shift, buttonWidth + 70, buttonHeight);

        // Display the frame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == transferButton) {

            if(Double.parseDouble(amountField.getText()) > 0) {
                if (Customer.customers.contains(transferer.getCustomerByName(customerNameField.getText().toLowerCase()))) {

                    if (transferer.getAccount().InitialBalance >= Double.parseDouble(amountField.getText())) {
                        transferer.transfer(Double.parseDouble(amountField.getText()), transferer.getCustomerByName(customerNameField.getText().toLowerCase()));
                        balanceLabel.setText("Your balance is " + transferer.getAccount().InitialBalance + "$");
                        ErrorLabel.setText("Successfully transferred " + amountField.getText() + "$ to " + customerNameField.getText());

                    } else {
                        ErrorLabel.setText("Insufficient funds");
                    }
                } else {
                    ErrorLabel.setText("The username " + customerNameField.getText() + " is not found!");
                }
            } else
            {
                ErrorLabel.setText("Invalid Amount (must be greater than 0$)");
            }

        } else if (e.getSource() == backButton) {

            frame.dispose();

            new home(transferer);

        }
    }
}
