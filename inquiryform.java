import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inquiryform {
    private JButton button1;
    private JPanel inquiry;
    private JLabel balance;
    private JButton button2;

    JFrame dep = new JFrame();

    Customer customer;
    BankAccount account;

    inquiryform(Customer customer){
        this.customer = customer;
        this.account = account;
        dep.setSize(600,600);
        dep.setVisible(true);
        dep.setContentPane(inquiry);
        dep.getContentPane().setBackground(new Color(0xD5DCF9));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dep.dispose();
                new home(customer);
            }
        });
    }

    public void check(){
        double balanceAmount = customer.getAccount().getInitialBalance();

        // Log the balance inquiry as a transaction
        //Transactions trans = new Transactions("inquiry", balanceAmount);

       customer.getAccount().PerformTransaction("inquiry", balanceAmount);

        balance.setText("Balance: " + balanceAmount);


    }


}
