import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inquiryform {
    private JButton button1;
    private JPanel inquiry;
    private JLabel balance;

    JFrame dep = new JFrame();

    Customer customer;
    inquiryform(Customer customer){
        this.customer = customer;
        dep.setSize(600,600);
        dep.setVisible(true);
        dep.setContentPane(inquiry);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });
    }

    public void check(){
        double balanceAmount = customer.getAccount().getInitialBalance();
        balance.setText("Balance: " + balanceAmount);
        balance.setText(String.valueOf(balanceAmount));

    }


}
