import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame  {
    private JButton Deposit;
    private JButton withdrawButton;
    private JButton loanProcessingButton;
    private JButton transferButton;
    private JButton inquiryButton;
    private JButton transactionHistoryButton;
    private JPanel home;
    private JButton accountDetailsButton;
    private JLabel welcome;
    private JButton ManageAccount;
    private JButton SignOut;

    JFrame frame = new JFrame();

    private Customer customer; // Declare a Customer object



    home(Customer customer){
        this.customer = customer;
       frame.setSize(600,600);
       frame.setVisible(true);
       frame.setContentPane(home);
       welcome();

       inquiryButton.addActionListener(e -> {

           gotodeposit();
            frame.dispose();
       });

       transferButton.addActionListener(e-> {
           new TransferForm(customer);
           frame.dispose();

       });

       accountDetailsButton.addActionListener(e-> {
           new AccountDetailsForm(customer);
           frame.dispose();

       });

        SignOut.addActionListener(e-> {
            new LoginPage(Customer.logininfo);
            frame.dispose();

        });

        ManageAccount.addActionListener(e-> {
            new ManageAccountForm(customer);
            frame.dispose();

        });
   }

public void gotodeposit(){
   inquiryform nav = new inquiryform( customer);

}

public void welcome(){
        welcome.setText("welcome " + customer.FName);
}

}
