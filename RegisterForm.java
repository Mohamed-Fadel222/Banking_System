import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm implements ActionListener {
    private JFrame frame;
    private JLabel firstNameLabel, lastNameLabel, usernameLabel, passwordLabel, phoneNoLabel, addressLabel, accountTypeLabel;
    private JTextField firstNameField, lastNameField, usernameField, phoneNoField, addressField, accountTypeField;
    private JPasswordField passwordField;
    private JButton registerButton, loginButton;



    public RegisterForm() {
        frame = new JFrame("Register");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null); // Use null layout
        frame.getContentPane().setBackground(new Color(0xD5DCF9));
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

        // Initialize buttons
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        loginButton = new JButton("already signed in"); // Initialize login button
        loginButton.addActionListener(this);

        // Set bounds for components
        int labelWidth = 120;
        int labelHeight = 30;
        int fieldWidth = 300;
        int fieldHeight = 30;
        int buttonWidth = 200;
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
        loginButton.setBounds((frame.getWidth() - buttonWidth) / 2, startY + 8 * (labelHeight + padding), buttonWidth, buttonHeight); // Set bounds for login button

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
        frame.add(loginButton); // Add login button to frame

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String fName = firstNameField.getText();
            String lName = lastNameField.getText();
            String username = usernameField.getText().toLowerCase(); // Convert username to lowercase
            String actualUsername = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String phoneNo = phoneNoField.getText();
            String address = addressField.getText();
            String accountType = accountTypeField.getText();

            // Check if all fields are filled
            if (fName.isEmpty() || lName.isEmpty() || username.isEmpty() || password.isEmpty() || phoneNo.isEmpty() || address.isEmpty() || accountType.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                return;
            }

            double initialBalance = 0; // Assume initial balance is 0

            if (!Customer.logininfo.containsKey(username.toLowerCase())) {
                Register register = new Register();
                Customer newCustomer=register.RegisterAccount(username, fName, lName, password, phoneNo, address, accountType, initialBalance);
                newCustomer.setActualUsername(actualUsername);
                JOptionPane.showMessageDialog(frame, "Registration successful!");

                // Create a new Customer object
                //Customer newCustomer = new Customer(fName, lName, username, password, phoneNo, address, accountType, initialBalance);

                // Add the new customer to the list of users
                 // Add username and password to logininfo HashMap


                // Navigate to the home page
                new home(newCustomer);

                // Dispose the register frame
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "User is already registered.");
            }
        } else if (e.getSource() == loginButton) {
            // Navigate to the login page
            new LoginPage(Customer.logininfo);

            // Dispose the register frame
            frame.dispose();
        }
    }
}