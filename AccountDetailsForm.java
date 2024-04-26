import javax.swing.*;
import java.awt.*;

public class AccountDetailsForm extends JFrame {
    private JLabel UID, Name, Username, Password, PhoneNo, Address, AccountType, Balance, userImage;
    private JButton backButton;

    Customer customer;

    public AccountDetailsForm(Customer customer) {
        this.customer = customer;
        setTitle("Account Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.setBackground(new Color(0xD5DCF9));
        UID = new JLabel("UID: " + customer.UID);
        UID.setFont(new Font("Arial", Font.PLAIN, 24));
        Name = new JLabel("Name: " + customer.getFName() + " " + customer.getLName());
        Name.setFont(new Font("Arial", Font.PLAIN, 24));
        Username = new JLabel("Username: " + customer.getUsername());
        Username.setFont(new Font("Arial", Font.PLAIN, 24));
        Password = new JLabel("Password: " + customer.getPassword());
        Password.setFont(new Font("Arial", Font.PLAIN, 24));
        PhoneNo = new JLabel("Phone Number: " + customer.getPhoneNo());
        PhoneNo.setFont(new Font("Arial", Font.PLAIN, 24));
        Address = new JLabel("Address: " + customer.getAddress());
        Address.setFont(new Font("Arial", Font.PLAIN, 24));
        AccountType = new JLabel("Account Type: " + customer.getAccount().getAccountType());
        AccountType.setFont(new Font("Arial", Font.PLAIN, 24));
        Balance = new JLabel("Balance: $" + customer.getAccount().InitialBalance);
        Balance.setFont(new Font("Arial", Font.BOLD, 36));

        // Load the user silhouette image and scale it by 50%
        ImageIcon userIcon = new ImageIcon("Banking_System/Images/UserSillhoute.png");
        Image image = userIcon.getImage().getScaledInstance(userIcon.getIconWidth() / 3, userIcon.getIconHeight() / 3, Image.SCALE_SMOOTH);
        userIcon = new ImageIcon(image);
        userImage = new JLabel(userIcon);

        backButton = new JButton("Back to Home Page");
        backButton.setFont(new Font("Arial", Font.PLAIN, 24));

        // Position the user silhouette image in the top right corner
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;  // Set grid width to 1 cell
        gbc.gridheight = 3; // Set grid height to span 3 cells
        panel.add(userImage, gbc);

        // Add other components
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;  // Reset grid width to 1 cell
        gbc.gridheight = 1; // Reset grid height to 1 cell
        panel.add(UID, gbc);
        gbc.gridy = 1;
        panel.add(Name, gbc);
        gbc.gridy = 2;
        panel.add(Username, gbc);
        gbc.gridy = 3;
        panel.add(Password, gbc);
        gbc.gridy = 4;
        panel.add(PhoneNo, gbc);
        gbc.gridy = 5;
        panel.add(Address, gbc);
        gbc.gridy = 6;
        panel.add(AccountType, gbc);
        gbc.gridy = 7;
        panel.add(Balance, gbc);
        gbc.gridy = 8;
        panel.add(backButton, gbc);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);

        backButton.addActionListener(e -> {
            new home(customer);
            dispose();
        });
    }
}
