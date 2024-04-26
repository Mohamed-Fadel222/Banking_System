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
     BankAccount account;


    home(Customer customer){
        this.customer = customer;
        this.account = account;
       frame.setSize(600,600);
       frame.setVisible(true);
       frame.setContentPane(home);
       welcome();



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

        transactionHistoryButton.addActionListener(e-> {
            new transform(customer);
            frame.dispose();

        });

       inquiryButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               new inquiryform(customer);
               frame.dispose();
           }
       });
       loanProcessingButton.addActionListener(e-> {
            new LoanProcessingForm(customer);
            frame.dispose();
        });
       Deposit.addActionListener(e -> {
           new DepositForm(customer);
           frame.dispose();
       });
        withdrawButton.addActionListener(e -> {
            new WithdrawForm(customer);
            frame.dispose();
        });
   }





public void welcome(){
        welcome.setText("welcome " + customer.FName);
}

}
