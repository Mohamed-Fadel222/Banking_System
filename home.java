import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame {
    private JButton Deposit;
    private JButton withdrawButton;
    private JButton loanProcessingButton;
    private JButton transferButton;
    private JButton inquiryButton;
    private JButton transactionHistoryButton;
    private JButton accountDetailsButton;
    private JButton ManageAccount;
    private JButton SignOut;
    private JPanel home;
    private JLabel welcome;

    private Customer customer; // Declare a Customer object
    BankAccount account;

    JFrame frame = new JFrame();

    home(Customer customer) {
        this.customer = customer;
        this.account = account;
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setContentPane(home);
        welcome();

        frame.getContentPane().setBackground(new Color(0xD5DCF9));

        // Set buttons as rounded buttons
        setRoundedButton(Deposit);
        setRoundedButton(withdrawButton);
        setRoundedButton(loanProcessingButton);
        setRoundedButton(transferButton);
        setRoundedButton(inquiryButton);
        setRoundedButton(transactionHistoryButton);
        setRoundedButton(accountDetailsButton);
        setRoundedButton(ManageAccount);
        setRoundedButton(SignOut);

        // Add action listeners for each button

        // Transfer button action
        transferButton.addActionListener(e -> {
            new TransferForm(customer);
            frame.dispose();
        });

        // Account details button action
        accountDetailsButton.addActionListener(e -> {
            new AccountDetailsForm(customer);
            frame.dispose();
        });

        // Sign out button action
        SignOut.addActionListener(e -> {
            new LoginPage(Customer.logininfo);
            frame.dispose();
        });

        // Manage account button action
        ManageAccount.addActionListener(e -> {
            new ManageAccountForm(customer);
            frame.dispose();
        });

        // Transaction history button action
        transactionHistoryButton.addActionListener(e -> {
            new transform(customer);
            frame.dispose();
        });

        // Inquiry button action
        inquiryButton.addActionListener(e -> {
            new inquiryform(customer);
            frame.dispose();
        });

        // Loan processing button action
        loanProcessingButton.addActionListener(e -> {
            new LoanProcessingForm(customer);
            frame.dispose();
        });

        // Deposit button action
        Deposit.addActionListener(e -> {
            new DepositForm(customer);
            frame.dispose();
        });

        // Withdraw button action
        withdrawButton.addActionListener(e -> {
            new WithdrawForm(customer);
            frame.dispose();
        });
    }

    public void welcome() {
        welcome.setText("Welcome " + customer.FName);
    }

    // Method to set rounded button style
    private void setRoundedButton(JButton button) {
        button.setOpaque(true); // Set opaque to true to make the button background visible
        button.setContentAreaFilled(true); // Fill the content area with the background color
        button.setBorderPainted(false); // Remove the border
        button.setFocusPainted(false); // Remove the focus border
        button.setBackground(new Color(0x639cd9)); // Set the background color
        button.setForeground(Color.WHITE); // Set text color
        button.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size as needed
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Set cursor on hover
    }

}
