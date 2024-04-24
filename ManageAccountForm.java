import javax.swing.*;
import java.awt.*;

public class ManageAccountForm extends JFrame {

    private JFrame frame = new JFrame();
    private JLabel fName, lName, userName, password, phoneNo, address, errorLabel;
    private JTextField fNameField, lNameField, userNameField, passwordField, phoneNoField, addressField;
    private JButton confirmChangesButton, backToHomePageButton;


String OldUserName;
    public ManageAccountForm(Customer customer) {
         OldUserName = customer.getUsername().toLowerCase();
        frame.setTitle("Manage Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10)); // Added spacing between items

        fName = new JLabel("Change First Name:");
        lName = new JLabel("Change Last Name:");
        userName = new JLabel("Change Username:");
        password = new JLabel("Change Password:");
        phoneNo = new JLabel("Change Phone Number:");
        address = new JLabel("Change Address:");
        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED); // Set text color to red for error messages

        fNameField = new JTextField(customer.getFName());
        lNameField = new JTextField(customer.getLName());
        userNameField = new JTextField(customer.getUsername());
        passwordField = new JTextField(customer.getPassword());
        phoneNoField = new JTextField(customer.getPhoneNo());
        addressField = new JTextField(customer.getAddress());

        confirmChangesButton = new JButton("Confirm Changes");
        confirmChangesButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally

        backToHomePageButton = new JButton("Back to Homepage");


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Panel for buttons with horizontal layout


        buttonPanel.add(confirmChangesButton);
        buttonPanel.add(backToHomePageButton);

        panel.add(fName);
        panel.add(fNameField);
        panel.add(lName);
        panel.add(lNameField);
        panel.add(userName);
        panel.add(userNameField);
        panel.add(password);
        panel.add(passwordField);
        panel.add(phoneNo);
        panel.add(phoneNoField);
        panel.add(address);
        panel.add(addressField);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(errorLabel);
        panel.add(buttonPanel); // Add the button panel instead of individual buttons

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        confirmChangesButton.addActionListener(e -> {
            String newUsername = userNameField.getText().toLowerCase();
            if(!Customer.logininfo.containsKey(newUsername) || OldUserName.equals(userNameField.getText().toLowerCase()))
            {

                Customer.logininfo.remove(customer.getUsername(),customer.getPassword());
                customer.setFName(fNameField.getText());
                customer.setLName(lNameField.getText());
                customer.setUsername(newUsername.toLowerCase());
                customer.setPassword(passwordField.getText());
                customer.setPhoneNo(phoneNoField.getText());
                customer.setAddress(addressField.getText());
                Customer.logininfo.put(customer.getUsername(),customer.getPassword());

                // You can add more setters as needed for other attributes
                errorLabel.setText(""); // Clear any previous error message
                // Notify user of successful changes
                JOptionPane.showMessageDialog(frame, "Changes confirmed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                OldUserName = userNameField.getText();
            }
            else
            {
                errorLabel.setText("Username " + customer.getUsername() + " already exists");
            }
        });

        backToHomePageButton.addActionListener(e -> {
            // Handle going back to the homepage here
            frame.dispose(); // Close the current window
            new home(customer); // Open the homepage
        });
    }


}
