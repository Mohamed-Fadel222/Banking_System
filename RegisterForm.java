import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm implements ActionListener {
    private JFrame frame;
    private JLabel firstNameLabel, lastNameLabel, usernameLabel, passwordLabel, phoneNoLabel, addressLabel, accountTypeLabel;
    private JTextField firstNameField, lastNameField, usernameField, phoneNoField, addressField, accountTypeField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterForm() {
        frame = new JFrame("Register");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null); // Use null layout

        // Initialize labels
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        phoneNoLabel = new JLabel("Phone Number:");
        addressLabel = new JLabel("Address:");
        accountTypeLabel = new JLabel("Account Type:");

        // Initialize text fields
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        phoneNoField = new JTextField();
        addressField = new JTextField();
        accountTypeField = new JTextField();

        // Initialize button
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        // Set bounds for components
        int labelWidth = 120;
        int labelHeight = 30;
        int fieldWidth = 250;
        int fieldHeight = 30;
        int buttonWidth = 100;
        int buttonHeight = 30;

        int startY = 10;
        int padding = 10;

        firstNameLabel.setBounds(padding, startY, labelWidth, labelHeight);
        firstNameField.setBounds(padding + labelWidth, startY, fieldWidth, fieldHeight);

        lastNameLabel.setBounds(padding, startY + (labelHeight + padding), labelWidth, labelHeight);
        lastNameField.setBounds(padding + labelWidth, startY + (labelHeight + padding), fieldWidth, fieldHeight);

        usernameLabel.setBounds(padding, startY + 2 * (labelHeight + padding), labelWidth, labelHeight);
        usernameField.setBounds(padding + labelWidth, startY + 2 * (labelHeight + padding), fieldWidth, fieldHeight);

        passwordLabel.setBounds(padding, startY + 3 * (labelHeight + padding), labelWidth, labelHeight);
        passwordField.setBounds(padding + labelWidth, startY + 3 * (labelHeight + padding), fieldWidth, fieldHeight);

        phoneNoLabel.setBounds(padding, startY + 4 * (labelHeight + padding), labelWidth, labelHeight);
        phoneNoField.setBounds(padding + labelWidth, startY + 4 * (labelHeight + padding), fieldWidth, fieldHeight);

        addressLabel.setBounds(padding, startY + 5 * (labelHeight + padding), labelWidth, labelHeight);
        addressField.setBounds(padding + labelWidth, startY + 5 * (labelHeight + padding), fieldWidth, fieldHeight);

        accountTypeLabel.setBounds(padding, startY + 6 * (labelHeight + padding), labelWidth, labelHeight);
        accountTypeField.setBounds(padding + labelWidth, startY + 6 * (labelHeight + padding), fieldWidth, fieldHeight);

        registerButton.setBounds((frame.getWidth() - buttonWidth) / 2, startY + 7 * (labelHeight + padding), buttonWidth, buttonHeight);

        // Add components to frame
        frame.add(firstNameLabel);
        frame.add(firstNameField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(phoneNoLabel);
        frame.add(phoneNoField);
        frame.add(addressLabel);
        frame.add(addressField);
        frame.add(accountTypeLabel);
        frame.add(accountTypeField);
        frame.add(registerButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String fName = firstNameField.getText();
            String lName = lastNameField.getText();
            String username = usernameField.getText().toLowerCase(); // Convert username to lowercase
            String password = String.valueOf(passwordField.getPassword());
            String phoneNo = phoneNoField.getText();
            String address = addressField.getText();
            String accountType = accountTypeField.getText();
            double initialBalance = 0; // Assume initial balance is 0

            // Create a new customer and add to the list
            Customer newCustomer = new Customer(fName, lName, username, password, phoneNo, address, accountType, initialBalance);
            Customer.customers.add(newCustomer);
            Customer.logininfo.put(newCustomer.Username.toString(), newCustomer.Password.toString()); // Add username and password to logininfo HashMap

            JOptionPane.showMessageDialog(frame, "Registration successful!");

            // Navigate to the home page
            new home(newCustomer);

            // Dispose the register frame
            frame.dispose();
        }
    }
}